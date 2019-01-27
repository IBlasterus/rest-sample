package com.iblasterus.restsample.logging;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import org.apache.commons.io.IOUtils;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var request = new MyRequestWrapper((HttpServletRequest) servletRequest);
        var response = new MyResponseWrapper((HttpServletResponse) servletResponse);

        var reqLog = new RequestLog();
        var resLog = new ResponseLog();

        // ===Request===
        // url
        reqLog.setUrl(request.getRequestURL().toString());

        // method
        reqLog.setMethod(request.getMethod());

        // headers
        Enumeration<String> headerNames = request.getHeaderNames();
        var headers = new StringBuilder();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                var headerName = headerNames.nextElement();
                headers.append(headerName + "=" + request.getHeader(headerName) + "; ");
            }
        }
        reqLog.setHeaders(headers.toString());

        // body
        if ("POST".equalsIgnoreCase(request.getMethod()))
        {
            reqLog.setBody(request.getBody());
        }

        // Allow request and response move on. (trough the Filter).
        filterChain.doFilter(request, response);

        // ===Response===

        // httpCode
        Integer httpCode = response.getStatus();
        resLog.setHttpCode(httpCode.toString());

        // headers
        Collection<String> resHeaderNames = response.getHeaderNames();
        var resHeaders = new StringBuilder();
        if (resHeaderNames != null) {
            for (String headerName : resHeaderNames) {
                resHeaders.append(headerName + "=" + response.getHeader(headerName) + "; ");
            }
        }
        resLog.setHeaders(resHeaders.toString());

        // body
        resLog.setBody(response.getBody());

        // Print log
        System.out.println(reqLog.toString());
        System.out.println(resLog.toString());
    }
}
