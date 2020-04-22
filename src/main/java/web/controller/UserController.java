package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.User;
import web.service.UserDetailsServiceImp;
import web.service.UserService;

import java.util.*;

@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


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
        String [] checkedRoles = new String[]{"user"};
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addUser(@ModelAttribute("user") User user, @RequestParam("checkedRoles") String[] checkedRoles) {
        ModelAndView modelAndView = new ModelAndView();
        User userDS = new User();
        userDS = userService.getUserByName(user.getUsername());
        if (userDS != null) {
            return modelAndView;
        }
        modelAndView.setViewName("redirect: /users");
        List<Role> roles = new ArrayList<>();
        for(String role : checkedRoles){
            roles.add(userService.getRoleByName(role));
        }
        user.setRoles(roles);
        userService.add(user);
        return modelAndView;
    }

    @GetMapping("/admin/edit/{id}")
    public ModelAndView editUserPage(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        User user = userService.getUserById(id);
//        List<Role> roles = user.getRoles();
//        String[] checkedRoles = new String[roles.size() + 1];
//        checkedRoles[0] = "1";
//        int i = 0;
//        for (Role role:roles){
//            i++;
//            checkedRoles[i] = role.getRole();
//        }

        modelAndView.addObject("user", user);
        modelAndView.addObject("id", id);
//        modelAndView.addObject(checkedRoles);
        return modelAndView;
    }
//    @ModelAttribute("rolesList")
//    public List<String> rolesList(){
//        List<String> rolesList = new ArrayList<>();
//        rolesList.add("admin");
//        rolesList.add("user");
//        rolesList.add("anonim");
//        return rolesList;
//    }
    @PostMapping("/admin/edit/{id}")
    public ModelAndView editUser(@RequestParam(value="id") Long id,@RequestParam("checkedRoles") String[] checkedRoles,
                           @ModelAttribute("user") User user, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /users");
        user.setId(id);
        List<Role> roles = new ArrayList<>();
        for(String role : checkedRoles){
            roles.add(userService.getRoleByName(role));
        }
        user.setRoles(roles);
        userService.update(user);
        return modelAndView;
    }

    @GetMapping("/admin/delete/{id}")
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
