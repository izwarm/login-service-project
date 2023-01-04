package com.learn.test.service.impl;

import com.learn.test.model.UserRoles;
import com.learn.test.repo.UserRolesRepository;
import com.learn.test.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRolesRepository userRolesRepository;

    @Override
    public void addRoleWithSignUp(UserRoles userRoles) {
        userRolesRepository.save(userRoles);
    }
}
