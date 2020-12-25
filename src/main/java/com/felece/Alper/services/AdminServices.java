package com.felece.Alper.services;

import org.springframework.stereotype.Service;
import com.felece.Alper.repositories.*;
import com.felece.Alper.entities.*;

import java.util.List;

@Service
public class AdminServices {

    private final MemberRepo memberRepo;
    private final RoleRepo roleRepo;

    public AdminServices(MemberRepo memberRepo, RoleRepo roleRepo) {
        this.memberRepo = memberRepo;
        this.roleRepo = roleRepo;
    }

    public List<Member> allMembers() {
        return memberRepo.findAll();
    }

    public void deleteMember(String email){
        memberRepo.deleteById(email);
    }

    public void updateMember(Member member) {
        memberRepo.save(member);
    }
    public Member findByEmail(String email){
        return memberRepo.findByEmail(email);
    }

}
