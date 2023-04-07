package com.group02.mobileshopsystem.api.Controller;

import com.group02.mobileshopsystem.api.Model.User;
import com.group02.mobileshopsystem.api.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private  UserService userService;
    @GetMapping("/get")
    public List<User> getAllUser() {
        List<User> userList=userService.getAllUser();
        for (User u:userList) {
            u.setTokens(null);
            u.setPassword(null);
        }
        return userList;
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUserById(@RequestParam int id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
