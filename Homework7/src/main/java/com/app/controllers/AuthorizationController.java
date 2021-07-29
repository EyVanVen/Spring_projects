package com.app.controllers;

import com.app.authorize.Authorization;
import com.app.dao.interfaces.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorizationController {
    private ApplicationContext applicationContext;
    private UserDao userDao;

    @GetMapping(value = "authorize/all")
    public ModelAndView listAllUsers(ModelAndView modelAndView) {

        modelAndView.addObject("list", userDao.getAllUsers());
        modelAndView.setViewName("../users/allUsers.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView) {
        Authorization authorization = applicationContext.getBean("userAuthorized", Authorization.class);
        authorization.setAuthorized(Boolean.TRUE);
        modelAndView.setViewName("authorized.jsp");
        modelAndView.addObject("authorized", authorization);

        return modelAndView;
    }

    @GetMapping(value = "/logout")
    public ModelAndView logout(ModelAndView modelAndView) {
        Authorization authorization = applicationContext.getBean("userAuthorized", Authorization.class);
        authorization.setAuthorized(Boolean.FALSE);
        modelAndView.setViewName("index.jsp");

        return modelAndView;
    }

    @GetMapping(value = "/name/{userName}")
    public ModelAndView greeting(@PathVariable String userName, ModelAndView modelAndView) {
        modelAndView.setViewName("forward:/greeting.jsp");
        modelAndView.addObject("userName", userName);
        return modelAndView;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
