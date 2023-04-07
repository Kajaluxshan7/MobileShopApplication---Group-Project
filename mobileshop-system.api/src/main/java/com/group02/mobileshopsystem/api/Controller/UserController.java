package com.group02.mobileshopsystem.api.Controller;

import com.group02.mobileshopsystem.api.Model.User;
import com.group02.mobileshopsystem.api.Services.EmailService;
import com.group02.mobileshopsystem.api.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    public  ResponseEntity<User> getUserDetailsById(@RequestParam Integer id) {
        Optional<User> user= userService.findByUserId(id);
        return ResponseEntity.ok(user.get());
    }
}
