package com.app.dao.interfaces;


import com.app.entities.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getAllUsers();

    List<User> getUserById(Long id);

    List<User> getByEmail(String email);

    List<User> getUsersByLogin(String login);
}

