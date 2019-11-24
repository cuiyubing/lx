package com.bw.contrller;

import com.bw.entity.*;
import com.bw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProController {
    @Autowired
    private UserService userService;
    @GetMapping("/user/returnMoney")
    public BigDecimal selectByHetongId(@RequestBody ReturnMoneyVO returnMoneyVO){
        return userService.selectByHetongId(returnMoneyVO);
    }
    //查询列表+条件查询
    @RequestMapping("/user/list")
    public PageResult<Moneys> list(MoneysVO moneysVO){
        return userService.list(moneysVO);
    }
    //根据id查询回款表
    @GetMapping("/user/getByIdMoney")
    public Moneys getByIdMoney(String id){
        return userService.getByIdMoney(id);
    }
    //查询合同集合
    @GetMapping("/user/getHetonglist")
    public List<Hetong> getHetonglist(){
        return userService.getHetonglist();
    }
    //添加
    @PostMapping("/user/add")
    public boolean add(@RequestBody Moneys moneys){
        return userService.add(moneys);
    }
    //删除
    @GetMapping("/user/del")
    public boolean del(String ids){
//        String[] split = ids.split(",");
//        System.out.println(split);

        return userService.del(ids);
    }

}
