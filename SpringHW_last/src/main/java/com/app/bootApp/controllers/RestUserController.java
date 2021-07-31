package com.app.bootApp.controllers;

import com.app.bootApp.dao.interfaces.UserDao;
import com.app.bootApp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class RestUserController {
    UserDao userDao;

    @GetMapping("/users/{id}")
    public User getBookInfo(@PathVariable long id) throws IllegalArgumentException {
        Optional<User> optional = userDao.getUserById(id);

        return optional.orElseThrow(() -> new IllegalArgumentException("No user with such id!"));
    }

    @GetMapping(value = "/users/list")
    public List<User> getBookList()  {
        return userDao.getAllUsers();
    }

    @PostMapping("/users/new")
    public User addNewUser(@RequestBody User user){
        return userDao.addUser(user);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
