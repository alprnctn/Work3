package com.felece.Alper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.felece.Alper.entities.Member;
import com.felece.Alper.repositories.MemberRepo;
import com.felece.Alper.services.MemberService;

import javax.validation.Valid;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepo memberRepo;

    @GetMapping("/login")
    public String showLoginForm(){
        return "views/loginForm";
    }


    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("member", new Member());
        return "views/registerForm";
    }
    @GetMapping("/admin")
    public String showAdminPage(Model model){
        return "views/members";
    }

    @GetMapping("/user")
    public String showUserPage(Model model){
        return "views/user";
    }

    @PostMapping("/register")
    public String registerMember(@Valid Member member, Model model){
        String email = member.getEmail();
        if (memberRepo.findByEmail(email) != null){
            model.addAttribute("exist",true);
            return "views/registerForm";
        }
        memberService.createMember(member);
        model.addAttribute("success", true);
        return "views/loginForm";
    }
}
