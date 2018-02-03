package application.service.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HyperHttpClient {
    private HttpClient httpClient;

    private HyperHttpClient() {
        System.out.println("HyperHttpClient Created!!");
        httpClient = HttpClientMaker.getHttpClient();
    }

    public String hello(String path) {
        HttpGet httpGet = new HttpGet("http://localhost:8080/hello/" + path);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            System.out.println("Http status:" + response.getStatusLine().getStatusCode());
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
}
