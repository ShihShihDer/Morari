package com.campingmapping.team4.spring.t401member.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * This is the controller for opening web pages related to user login and
 * registration in Camper web application.
 *
 * 這是用於打開用戶登錄和註冊相關的網頁的控制器。
 */
@Controller
public class LoginPageComtroller {

    @GetMapping({ "/login", "/login/" })
    public String login() {
        return "camper/global/login";
    }

    @GetMapping({ "/register", "/register/" })
    public String register() {
        return "camper/global/register";
    }

    @GetMapping({ "/forgotpassword", "/forgotpassword/" })
    public String forgotPassword() {
        return "camper/global/forgotpassword";
    }

}
