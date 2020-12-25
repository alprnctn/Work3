package com.felece.Alper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.felece.Alper.entities.Member;
import com.felece.Alper.repositories.MemberRepo;

import java.security.Principal;

@Controller
public class IndexController {

    @Autowired
    MemberRepo memberRepo;

    @GetMapping("/")
    public String showIndex(Model model, Principal principal, Member member){
        if(principal == null){
            return "views/loginForm";
        }
            return "index";
    }
}