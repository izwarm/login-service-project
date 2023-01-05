package com.learn.test.configuration;

import com.learn.test.repo.ItemRepository;
import com.learn.test.repo.RoleRepository;
import com.learn.test.repo.UserRolesRepository;
import com.learn.test.repo.UsersRepository;
import com.learn.test.service.ItemService;
import com.learn.test.service.LoginService;
import com.learn.test.service.impl.ItemServiceImpl;
import com.learn.test.service.impl.LoginServiceImpl;
import com.learn.test.util.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public LoginService loginService(UsersRepository usersRepository, RoleRepository roleRepository, UserRolesRepository userRolesRepository) {
        return new LoginServiceImpl(usersRepository, roleRepository, userRolesRepository);
    }

    @Bean
    public ItemService itemService(ItemRepository itemRepository) {
        return new ItemServiceImpl(itemRepository);
    }
}
