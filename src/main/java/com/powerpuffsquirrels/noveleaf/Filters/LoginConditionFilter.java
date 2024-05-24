package com.powerpuffsquirrels.noveleaf.Filters;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginConditionFilter implements Filter {

    private final List<String> whitelist = Arrays.asList("/login","/logout","/create-account", "/index", "/search",
            "/header", "/footer", "/styles.css", "/noveleaf-text.png", "/noveleaf-banner-object.png", "noveleafnobook.png", "popup.js", "popup.css", "login.css", "redirect-message.css" );

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        boolean isWhitelisted = whitelist.stream().anyMatch(requestURI::startsWith);

        if(!isWhitelisted && request.getSession().getAttribute("user") == null){

            if(requestURI.equals("/")) response.sendRedirect(request.getContextPath()+"/login");
            else response.sendRedirect(request.getContextPath()+"/login?error=true");
            return;
        }

        filterChain.doFilter(request, response);

    }
}
