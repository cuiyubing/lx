package com.bw.service;

import com.bw.entity.Hetong;
import com.bw.entity.Moneys;
import com.bw.entity.MoneysVO;
import com.bw.entity.ReturnMoneyVO;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface MoneysService {
    //列表+分页+模糊查询
    Page<Moneys> selectMoneyList(MoneysVO moneysVO);
    //查询合同+返回余额
    BigDecimal selectByHetongId(ReturnMoneyVO returnMoneyVO);
    //添加
    int add(Moneys moneys);
    //删除
    int del(String[] ids);
    //查询合同
    List<Hetong> selectHetongList();
    //查询单条回款记录
    Moneys selectMoney(String returnCode);
}
