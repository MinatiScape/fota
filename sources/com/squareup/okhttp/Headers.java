package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes.dex */
public final class Headers {
    private final String[] namesAndValues;

    public static Headers of(String... strArr) {
        if (strArr != null && strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            for (int i = 0; i < strArr2.length; i++) {
                if (strArr2[i] != null) {
                    strArr2[i] = strArr2[i].trim();
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
                String str = strArr2[i2];
                String str2 = strArr2[i2 + 1];
                if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                    throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
                }
            }
            return new Headers(strArr2);
        }
        throw new IllegalArgumentException("Expected alternating header names and values");
    }

    public String get(String str) {
        return get(this.namesAndValues, str);
    }

    public Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return HttpDate.parse(str2);
        }
        return null;
    }

    public String name(int i) {
        int i2 = i * 2;
        if (i2 >= 0) {
            String[] strArr = this.namesAndValues;
            if (i2 >= strArr.length) {
                return null;
            }
            return strArr[i2];
        }
        return null;
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(name(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public int size() {
        return this.namesAndValues.length / 2;
    }

    public Map<String, List<String>> toMultimap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = size();
        for (int i = 0; i < size; i++) {
            String name = name(i);
            List list = (List) linkedHashMap.get(name);
            if (list == null) {
                list = new ArrayList(2);
                linkedHashMap.put(name, list);
            }
            list.add(value(i));
        }
        return linkedHashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(name(i));
            sb.append(": ");
            sb.append(value(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String value(int i) {
        int i2 = (i * 2) + 1;
        if (i2 >= 0) {
            String[] strArr = this.namesAndValues;
            if (i2 >= strArr.length) {
                return null;
            }
            return strArr[i2];
        }
        return null;
    }

    public List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(name(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private Headers(Builder builder) {
        this.namesAndValues = (String[]) builder.namesAndValues.toArray(new String[builder.namesAndValues.size()]);
    }

    private static String get(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        private void checkNameAndValue(String str, String str2) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i = 0; i < length; i++) {
                        char charAt = str.charAt(i);
                        if (charAt <= 31 || charAt >= 127) {
                            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                        }
                    }
                    if (str2 != null) {
                        int length2 = str2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            char charAt2 = str2.charAt(i2);
                            if (charAt2 <= 31 || charAt2 >= 127) {
                                throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str2));
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("value == null");
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("name == null");
        }

        public Builder add(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder addLenient(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return addLenient(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return addLenient("", str.substring(1));
            }
            return addLenient("", str);
        }

        public Headers build() {
            return new Headers(this);
        }

        public String get(String str) {
            for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                    return this.namesAndValues.get(size + 1);
                }
            }
            return null;
        }

        public Builder removeAll(String str) {
            int i = 0;
            while (i < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(i))) {
                    this.namesAndValues.remove(i);
                    this.namesAndValues.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public Builder set(String str, String str2) {
            checkNameAndValue(str, str2);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }

        public Builder add(String str, String str2) {
            checkNameAndValue(str, str2);
            return addLenient(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder addLenient(String str, String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static Headers of(Map<String, String> map) {
        if (map != null) {
            String[] strArr = new String[map.size() * 2];
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    String trim = entry.getKey().trim();
                    String trim2 = entry.getValue().trim();
                    if (trim.length() != 0 && trim.indexOf(0) == -1 && trim2.indexOf(0) == -1) {
                        strArr[i] = trim;
                        strArr[i + 1] = trim2;
                        i += 2;
                    } else {
                        throw new IllegalArgumentException("Unexpected header: " + trim + ": " + trim2);
                    }
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            return new Headers(strArr);
        }
        throw new IllegalArgumentException("Expected map with header names and values");
    }
}
