package com.bw.contrller;

import com.bw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("product")
public class ProController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user/list")
    public List<String> getList(){
        return userService.getList();
    }
}
