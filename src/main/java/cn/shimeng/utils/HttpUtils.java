package cn.shimeng.utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public final class HttpUtils {
    private HttpUtils() {
    }

    public static HttpGetResult getHttps(String url) {
        BufferedReader br = null;
        HttpsURLConnection conn = null;
        try {
            URL var1 = new URL(url);
            conn = (HttpsURLConnection) var1.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return new HttpGetResult(conn.getResponseCode(), sb.toString());
        } catch (IOException e) {
            if (conn != null) {
                try {
                    IOUtils.closeQuietly(br);
                    br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8));
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    return new HttpGetResult(conn.getResponseCode(), sb.toString());

                } catch (IOException ex) {
                    ex.printStackTrace();
                    return new HttpGetResult(-1, null);
                }
            }
            e.printStackTrace();
            return new HttpGetResult(-1, null);
        } finally {
            IOUtils.closeQuietly(br, conn);
        }

    }

    public static class HttpGetResult {
        public final int response;
        public final String result;

        public HttpGetResult(int response, String result) {
            this.response = response;
            this.result = result;
        }
    }
}
