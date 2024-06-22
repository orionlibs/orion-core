package io.github.orionlibs.core.web.filter;

import io.github.orionlibs.core.abstraction.Orion;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class XSSWebFilter extends Orion implements Filter
{
    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        chain.doFilter(new XSSHttpServletRequestWrapper((HttpServletRequest)request), response);
    }
}