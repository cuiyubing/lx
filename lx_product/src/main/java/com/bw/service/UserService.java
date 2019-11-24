package com.bw.service;

import com.bw.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "lx-server" )
public interface UserService {
    @GetMapping("/product/user/returnMoney")
    public BigDecimal selectByHetongId(@RequestBody ReturnMoneyVO returnMoneyVO);
    //查询列表+条件查询
    @GetMapping("/product/user/list")
    public PageResult<Moneys> list(MoneysVO moneysVO);
    //根据id查询回款表
    @GetMapping("/product/user/getByIdMoney")
    public Moneys getByIdMoney(@RequestParam("id")String id);
    //查询合同集合
    @GetMapping("/product/user/getHetonglist")
    public List<Hetong> getHetonglist();
    //添加
    @PostMapping("/product/user/add")
    public boolean add(@RequestBody Moneys moneys);
    //删除
    @GetMapping("/product/user/del")
    public boolean del(@RequestParam("ids")String ids);
}
