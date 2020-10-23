package com.crizillion.springcloud.mastersrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RefreshScope
public class UserController {

    @Value("${message}")
    private String msg;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public Collection<User> findUser(@RequestParam String userName){
        return userRepository.findByUserName(userName);
    }

    @GetMapping("/message")
    String getMessage(){
        return msg;
    }

}
