package com.example.customer.security.token;

import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.security.details.UserDetailsServiceImple;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@Component
@Log
public class JwtFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserDetailsServiceImple userDetailsServiceImple;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//        if (request.getServletPath().equals("/auth")) {
//            String token = jwtProvider.generateToken(request.getParameter("email"));
//            response.addCookie(new Cookie(AUTHORIZATION, token));
//        } else {
            String token = getTokenFromRequest(request);
            if (token != null && jwtProvider.validateToken(token)) {
                String userLogin = jwtProvider.getLoginFromToken(token);
                UserDetailsImpl userDetails = userDetailsServiceImple.loadUserByUsername(userLogin);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            else {
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(null, null, null));
            }
//        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(AUTHORIZATION))
                return cookie.getValue().substring(6);
        }
        return null;
    }


}