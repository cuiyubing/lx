package com.bw.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "lx-server" )
public interface UserService {
    @RequestMapping("/product/user/list")
    public List<String> getList();
}
