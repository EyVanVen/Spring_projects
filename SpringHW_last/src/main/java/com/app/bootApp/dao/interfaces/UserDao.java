package com.app.bootApp.dao.interfaces;


import com.app.bootApp.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    User addUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    List<User> getByEmail(String email);

    List<User> getUsersByLogin(String login);

    public void clearCache();
}

