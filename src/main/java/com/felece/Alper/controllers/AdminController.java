package com.felece.Alper.controllers;


import com.felece.Alper.entities.Member;
import com.felece.Alper.repositories.MemberRepo;
import com.felece.Alper.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminServices adminService;
    @Autowired
    MemberRepo memberRepo;
    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public String getMembers(Model model) {
        List<Member> members = adminService.allMembers();
        model.addAttribute("members", members);
        return "views/members";
    }

    @GetMapping("/delete/{email}")
    public String deleteMember(@PathVariable(value = "email") String email) {
        adminService.deleteMember(email);
        return "views/members";
    }
    @GetMapping("/update/{email}")
    public String updateMember(@PathVariable(name = "email") String email, Model model) {
        Member member = adminService.findByEmail(email);
        model.addAttribute("member", member);
        return "views/update";
    }

    @PostMapping("/update/{email}")
    public String update(@PathVariable(name = "email") String email, Model model, @Valid Member member) {
        return "views/members";
    }
}