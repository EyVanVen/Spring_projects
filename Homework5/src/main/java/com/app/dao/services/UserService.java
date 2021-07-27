package com.app.dao.services;

import com.app.dao.interfaces.UserDao;
import com.app.dao.repositories.UserRepository;
import com.app.entities.User;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDao {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByLogin(String login) {
        return userRepository.getUsersByLogin(login);
    }

}
