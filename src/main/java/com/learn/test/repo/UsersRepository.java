package com.learn.test.repo;

import com.learn.test.model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUsernameIgnoreCaseAndPassword(String username, String password);

}
