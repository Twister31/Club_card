package com.card_login.card.controller;


import com.card_login.card.entity.UpdateRoleRequest;
import com.card_login.card.entity.User;
import com.card_login.card.service.AppService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class AppControllers {
    private AppService appService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Start page!";
    }

    @PostMapping("/login")
    public String addUser(@RequestBody User user){
        appService.addUser(user);
        return "User added success";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin(){
        return "This page only role admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String user(){
        return "This page only role user and admin";
    }

    @PutMapping("/update_role")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String updateRole(@RequestBody UpdateRoleRequest request){
        appService.updateUserRole(request);
        return "role update";
    }

}
