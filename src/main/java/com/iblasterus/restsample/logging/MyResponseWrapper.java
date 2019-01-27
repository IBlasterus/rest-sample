package com.iblasterus.restsample.logging;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;

public class MyResponseWrapper extends HttpServletResponseWrapper {
    private String body;

    MyResponseWrapper(HttpServletResponse response) throws IOException {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        final ServletOutputStream responseOutputStream = super.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ServletOutputStream servletOutputStream = new ServletOutputStream() {
            @Override
            public boolean isReady() {
                return responseOutputStream.isReady();
            }

            @Override
            public void setWriteListener(WriteListener listener) {
                responseOutputStream.setWriteListener(listener);
            }

            @Override
            public void write(int b) throws IOException {
                responseOutputStream.write(b);
                baos.write(b);
            }
        };

        this.body = baos.toString();
        return servletOutputStream;
    }

    public String getBody() {
        return this.body;
    }
}
