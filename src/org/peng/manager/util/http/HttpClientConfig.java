package org.peng.manager.util.http;

/**
 * @Author sp
 * @Description
 * @create 2020-12-01 10:50
 * @Modified By:
 */
public class HttpClientConfig {
    static int httpConnectTimeout = 1000000;//连接超时时间(单位毫秒)

    static int httpSocketTimeout = 1000000;//socket读写超时时间(单位毫秒)

    static int httpMaxPoolSize = 100;

    static int httpMonitorInterval = 3000;

    static int httpIdelTimeout = 2000;

    public static int getHttpIdelTimeout() {
        return httpIdelTimeout;
    }

    public static int getHttpSocketTimeout() {
        return httpSocketTimeout;
    }

    public static int getHttpMaxPoolSize() {
        return httpMaxPoolSize;
    }

    public static int getHttpMonitorInterval() {
        return httpMonitorInterval;
    }

    public static int getHttpConnectTimeout() {
        return httpConnectTimeout;
    }
}
