package com.app.bootApp.dao.services;

import com.app.bootApp.dao.interfaces.UserDao;
import com.app.bootApp.dao.repositories.UserRepository;
import com.app.bootApp.entities.User;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Cacheable("listCache")
    @Override
    public List<User> getAllUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @CachePut(value = "singleCache", condition = "#result != null", key = "#result.id")
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Cacheable("listCache")
    @Override
    public List<User> getByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    @Cacheable("listCache")
    @Override
    public List<User> getUsersByLogin(String login) {
        return userRepository.getUsersByLogin(login);
    }

    @Scheduled(fixedRate = 60000, fixedDelay = 600000)
    @CacheEvict("listCache")
    @Override
    public void clearCache() {
        System.out.println("LOG: listCache was cleared!");
    }
}
