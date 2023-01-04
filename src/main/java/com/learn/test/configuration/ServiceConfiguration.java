package com.learn.test.configuration;

import com.learn.test.repo.BuyersRepository;
import com.learn.test.repo.ItemRepository;
import com.learn.test.repo.UsersRepository;
import com.learn.test.service.*;
import com.learn.test.service.impl.BuyersServiceImpl;
import com.learn.test.service.impl.ItemServiceImpl;
import com.learn.test.service.impl.LoginServiceImpl;
import com.learn.test.util.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public BuyersService buyersService(BuyersRepository buyersRepository) {
        return new BuyersServiceImpl(buyersRepository);
    }

    @Bean
    public LoginService loginService(UsersRepository usersRepository, JwtUtils jwtUtils, UserRoleService userRoleService, RoleService roleService) {
        return new LoginServiceImpl(usersRepository, jwtUtils, roleService, userRoleService);
    }

    @Bean
    public ItemService itemService(ItemRepository itemRepository) {
        return new ItemServiceImpl(itemRepository);
    }
}
