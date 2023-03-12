package com.campingmapping.team4.spring.t401member.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*
* This is the controller for opening web pages of user functions in Camper web application.
*
* 這是用於打開Camper前台功能網頁的控制器。
*/
@Controller
@RequestMapping("/camper")
public class CamperPageComtroller {

    @GetMapping("/notlogin")
    public String camperIndex() {
        return "camper/guest/notlogin";
    }
    @GetMapping("/{uid}")
    public String camperDetail() {
        return "camper/guest/camperDetail";
    }

}
