package com.bw.controller;

import com.bw.service.MoneysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("product")
public class UserController {
    @Autowired
    private MoneysService moneysService;
    @RequestMapping("/user/list")
    public List<String> getList(){
        return Arrays.asList("张三","李四","王五") ;
    }
    @RequestMapping("/user/returnMoney")
    public BigDecimal selectByHetongId(String hetongId, BigDecimal returnMoney){
        return moneysService.selectByHetongId(hetongId,returnMoney);
    }
}
