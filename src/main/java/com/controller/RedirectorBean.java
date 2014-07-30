package com.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
 
@Controller
@Scope("request")
public class RedirectorBean {
    public String userPage() {
        return "userPage";
    }
 
    public String adminPage() {
        return "adminPage";
    }
 
    public String index() {
        return "index";
    }
 
    public String successfulPage() {
        return "successfulPage";
    }
}
