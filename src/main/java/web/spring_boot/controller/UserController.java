package web.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.spring_boot.service.RoleService;
import web.spring_boot.service.UserService;

import java.security.Principal;

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

    @GetMapping(value = "/admin/users")
    public String getPage(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUserEmail(principal.getName()));

        return "admin-page";
    }
    @GetMapping(value = "/user")
    public String infoUser(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUserEmail(principal.getName()));
        return "user-page";
    }
}
