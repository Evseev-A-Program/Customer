package com.example.customer.controllers;

import com.example.customer.forms.LoginForm;
import com.example.customer.models.Customer;
import com.example.customer.repository.TokenDao;
import com.example.customer.service.LoginService;
import com.example.customer.transfer.transfer.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap modelMap, HttpServletRequest request) {
        if (authentication != null) {
            return "redirect:/";
        }

        if (request.getParameterMap().containsKey("error")) {
            modelMap.addAttribute("error", true);
        }
        return "login";
    }

//    @GetMapping("/login-in")
//    public String getLoginToken(Authentication authentication, ModelMap modelMap, HttpServletRequest request) {
//
//        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
//
//        modelMap.addAttribute("token", token);
//
//        return "token";
//    }

    @PostMapping("/login")
    public String login(Authentication authentication, ModelMap modelMap, LoginForm loginForm) {
        TokenDto tokenDto = loginService.getToken(loginForm);

        return "redirect:/user/?token="+tokenDto.getValue();
    }


}
