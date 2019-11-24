package com.bw.controller;

import com.bw.entity.*;
import com.bw.service.MoneysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("product")
public class UserController {
    @Autowired
    private MoneysService moneysService;
    //计算余额
    @GetMapping("/user/returnMoney")
    public BigDecimal selectByHetongId( ReturnMoneyVO returnMoneyVO){
        return moneysService.selectByHetongId(returnMoneyVO);
    }
    //查询列表+条件查询
    @RequestMapping("/user/list")
    public PageResult<Moneys> list(@RequestBody MoneysVO moneysVO){
        Page<Moneys> page = moneysService.selectMoneyList(moneysVO);
        return new PageResult<Moneys>(page.getContent(),page.getTotalElements(),page.getTotalPages(),moneysVO.getPageNum(),moneysVO.getPageSize());
    }
    //根据id查询回款表
    @GetMapping("/user/getByIdMoney")
    public Moneys getByIdMoney(String id){
        return moneysService.selectMoney(id);
    }
    //查询合同集合
    @GetMapping("/user/getHetonglist")
    public List<Hetong> getHetonglist(){
        return moneysService.selectHetongList();
    }
    //添加
    @PostMapping("/user/add")
    public boolean add(@RequestBody Moneys moneys){
        System.err.println(moneys);
        return moneysService.add(moneys)>0;
    }
    //删除
    @GetMapping("/user/del")
    public boolean del(String ids){
        String[] split = ids.split(",");
        return moneysService.del(split)>0;
    }

}
