package com.medtronic.reqauth.repository;

import java.util.Optional;

import com.medtronic.reqauth.models.ERole;
import com.medtronic.reqauth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}