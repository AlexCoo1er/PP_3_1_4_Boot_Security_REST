package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;

@Controller
public class AdminUserController {

    private final UserService userService;
    private final RoleService roleService;

    private final UserServiceImpl userServiceImpl;

    public AdminUserController(UserService userService, RoleService roleService, UserServiceImpl userServiceImpl) {
        this.userService = userService;
        this.roleService = roleService;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/admin")
    public String getUserForAdmin (Model model, Authentication authentication) {
        model.addAttribute("userList", userService.getAllUsers());
        User user = (User) authentication.getPrincipal();
        model.addAttribute("userPrincipal", user);
        model.addAttribute("roleList", roleService.getList());
        model.addAttribute("userId", userService.getUser(user.getId()));
        return "admin-user";
    }


    @GetMapping("/user")
    public String getUserForUser(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);

        return "user";
    }
    @GetMapping("/user")
    public String edit(Model model, Principal principal) {
        model.addAttribute("user",
                userServiceImpl.loadUserByUsername(principal.getName()));
        return "user";
    }

}
