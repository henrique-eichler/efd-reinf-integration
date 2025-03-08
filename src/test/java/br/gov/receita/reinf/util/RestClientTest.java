package br.gov.receita.reinf.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.protocol.HTTP;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RestClientTest {

    @Test
    void testSendSignedXml() throws Exception {
        // Mock HttpClient
        HttpClient mockClient = Mockito.mock(HttpClient.class);
        HttpResponse mockResponse = new BasicHttpResponse(HttpVersion.HTTP_1_1, 200, "OK");
        mockResponse.setEntity(new StringEntity("<response>Success</response>", HTTP.UTF_8));
        when(mockClient.execute(any(HttpPost.class))).thenReturn(mockResponse);

        RestClient restClient = new RestClient(mockClient);

        String response = restClient.sendSignedXml(
                "https://mock-url.test/api",
                "<signedXml/>",
                "application/xml"
        );

        assertNotNull(response);
        assertTrue(response.contains("Success"));
    }
}
