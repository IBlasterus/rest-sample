package com.iblasterus.restsample.logging;

public class ResponseLog {
    private String httpCode;
    private String headers;
    private String body;

    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String httpCode) {
        this.httpCode = httpCode;
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
        return "RESPONSE:\n---------\n" +
                "httpCode: " + httpCode + "\n" +
                "headers: " + headers + "\n" +
                "body:\n" + body + "\n";
    }
}
