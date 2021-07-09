package task1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class MainServlet {

    List<User> list = new ArrayList<>();

    File file = new File("C:\\Users\\BVA\\IdeaProjects\\Homework2\\src\\main\\java\\task1\\Users.txt");

    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    BufferedReader reader = new BufferedReader(new FileReader(file));

    public MainServlet() throws IOException {
    }

    @GetMapping(value = "/form")
    public String getForm() {
        return "form.jsp";
    }

    @PostMapping(value = "/form")
    public ModelAndView passDataFromUser(@ModelAttribute("user") User user, ModelAndView modelAndView) throws IOException {

        modelAndView.addObject("user", user);

        System.out.println(user);

        modelAndView.setViewName("result.jsp");

        list.add(user);
        writer.append(user.toString());
        writer.newLine();

        writer.flush();

        return modelAndView;
    }

    @GetMapping(value = "/all")
    public ModelAndView listAll(ModelAndView modelAndView) throws IOException {

        Scanner scan = new Scanner(file);

        while (scan.hasNext()){
            scan.nextLine();
            modelAndView.addObject(reader.readLine());
        }

        reader.close();

        modelAndView.addObject("list", list);
        modelAndView.addObject("total", list.size());

        modelAndView.setViewName("all.jsp");
        return modelAndView;
    }
}
