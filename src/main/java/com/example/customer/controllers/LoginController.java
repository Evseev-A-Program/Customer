package com.example.customer.controllers;

import com.example.customer.forms.LoginForm;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

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

//   @PostMapping ("/login")
//    public String login(@RequestBody LoginForm loginForm) {
//
//            loginService.login(loginForm);
//
//        return "redirect:/";
//    }





}
