package br.mp.mpf.cursowebservice.cursowebservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {
    private final Logger log = LoggerFactory.getLogger(RequestResponseLoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request,
            byte[] body,
            ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        log.debug("request begin");
        log.debug("URI          : {}", request.getURI());
        log.debug("Method       : {}", request.getMethod());
        log.debug("Header       : {}", request.getHeaders());
        log.debug("Request Body : {}", new String(body, "UTF-8"));
        log.debug("Header       : {}", request.getHeaders());
        log.debug("request ends");
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        log.debug("response begins");
        log.debug("Status code: {}" + response.getStatusCode());
        log.debug("Response Body: {}" + StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
        log.debug("response ends");
    }

}
