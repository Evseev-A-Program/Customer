package com.example.customer.controllers;


import com.example.customer.models.Role;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProfileController {



    @GetMapping("/")
    public String getProfilePage(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }

        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        CustomerDTO customer = CustomerDTO.from(details.getCustomer());

        if (customer.getRole().equals(Role.ADMIN)){
            return "redirect:/admin/";
        }
            return "redirect:/user/";
    }

    @GetMapping("/exit")
    public String logout(HttpServletRequest request) {
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("Authorization"))
                cookie.setValue("");
                cookie.setMaxAge(0);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(null, null, null));
        }
        return "redirect:/login";
    }

}
