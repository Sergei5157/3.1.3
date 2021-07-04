package web.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import web.spring_boot.models.Role;
import web.spring_boot.models.User;
import web.spring_boot.service.RoleService;
import web.spring_boot.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = AdminRestController.ADMIN_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {

    public static final String ADMIN_URL = "/admin/page";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @PostMapping(value = "/users")
    public List<User> allUsers() {
        return userService.getAll();
    }

    @PostMapping(value = "/add")
    public void create(@RequestParam String firstName, String password, String lastName, String email, byte age, @RequestParam(name = "roleId") long[] roleId) {
        User user = new User(firstName, lastName, age, email, password);
        roleService.relation(user, roleId);
        userService.add(user);
    }

    @PostMapping(value = "/edit")
    public void create(@RequestParam Long id, String firstName, String password, String lastName, String email, byte age, @RequestParam(name = "roleId") long[] roleId) {
        User user = new User(id, firstName, lastName, age, email, password);
        roleService.relation(user, roleId);
        userService.add(user);
    }

    @PostMapping(value = "/delete")
    public void delete(@RequestParam Long id) {
        userService.remove(id);
    }


    @PostMapping(value = "/roles")
    public List<Role> getRoles() {
        return roleService.getAll();
    }
}

