package com.squareup.okhttp;

import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import okio.Buffer;
/* loaded from: classes.dex */
public final class HttpUrl {
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
    static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.squareup.okhttp.HttpUrl$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$okhttp$HttpUrl$Builder$ParseResult = new int[Builder.ParseResult.values().length];

        static {
            try {
                $SwitchMap$com$squareup$okhttp$HttpUrl$Builder$ParseResult[Builder.ParseResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$okhttp$HttpUrl$Builder$ParseResult[Builder.ParseResult.INVALID_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$okhttp$HttpUrl$Builder$ParseResult[Builder.ParseResult.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$okhttp$HttpUrl$Builder$ParseResult[Builder.ParseResult.MISSING_SCHEME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$squareup$okhttp$HttpUrl$Builder$ParseResult[Builder.ParseResult.INVALID_PORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        String encodedFragment;
        List<String> encodedQueryNamesAndValues;
        String host;
        String scheme;
        String encodedUsername = HttpUrl.FRAGMENT_ENCODE_SET;
        String encodedPassword = HttpUrl.FRAGMENT_ENCODE_SET;
        int port = -1;
        final List<String> encodedPathSegments = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum ParseResult {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Builder() {
            this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
        }

        private static String canonicalizeHost(String str, int i, int i2) {
            String percentDecode = HttpUrl.percentDecode(str, i, i2, false);
            if (percentDecode.startsWith("[") && percentDecode.endsWith("]")) {
                InetAddress decodeIpv6 = decodeIpv6(percentDecode, 1, percentDecode.length() - 1);
                if (decodeIpv6 == null) {
                    return null;
                }
                byte[] address = decodeIpv6.getAddress();
                if (address.length == 16) {
                    return inet6AddressToAscii(address);
                }
                throw new AssertionError();
            }
            return domainToAscii(percentDecode);
        }

        private static boolean containsInvalidHostnameAsciiCodes(String str) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i5++;
                    }
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            return i4 == i3 + 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.net.InetAddress decodeIpv6(java.lang.String r10, int r11, int r12) {
            /*
                r0 = 16
                byte[] r0 = new byte[r0]
                r1 = -1
                r2 = 0
                r3 = 0
                r4 = -1
                r5 = -1
            L9:
                r6 = 0
                if (r11 >= r12) goto L7c
                int r7 = r0.length
                if (r3 != r7) goto L10
                return r6
            L10:
                int r7 = r11 + 2
                if (r7 > r12) goto L29
                r8 = 2
                java.lang.String r9 = "::"
                boolean r8 = r10.regionMatches(r11, r9, r2, r8)
                if (r8 == 0) goto L29
                if (r4 == r1) goto L20
                return r6
            L20:
                int r3 = r3 + 2
                if (r7 != r12) goto L26
                r4 = r3
                goto L7c
            L26:
                r4 = r3
                r5 = r7
                goto L4d
            L29:
                if (r3 == 0) goto L4c
                r7 = 1
                java.lang.String r8 = ":"
                boolean r8 = r10.regionMatches(r11, r8, r2, r7)
                if (r8 == 0) goto L37
                int r11 = r11 + 1
                goto L4c
            L37:
                java.lang.String r8 = "."
                boolean r11 = r10.regionMatches(r11, r8, r2, r7)
                if (r11 == 0) goto L4b
                int r11 = r3 + (-2)
                boolean r10 = decodeIpv4Suffix(r10, r5, r12, r0, r11)
                if (r10 != 0) goto L48
                return r6
            L48:
                int r3 = r3 + 2
                goto L7c
            L4b:
                return r6
            L4c:
                r5 = r11
            L4d:
                r11 = r5
                r7 = 0
            L4f:
                if (r11 >= r12) goto L62
                char r8 = r10.charAt(r11)
                int r8 = com.squareup.okhttp.HttpUrl.decodeHexDigit(r8)
                if (r8 != r1) goto L5c
                goto L62
            L5c:
                int r7 = r7 << 4
                int r7 = r7 + r8
                int r11 = r11 + 1
                goto L4f
            L62:
                int r8 = r11 - r5
                if (r8 == 0) goto L7b
                r9 = 4
                if (r8 <= r9) goto L6a
                goto L7b
            L6a:
                int r6 = r3 + 1
                int r8 = r7 >>> 8
                r8 = r8 & 255(0xff, float:3.57E-43)
                byte r8 = (byte) r8
                r0[r3] = r8
                int r3 = r6 + 1
                r7 = r7 & 255(0xff, float:3.57E-43)
                byte r7 = (byte) r7
                r0[r6] = r7
                goto L9
            L7b:
                return r6
            L7c:
                int r10 = r0.length
                if (r3 == r10) goto L8f
                if (r4 != r1) goto L82
                return r6
            L82:
                int r10 = r0.length
                int r11 = r3 - r4
                int r10 = r10 - r11
                java.lang.System.arraycopy(r0, r4, r0, r10, r11)
                int r10 = r0.length
                int r10 = r10 - r3
                int r10 = r10 + r4
                java.util.Arrays.fill(r0, r4, r10, r2)
            L8f:
                java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L94
                return r10
            L94:
                java.lang.AssertionError r10 = new java.lang.AssertionError
                r10.<init>()
                goto L9b
            L9a:
                throw r10
            L9b:
                goto L9a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.HttpUrl.Builder.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
        }

        private static String domainToAscii(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private static String inet6AddressToAscii(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i2 < bArr.length) {
                int i5 = i2;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i2;
                if (i6 > i4) {
                    i3 = i2;
                    i4 = i6;
                }
                i2 = i5 + 2;
            }
            Buffer buffer = new Buffer();
            while (i < bArr.length) {
                if (i == i3) {
                    buffer.writeByte(58);
                    i += i4;
                    if (i == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.b(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                    i += 2;
                }
            }
            return buffer.o();
        }

        private boolean isDot(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int parsePort(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(HttpUrl.canonicalize(str, i, i2, HttpUrl.FRAGMENT_ENCODE_SET, false, false, true));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private void pop() {
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).isEmpty() && !this.encodedPathSegments.isEmpty()) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, HttpUrl.FRAGMENT_ENCODE_SET);
                return;
            }
            this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
        }

        private static int portColonOffset(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private void push(String str, int i, int i2, boolean z, boolean z2) {
            String canonicalize = HttpUrl.canonicalize(str, i, i2, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, true);
            if (isDot(canonicalize)) {
                return;
            }
            if (isDotDot(canonicalize)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, canonicalize);
            } else {
                this.encodedPathSegments.add(canonicalize);
            }
            if (z) {
                this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
            }
        }

        private void removeAllCanonicalQueryParameters(String str) {
            for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                    this.encodedQueryNamesAndValues.remove(size + 1);
                    this.encodedQueryNamesAndValues.remove(size);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void resolvePath(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = com.squareup.okhttp.HttpUrl.access$200(r11, r6, r13, r12)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.push(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.HttpUrl.Builder.resolvePath(java.lang.String, int, int):void");
        }

        private static int schemeDelimiterOffset(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private int skipLeadingAsciiWhitespace(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i;
                }
                i++;
            }
            return i2;
        }

        private int skipTrailingAsciiWhitespace(String str, int i, int i2) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                char charAt = str.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i3 + 1;
                }
            }
            return i;
        }

        private static int slashCount(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public Builder addEncodedPathSegment(String str) {
            if (str != null) {
                push(str, 0, str.length(), false, true);
                return this;
            }
            throw new IllegalArgumentException("encodedPathSegment == null");
        }

        public Builder addEncodedQueryParameter(String str, String str2) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, true, true, true));
                this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_ENCODE_SET, true, true, true) : null);
                return this;
            }
            throw new IllegalArgumentException("encodedName == null");
        }

        public Builder addPathSegment(String str) {
            if (str != null) {
                push(str, 0, str.length(), false, false);
                return this;
            }
            throw new IllegalArgumentException("pathSegment == null");
        }

        public Builder addQueryParameter(String str, String str2) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, true, true));
                this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, true, true) : null);
                return this;
            }
            throw new IllegalArgumentException("name == null");
        }

        public HttpUrl build() {
            if (this.scheme != null) {
                if (this.host != null) {
                    return new HttpUrl(this, null);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        int effectivePort() {
            int i = this.port;
            return i != -1 ? i : HttpUrl.defaultPort(this.scheme);
        }

        public Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? HttpUrl.canonicalize(str, HttpUrl.FRAGMENT_ENCODE_SET, true, false, false) : null;
            return this;
        }

        public Builder encodedPassword(String str) {
            if (str != null) {
                this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                return this;
            }
            throw new IllegalArgumentException("encodedPassword == null");
        }

        public Builder encodedPath(String str) {
            if (str != null) {
                if (str.startsWith("/")) {
                    resolvePath(str, 0, str.length());
                    return this;
                }
                throw new IllegalArgumentException("unexpected encodedPath: " + str);
            }
            throw new IllegalArgumentException("encodedPath == null");
        }

        public Builder encodedQuery(String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, HttpUrl.QUERY_ENCODE_SET, true, true, true)) : null;
            return this;
        }

        public Builder encodedUsername(String str) {
            if (str != null) {
                this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                return this;
            }
            throw new IllegalArgumentException("encodedUsername == null");
        }

        public Builder fragment(String str) {
            this.encodedFragment = str != null ? HttpUrl.canonicalize(str, HttpUrl.FRAGMENT_ENCODE_SET, false, false, false) : null;
            return this;
        }

        public Builder host(String str) {
            if (str != null) {
                String canonicalizeHost = canonicalizeHost(str, 0, str.length());
                if (canonicalizeHost != null) {
                    this.host = canonicalizeHost;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new IllegalArgumentException("host == null");
        }

        ParseResult parse(HttpUrl httpUrl, String str) {
            int delimiterOffset;
            int i;
            int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, 0, str.length());
            int skipTrailingAsciiWhitespace = skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, str.length());
            if (schemeDelimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace) != -1) {
                if (str.regionMatches(true, skipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.scheme = "https";
                    skipLeadingAsciiWhitespace += 6;
                } else if (str.regionMatches(true, skipLeadingAsciiWhitespace, "http:", 0, 5)) {
                    this.scheme = "http";
                    skipLeadingAsciiWhitespace += 5;
                } else {
                    return ParseResult.UNSUPPORTED_SCHEME;
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme;
            } else {
                return ParseResult.MISSING_SCHEME;
            }
            int slashCount = slashCount(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            char c = '?';
            char c2 = '#';
            if (slashCount < 2 && httpUrl != null && httpUrl.scheme.equals(this.scheme)) {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str.charAt(skipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            } else {
                int i2 = skipLeadingAsciiWhitespace + slashCount;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    delimiterOffset = HttpUrl.delimiterOffset(str, i2, skipTrailingAsciiWhitespace, "@/\\?#");
                    char charAt = delimiterOffset != skipTrailingAsciiWhitespace ? str.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int delimiterOffset2 = HttpUrl.delimiterOffset(str, i2, delimiterOffset, ":");
                            i = delimiterOffset;
                            String canonicalize = HttpUrl.canonicalize(str, i2, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                            if (z2) {
                                canonicalize = this.encodedUsername + "%40" + canonicalize;
                            }
                            this.encodedUsername = canonicalize;
                            if (delimiterOffset2 != i) {
                                this.encodedPassword = HttpUrl.canonicalize(str, delimiterOffset2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = delimiterOffset;
                            this.encodedPassword += "%40" + HttpUrl.canonicalize(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                        }
                        i2 = i + 1;
                    }
                    c = '?';
                    c2 = '#';
                }
                int portColonOffset = portColonOffset(str, i2, delimiterOffset);
                int i3 = portColonOffset + 1;
                if (i3 < delimiterOffset) {
                    this.host = canonicalizeHost(str, i2, portColonOffset);
                    this.port = parsePort(str, i3, delimiterOffset);
                    if (this.port == -1) {
                        return ParseResult.INVALID_PORT;
                    }
                } else {
                    this.host = canonicalizeHost(str, i2, portColonOffset);
                    this.port = HttpUrl.defaultPort(this.scheme);
                }
                if (this.host == null) {
                    return ParseResult.INVALID_HOST;
                }
                skipLeadingAsciiWhitespace = delimiterOffset;
            }
            int delimiterOffset3 = HttpUrl.delimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
            resolvePath(str, skipLeadingAsciiWhitespace, delimiterOffset3);
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = HttpUrl.delimiterOffset(str, delimiterOffset3, skipTrailingAsciiWhitespace, "#");
                this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, true, true));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = HttpUrl.canonicalize(str, 1 + delimiterOffset3, skipTrailingAsciiWhitespace, HttpUrl.FRAGMENT_ENCODE_SET, true, false, false);
            }
            return ParseResult.SUCCESS;
        }

        public Builder password(String str) {
            if (str != null) {
                this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, true);
                return this;
            }
            throw new IllegalArgumentException("password == null");
        }

        public Builder port(int i) {
            if (i > 0 && i <= 65535) {
                this.port = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        public Builder query(String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, HttpUrl.QUERY_ENCODE_SET, false, true, true)) : null;
            return this;
        }

        Builder reencodeForUri() {
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                this.encodedPathSegments.set(i, HttpUrl.canonicalize(this.encodedPathSegments.get(i), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, false, true));
            }
            List<String> list = this.encodedQueryNamesAndValues;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.encodedQueryNamesAndValues.get(i2);
                    if (str != null) {
                        this.encodedQueryNamesAndValues.set(i2, HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true));
                    }
                }
            }
            String str2 = this.encodedFragment;
            if (str2 != null) {
                this.encodedFragment = HttpUrl.canonicalize(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, false, false);
            }
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    return this;
                }
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, true, true, true));
                return this;
            }
            throw new IllegalArgumentException("encodedName == null");
        }

        public Builder removeAllQueryParameters(String str) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    return this;
                }
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, true, true));
                return this;
            }
            throw new IllegalArgumentException("name == null");
        }

        public Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            return this;
        }

        public Builder scheme(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.scheme = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.scheme = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new IllegalArgumentException("scheme == null");
        }

        public Builder setEncodedPathSegment(int i, String str) {
            if (str != null) {
                String canonicalize = HttpUrl.canonicalize(str, 0, str.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, true);
                this.encodedPathSegments.set(i, canonicalize);
                if (isDot(canonicalize) || isDotDot(canonicalize)) {
                    throw new IllegalArgumentException("unexpected path segment: " + str);
                }
                return this;
            }
            throw new IllegalArgumentException("encodedPathSegment == null");
        }

        public Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder setPathSegment(int i, String str) {
            if (str != null) {
                String canonicalize = HttpUrl.canonicalize(str, 0, str.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, true);
                if (!isDot(canonicalize) && !isDotDot(canonicalize)) {
                    this.encodedPathSegments.set(i, canonicalize);
                    return this;
                }
                throw new IllegalArgumentException("unexpected path segment: " + str);
            }
            throw new IllegalArgumentException("pathSegment == null");
        }

        public Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheme);
            sb.append("://");
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                sb.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            if (this.host.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.host);
                sb.append(']');
            } else {
                sb.append(this.host);
            }
            int effectivePort = effectivePort();
            if (effectivePort != HttpUrl.defaultPort(this.scheme)) {
                sb.append(':');
                sb.append(effectivePort);
            }
            HttpUrl.pathSegmentsToString(sb, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                HttpUrl.namesAndValuesToQueryString(sb, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }

        public Builder username(String str) {
            if (str != null) {
                this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, true);
                return this;
            }
            throw new IllegalArgumentException("username == null");
        }
    }

    /* synthetic */ HttpUrl(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static String canonicalize(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z3) && str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || z) && (codePointAt != 43 || !z2)))) {
                i3 += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.a(str, i, i3);
                canonicalize(buffer, str, i3, i2, str2, z, z2, z3);
                return buffer.o();
            }
        }
        return str.substring(i, i2);
    }

    static int decodeHexDigit(char c) {
        if (c < '0' || c > '9') {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = 'A';
                if (c < 'A' || c > 'F') {
                    return -1;
                }
            }
            return (c - c2) + 10;
        }
        return c - '0';
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int delimiterOffset(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static HttpUrl get(URL url) {
        return parse(url.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HttpUrl getChecked(String str) throws MalformedURLException, UnknownHostException {
        Builder builder = new Builder();
        Builder.ParseResult parse = builder.parse(null, str);
        int i = AnonymousClass1.$SwitchMap$com$squareup$okhttp$HttpUrl$Builder$ParseResult[parse.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new MalformedURLException("Invalid URL: " + parse + " for " + str);
            }
            throw new UnknownHostException("Invalid host: " + str);
        }
        return builder.build();
    }

    static void namesAndValuesToQueryString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static HttpUrl parse(String str) {
        Builder builder = new Builder();
        if (builder.parse(null, str) == Builder.ParseResult.SUCCESS) {
            return builder.build();
        }
        return null;
    }

    static void pathSegmentsToString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    static String percentDecode(String str, boolean z) {
        return percentDecode(str, 0, str.length(), z);
    }

    static List<String> queryStringToNamesAndValues(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return FRAGMENT_ENCODE_SET;
        }
        int indexOf = this.url.indexOf(64);
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, indexOf);
    }

    public String encodedPath() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        return this.url.substring(indexOf, delimiterOffset(str, indexOf, str.length(), "?#"));
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        int delimiterOffset = delimiterOffset(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i = indexOf + 1;
            int delimiterOffset2 = delimiterOffset(this.url, i, delimiterOffset, "/");
            arrayList.add(this.url.substring(i, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf = this.url.indexOf(63) + 1;
        String str = this.url;
        return this.url.substring(indexOf, delimiterOffset(str, indexOf + 1, str.length(), "#"));
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return FRAGMENT_ENCODE_SET;
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(length, delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    public String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String host() {
        return this.host;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    public String password() {
        return this.password;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public int port() {
        return this.port;
    }

    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        namesAndValuesToQueryString(sb, this.queryNamesAndValues);
        return sb.toString();
    }

    public String queryParameter(String str) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                return this.queryNamesAndValues.get(i + 1);
            }
        }
        return null;
    }

    public String queryParameterName(int i) {
        return this.queryNamesAndValues.get(i * 2);
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public String queryParameterValue(int i) {
        return this.queryNamesAndValues.get((i * 2) + 1);
    }

    public List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                arrayList.add(this.queryNamesAndValues.get(i + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public HttpUrl resolve(String str) {
        Builder builder = new Builder();
        if (builder.parse(this, str) == Builder.ParseResult.SUCCESS) {
            return builder.build();
        }
        return null;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public URI uri() {
        try {
            return new URI(newBuilder().reencodeForUri().toString());
        } catch (URISyntaxException unused) {
            throw new IllegalStateException("not valid as a java.net.URI: " + this.url);
        }
    }

    public URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String username() {
        return this.username;
    }

    private HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        List<String> list = builder.encodedQueryNamesAndValues;
        this.queryNamesAndValues = list != null ? percentDecode(list, true) : null;
        String str = builder.encodedFragment;
        this.fragment = str != null ? percentDecode(str, false) : null;
        this.url = builder.toString();
    }

    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    private List<String> percentDecode(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? percentDecode(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String percentDecode(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.a(str, i, i3);
                percentDecode(buffer, str, i3, i2, z);
                return buffer.o();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void canonicalize(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z2) {
                    buffer.a(z ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z3) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || z))) {
                    buffer.d(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.d(codePointAt);
                    while (!buffer2.g()) {
                        int readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) HEX_DIGITS[(readByte >> 4) & 15]);
                        buffer.writeByte((int) HEX_DIGITS[readByte & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static void percentDecode(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int decodeHexDigit = decodeHexDigit(str.charAt(i + 1));
                int decodeHexDigit2 = decodeHexDigit(str.charAt(i3));
                if (decodeHexDigit != -1 && decodeHexDigit2 != -1) {
                    buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                    i = i3;
                }
                buffer.d(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.d(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3);
    }
}
