package application.service.http;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;

class HttpClientMaker {

    // 参考 https://qiita.com/mychaelstyle/items/e02b3011d1e71bfa26c5
    static HttpClient getHttpClient() {
        // config
        RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(5000)
            .setSocketTimeout(5000)
            .build();

        // headers
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("Accept-Charset", "utf-8"));
        headers.add(new BasicHeader("User-Agent", "Hyper Http Client"));

        // http client
        return HttpClientBuilder.create()
            .setDefaultRequestConfig(requestConfig)
            .setDefaultHeaders(headers)
            .build();
    }
}
