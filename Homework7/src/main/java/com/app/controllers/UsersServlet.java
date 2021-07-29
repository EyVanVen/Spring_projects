package com.app.controllers;

import com.app.dao.interfaces.UserDao;
import com.app.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersServlet {
    //List<User> list = new ArrayList<>();
    private UserDao userDao;

    //@RequestMapping(value = "/form", method = RequestMethod.GET)
    @GetMapping(value = "/add")
    public String getForm() {
        return "addUser.jsp";
    }

    @PostMapping(value = "/add")
    public ModelAndView passDataFromUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        userDao.addUser(user);
        modelAndView.setViewName("newUser.jsp");
        modelAndView.addObject("user", user);

        return modelAndView;
    }


    @GetMapping(value = "/all")
    public ModelAndView listAll(ModelAndView modelAndView) {
        modelAndView.addObject("list", userDao.getAllUsers());
        modelAndView.setViewName("allUsers.jsp");

        return modelAndView;
    }

    @GetMapping(value = "/findId")
    private String findId() {
        return "findId.jsp";
    }

    @PostMapping(value = "/findId")
    private ModelAndView findId(@RequestParam("id") Long id, ModelAndView modelAndView) {
        modelAndView.addObject("list", userDao.getUserById(id));
        modelAndView.setViewName("idResult.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/findEmail")
    private String findEmail(){
        return "findEmail.jsp";
    }


    @PostMapping(value = "/findEmail")
    private ModelAndView findEmail(@RequestParam("email") String email, ModelAndView modelAndView) {

        modelAndView.addObject("list", userDao.getByEmail(email));
        modelAndView.setViewName("emailResult.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/findLogin")
    private String findLogin(){
        return "findLogin.jsp";
    }

    @PostMapping(value = "/findLogin")
    private ModelAndView findLogin(@RequestParam("login") String login, ModelAndView modelAndView){
        modelAndView.addObject("list", userDao.getUsersByLogin(login));
        modelAndView.setViewName("loginResult.jsp");
        return modelAndView;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
