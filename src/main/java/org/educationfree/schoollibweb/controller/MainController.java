package org.educationfree.schoollibweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public static String showIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public static String showLogin(){
        return "login";
    }

    @RequestMapping("/404")
    public static String showError(){
        return "404";
    }
}
