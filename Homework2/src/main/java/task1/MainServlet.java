package task1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainServlet {

    List<User> list = new ArrayList<>();

    File file = new File("C:\\Users\\BVA\\IdeaProjects\\Homework2\\src\\main\\java\\task1\\Users.txt");

    @GetMapping(value = "/form")
    public String getForm() {
        return "form.jsp";
    }

    @PostMapping(value = "/form")
    public ModelAndView passDataFromUser(@ModelAttribute("user") User user, ModelAndView modelAndView) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        modelAndView.addObject("user", user);

        writer.write(user.toString());
        System.out.println(user);

        modelAndView.setViewName("result.jsp");

        list.add(user);

        return modelAndView;
    }

    @GetMapping(value = "/all")
    public ModelAndView listAll(ModelAndView modelAndView) {
        modelAndView.addObject("list", list);
        modelAndView.addObject("total", list.size());

        modelAndView.setViewName("all.jsp");
        return modelAndView;
    }
}
