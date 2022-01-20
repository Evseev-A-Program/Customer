package com.example.customer.controllers;

import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.forms.LoginForm;
import com.example.customer.models.Customer;
import com.example.customer.security.token.JwtProvider;
import com.example.customer.service.CustomerService;
import com.example.customer.service.PaidTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap modelMap, HttpServletRequest request, Boolean error) {
        if (authentication != null) {
            return "redirect:/";
        }

        if (error!=null) {
            modelMap.addAttribute("error", true);
        }
        return "login";
    }


    @PostMapping("/login")
    public String login(ModelMap model, LoginForm loginForm, HttpServletResponse response) throws CustomerNotFoundException {
        Customer customer = customerService.findByLoginAndPassword(loginForm);
        if (customer == null) {
            return "redirect:/login?error=true";
        }
        String token = jwtProvider.generateToken(loginForm.getEmail());
        Cookie cookie = new Cookie("Authorization", "Bearer" + token);
        if (loginForm.getRememberMe() == null) cookie.setMaxAge(500);
        else cookie.setMaxAge(-1);
        response.addCookie(cookie);

        return "redirect:/";
    }


}
