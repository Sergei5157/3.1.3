package web.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.spring_boot.models.Role;
import web.spring_boot.models.User;
import web.spring_boot.service.RoleService;
import web.spring_boot.service.UserService;


import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "admin/users")
    public String allUsers(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUserEmail(principal.getName()));
        model.addAttribute("users", userService.getAll());
        model.addAttribute("newUser", new User());
        model.addAttribute("role", roleService.getAll());
        return "admin-page";
    }

    @GetMapping(value = "/user")
    public String infoUser(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUserEmail(principal.getName()));
        return "user-page";
    }


    @PostMapping(value = "admin/newuser")
    public String create(@ModelAttribute("user") User user, @RequestParam(name = "roleId") long[] roleId) {
        Set<Role> role = new HashSet<>();
        for (Long id : roleId) {
            role.add(roleService.getOne(id));
        }
        user.setRoles(role);
        userService.add(user);
        return "redirect:users";
    }


    @PostMapping(value = "admin/delete")
    public String delete(@ModelAttribute("user") User user) {
        userService.remove(user);
        return "redirect:users";
    }

    @GetMapping(value = "/admin/edit")
    @ResponseBody
    public User edit(Long id) {
        return userService.getOne(id);
    }
}

