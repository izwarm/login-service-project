package com.learn.test.repo;

import com.learn.test.model.role.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    Roles findByRoleCode(String roleCode);

}
