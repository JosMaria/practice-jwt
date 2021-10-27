package com.genesiscode.practicejwt.service;

import com.genesiscode.practicejwt.domain.Role;
import com.genesiscode.practicejwt.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
