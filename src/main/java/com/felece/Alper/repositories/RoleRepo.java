package com.felece.Alper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.felece.Alper.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, String> {

}