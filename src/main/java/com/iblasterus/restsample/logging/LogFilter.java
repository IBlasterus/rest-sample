package com.iblasterus.restsample.logging;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var request = (HttpServletRequest) servletRequest;
        var reqLog = new RequestLog();
        var resLog = new ResponseLog();

        // ===Request===
        // url
        reqLog.setUrl(request.getRequestURL().toString());

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

        System.out.println(reqLog.toString());
        System.out.println(resLog.toString());

        // Разрешить request продвигаться дальше. (Перейти данный Filter).
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
