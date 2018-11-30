package com.iblasterus.restsample.logging;

public class RequestLog {
    private String url;
    private String method;
    private String headers;
    private String body;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "REQUEST:\n--------\n" +
                "url: " + url + "\n" +
                "method: " + method + "\n" +
                "headers: " + headers + "\n" +
                "body:\n" + body + "\n";
    }
}
