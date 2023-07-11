package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
class AES256SHA256Decoder extends CoderBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AES256SHA256Decoder() {
        super(new Class[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    public InputStream decode(final InputStream inputStream, long j, final Coder coder, final byte[] bArr) throws IOException {
        return new InputStream() { // from class: org.apache.commons.compress.archivers.sevenz.AES256SHA256Decoder.1
            private boolean isInitialized = false;
            private CipherInputStream cipherInputStream = null;

            private CipherInputStream init() throws IOException {
                byte[] digest;
                if (this.isInitialized) {
                    return this.cipherInputStream;
                }
                byte[] bArr2 = coder.properties;
                int i = bArr2[0] & 255;
                int i2 = i & 63;
                int i3 = bArr2[1] & 255;
                int i4 = ((i >> 6) & 1) + (i3 & 15);
                int i5 = ((i >> 7) & 1) + (i3 >> 4);
                int i6 = i5 + 2;
                if (i6 + i4 <= bArr2.length) {
                    byte[] bArr3 = new byte[i5];
                    System.arraycopy(bArr2, 2, bArr3, 0, i5);
                    byte[] bArr4 = new byte[16];
                    System.arraycopy(coder.properties, i6, bArr4, 0, i4);
                    if (bArr != null) {
                        if (i2 == 63) {
                            digest = new byte[32];
                            System.arraycopy(bArr3, 0, digest, 0, i5);
                            byte[] bArr5 = bArr;
                            System.arraycopy(bArr5, 0, digest, i5, Math.min(bArr5.length, digest.length - i5));
                        } else {
                            try {
                                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                                byte[] bArr6 = new byte[8];
                                for (long j2 = 0; j2 < (1 << i2); j2++) {
                                    messageDigest.update(bArr3);
                                    messageDigest.update(bArr);
                                    messageDigest.update(bArr6);
                                    for (int i7 = 0; i7 < bArr6.length; i7++) {
                                        bArr6[i7] = (byte) (bArr6[i7] + 1);
                                        if (bArr6[i7] != 0) {
                                            break;
                                        }
                                    }
                                }
                                digest = messageDigest.digest();
                            } catch (NoSuchAlgorithmException e) {
                                IOException iOException = new IOException("SHA-256 is unsupported by your Java implementation");
                                iOException.initCause(e);
                                throw iOException;
                            }
                        }
                        SecretKeySpec secretKeySpec = new SecretKeySpec(digest, "AES");
                        try {
                            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr4));
                            this.cipherInputStream = new CipherInputStream(inputStream, cipher);
                            this.isInitialized = true;
                            return this.cipherInputStream;
                        } catch (GeneralSecurityException e2) {
                            IOException iOException2 = new IOException("Decryption error (do you have the JCE Unlimited Strength Jurisdiction Policy Files installed?)");
                            iOException2.initCause(e2);
                            throw iOException2;
                        }
                    }
                    throw new IOException("Cannot read encrypted files without a password");
                }
                throw new IOException("Salt size + IV size too long");
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                return init().read();
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr2, int i, int i2) throws IOException {
                return init().read(bArr2, i, i2);
            }
        };
    }
}
