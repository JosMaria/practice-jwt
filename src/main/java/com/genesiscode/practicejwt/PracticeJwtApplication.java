package com.genesiscode.practicejwt;

import com.genesiscode.practicejwt.domain.Role;
import com.genesiscode.practicejwt.domain.User;
import com.genesiscode.practicejwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class PracticeJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeJwtApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {

            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Jose Maria", "jose maria", "1234", new HashSet<>()));
            userService.saveUser(new User(null, "Rafael", "rafael", "1234", new HashSet<>()));
            userService.saveUser(new User(null, "Jason", "jason", "1234", new HashSet<>()));
            userService.saveUser(new User(null, "Carlos", "carlos", "1234", new HashSet<>()));

            userService.addRoleToUser("jose maria", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("jose maria", "ROLE_ADMIN");
            userService.addRoleToUser("rafael", "ROLE_USER");
            userService.addRoleToUser("carlos", "ROLE_MANAGER");
            userService.addRoleToUser("jason", "ROLE_MANAGER");
            userService.addRoleToUser("jason", "ROLE_USER");
            userService.addRoleToUser("jason", "ROLE_ADMIN");
        };
    }
}
