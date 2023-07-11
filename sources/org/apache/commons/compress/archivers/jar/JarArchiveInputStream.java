package org.apache.commons.compress.archivers.jar;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
/* loaded from: classes.dex */
public class JarArchiveInputStream extends ZipArchiveInputStream {
    public JarArchiveInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public static boolean matches(byte[] bArr, int i) {
        return ZipArchiveInputStream.matches(bArr, i);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipArchiveInputStream, org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() throws IOException {
        return getNextJarEntry();
    }

    public JarArchiveEntry getNextJarEntry() throws IOException {
        ZipArchiveEntry nextZipEntry = getNextZipEntry();
        if (nextZipEntry == null) {
            return null;
        }
        return new JarArchiveEntry(nextZipEntry);
    }
}
