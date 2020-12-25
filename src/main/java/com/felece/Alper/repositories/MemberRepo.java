package com.felece.Alper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.felece.Alper.entities.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, String> {

    Member findByEmail(String email);

}