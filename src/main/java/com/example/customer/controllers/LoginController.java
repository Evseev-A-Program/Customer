package com.example.customer.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

//    @Autowired
//    private LoginService loginService;

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap modelMap, HttpServletRequest request) {
        if (authentication != null) {
//            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
//            loginService.login(LoginForm.builder()
//                            .password(details.getPassword())
//                            .email(details.getUsername())
//                    .build());
            return "redirect:/";
        }

        if (request.getParameterMap().containsKey("error")) {
            modelMap.addAttribute("error", true);
        }
        return "login";
    }





}
