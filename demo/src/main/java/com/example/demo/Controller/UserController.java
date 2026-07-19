package com.example.demo.Controller;

import com.example.demo.DTO.User;
import com.example.demo.ServiceImpl.UserServiceiMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserServiceiMPL userServiceiMPL;

    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
       return  userServiceiMPL.register(user);
    }



    @PostMapping("/authenticate")
     public String userLogin(@RequestBody User user)
    {
        System.err.println(user);
       return userServiceiMPL.verifyUser(user);
    }
}
