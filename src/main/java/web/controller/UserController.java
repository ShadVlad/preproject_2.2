package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.User;
import web.service.UserDetailsServiceImp;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/")
//    public String homePage() {
//        return "redirect: /users";
//    }

    @GetMapping("/admin")
    public ModelAndView allUsers(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /users");
        return modelAndView;
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
        User addUser = new User();
        Set<Role> checkedRoles = addUser.getRoles();
        //checkedRoles.add()
        //String [] checkedRoles = new String[]{"user"};
        model.addAttribute("adduser", addUser);
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
    @ModelAttribute("rolesList")
    public List<String> rolesList(){
        List<String> rolesList = new ArrayList<>();
        rolesList.add("admin");
        rolesList.add("user");
        rolesList.add("anonim");
        return rolesList;
    }
    @PostMapping("/edit/{id}")
    public String editUser(@RequestParam(value="id") Long id,
                                 @ModelAttribute("user") User user, Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/admin");
        user.setId(id);
        userService.update(user);
        return "/users";
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

    @GetMapping(value = "/user")
    public String userPage(Authentication authentication, ModelMap model){
        User user = userService.getUserByName(authentication.getName());
        model.addAttribute("user", user);
        return "user";
    }

//    @GetMapping(value = "/logout")
//    public String loginPage(Authentication authentication, ModelMap model){
//
//        //User user = userService.getUserByName(authentication.getName());
//
//        return "login";
//    }

}
