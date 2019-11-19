package com.bw.contrller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProController {
    @RequestMapping("/user/list")
    public List<String> getList(){
        return Arrays.asList("张三","李四","王五") ;
    }
}
