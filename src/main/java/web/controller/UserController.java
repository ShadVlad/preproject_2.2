package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "redirect: /users";
    }

    @GetMapping("/users")
    public String printUsers(ModelMap model) {
        List<User> users = userService.listAllUsers();
        model.addAttribute("users", users);
        return "/users";
    }

    @GetMapping("/add")
    public ModelAndView addPage(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /users");
        userService.add(user);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUserPage(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editUser(@RequestParam(value="id") Long id,
                                 @ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /users");
        user.setId(id);
        userService.update(user);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /users");
        User user = userService.getUserById(id);
        if (user != null) {
            userService.delete(user);
        }
        return modelAndView;
    }
}
