package com.ey.learning.microservices_api.filter;

import com.ey.learning.microservices_api.service.impl.AuthServiceImpl;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    private final AuthServiceImpl authService;

    public AuthFilter(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String authorization = req.getHeader("Authorization");


        if (authorization == null || !authService.validateToken(authorization)) {
            res.setStatus(401);
            return;
        }
        filterChain.doFilter(req,res);
    }
}
