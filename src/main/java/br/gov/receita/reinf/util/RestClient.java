package br.gov.receita.reinf.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RestClient {

    private final HttpClient client;

    public RestClient() {
        this.client = HttpClients.createDefault();
    }

    public RestClient(HttpClient client) {
        this.client = client;
    }

    public String sendSignedXml(String url, String signedXmlPayload, String contentType) throws Exception {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", contentType);

        // Add signed XML payload
        post.setEntity(new StringEntity(signedXmlPayload, "UTF-8"));

        // Execute request
        HttpResponse response = client.execute(post);

        // Validate HTTP status code
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 200 && statusCode < 300) {
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } else {
            throw new RuntimeException("HTTP Request Failed: " + statusCode);
        }
    }
}
