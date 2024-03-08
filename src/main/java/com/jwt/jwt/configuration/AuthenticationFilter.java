package com.jwt.jwt.configuration;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilterAsyncDispatch() {
        return false;
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return false;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        // You can write your own filtering
        if ("/login".equals(request.getRequestURI())) {
          System.out.println("login filter processing");
        } else {
          boolean isValid = validate(request); 
          if (!isValid) {
            response.sendError(403);
          }
        }
        filterChain.doFilter(request, response);
        return;
    }

    private boolean validate (HttpServletRequest request) {
      if (request.getHeader("Authorization") == null || "".equals(request.getHeader("Authorization"))) {
        return false;
      }
      if (request.getHeader("Authorization").split(" ").length != 2) {
        return false;
      }
      if (!"Bearer".equals(request.getHeader("Authorization").split(" ")[0])) {
        return false;
      }
      if (request.getHeader("Authorization").split(" ")[1] != null) {
        return true;
      }
      return false;
    }
}
