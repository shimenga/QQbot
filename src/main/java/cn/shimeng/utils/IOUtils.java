package cn.shimeng.utils;

import javax.net.ssl.HttpsURLConnection;

public final class IOUtils {
    private IOUtils() {
    }

    public static void closeQuietly(Object... objs) {
        for (Object obj : objs) {
            if (obj instanceof AutoCloseable) {
                try {
                    ((AutoCloseable) obj).close();
                } catch (Exception ignored) {
                }
            } else if (obj instanceof HttpsURLConnection) {
                try {
                    ((HttpsURLConnection) obj).disconnect();
                } catch (Exception ignored) {
                }
            }
        }
    }
}
