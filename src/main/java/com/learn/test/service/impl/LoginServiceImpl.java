package com.learn.test.service.impl;

import com.learn.test.model.UserRoles;
import com.learn.test.model.request.LoginRequestDTO;
import com.learn.test.model.request.SignUpRequestDTO;
import com.learn.test.model.response.APIResponse;
import com.learn.test.model.response.ResponseStatus;
import com.learn.test.model.role.Roles;
import com.learn.test.model.users.Users;
import com.learn.test.repo.UsersRepository;
import com.learn.test.service.LoginService;
import com.learn.test.service.RoleService;
import com.learn.test.service.UserRoleService;
import com.learn.test.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {


    private final UsersRepository usersRepository;

    private final JwtUtils jwtUtils;

    private final RoleService roleService;

    private final UserRoleService userRoleService;

    @Override
    public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) throws Exception {

        APIResponse apiResponse = new APIResponse();

        Users userSign = new Users();

        if (signUpRequestDTO.getUsername() != null) {
            userSign.setUsername(signUpRequestDTO.getUsername());
        }
        if (signUpRequestDTO.getPassword() != null) {
            userSign.setPassword(signUpRequestDTO.getPassword());
        }
        if (signUpRequestDTO.getPhoneNumber() != null) {
            userSign.setPhoneNumber(signUpRequestDTO.getPhoneNumber());
        }
        if (signUpRequestDTO.getGender() != null) {
            userSign.setGender(signUpRequestDTO.getGender());
        }
        if (Boolean.TRUE.equals(signUpRequestDTO.getIsActive())) {
            userSign.setIsActive(Boolean.TRUE);
        }

        UserRoles userRoles = new UserRoles();
        Roles role = null;
        if (signUpRequestDTO.getRoleCode() != null) {
            role = roleService.findRoleCode(signUpRequestDTO.getRoleCode());
        }
        if (role == null) {
            apiResponse.setError(new Exception("Role not found"));
            ResponseStatus responseStatus = ResponseStatus.fromString(ResponseStatus.INACTIVE_USER_LOGIN.getHttpStatusCode());
            apiResponse.setStatus(responseStatus);
        }

        userSign.setLoginAt(LocalDate.now());
        userSign.setCreateAt(LocalDate.now());

        userSign = usersRepository.save(userSign);
        userRoles.setUserRoleId(userRoles.getUserRoleId());
        userRoles.setRoleCode(role.getRoleCode());
        userRoleService.addRoleWithSignUp(userRoles);

        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setResponseData(userSign);

        return apiResponse;
    }

    @Override
    public APIResponse login(LoginRequestDTO loginRequestDTO) {

        APIResponse apiResponse = new APIResponse();

        Users user = usersRepository.findByUsernameIgnoreCaseAndPassword(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());

        if (user == null) {
            apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            apiResponse.setResponseData("User login failed");
            return apiResponse;
        }

        String token = jwtUtils.generateJwt(user);
        Map<String, Object> data = new HashMap<>();
        data.put("accessToken", token);

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setResponseData(data);


        return apiResponse;
    }
}
