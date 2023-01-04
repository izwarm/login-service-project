package com.learn.test.service.impl;

import com.learn.test.model.role.Roles;
import com.learn.test.repo.RoleRepository;
import com.learn.test.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Roles findRoleCode(String roleCode) {
        return roleRepository.findByRoleCode(roleCode);
    }
}
