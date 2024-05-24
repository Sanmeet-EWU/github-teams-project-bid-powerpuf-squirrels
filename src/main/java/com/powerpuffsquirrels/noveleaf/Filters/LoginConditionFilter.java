package com.powerpuffsquirrels.noveleaf.Filters;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginConditionFilter implements Filter {

    private final List<String> whitelist = Arrays.asList("/login","/logout","/create-account","/readshelf","/error");
    private final List<String> statics = Arrays.asList(".css", ".js", ".png", ".jpg", ".jpeg", ".gif", ".woff", ".ttf");
    //private final List<String> statics = Arrays.asList("/css/","/image/","/js/"); //doesn't work :|

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        boolean isWhitelisted = whitelist.stream().anyMatch(requestURI::startsWith);
        boolean isStatic = statics.stream().anyMatch(requestURI::endsWith);
        //boolean isStatic = statics.stream().anyMatch(requestURI::contains);

        if(isWhitelisted || isStatic) {
            filterChain.doFilter(request, response);
            return;
        }
        if(request.getSession().getAttribute("user") == null){

            if(requestURI.equals("/")) response.sendRedirect(request.getContextPath()+"/login");
            else response.sendRedirect(request.getContextPath()+"/login?error=true");
            return;
        }


        filterChain.doFilter(request, response);
    }
}
