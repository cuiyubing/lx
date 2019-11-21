package com.bw.service.impl;

import com.bw.dao.HeToDao;
import com.bw.dao.MoneysDao;
import com.bw.entity.Hetong;
import com.bw.entity.Moneys;
import com.bw.entity.MoneysVO;
import com.bw.service.MoneysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class MoneysServiceImpl implements MoneysService {

    @Autowired
    private MoneysDao moneysDao;
    @Autowired
    private HeToDao heToDao;

    @Override
    public BigDecimal selectByHetongId(String hetongId, BigDecimal returnMoney) {
        Optional<Hetong> heToDaoById = heToDao.findById(hetongId);//通过合同编号查询合同
        if(heToDaoById.isPresent()){//判断是否存在
            Hetong hetong = heToDaoById.get();
            BigDecimal hetongMoney = hetong.getHetongMoney();//获得合同金额

            List<Moneys> list = moneysDao.findAllByHetong_HetongId(hetongId);//通过合同编号查询回款记录
            BigDecimal num= new BigDecimal(0);
            if(list!=null&&list.size()>0){//判断是否有汇款记录
                for(Moneys m:list){
                    hetongMoney.subtract(m.getReturnMoney());//用合同金额-每次回款金额
                }
                return hetongMoney.subtract(returnMoney);//再减去本次回款金额
            }else{
                return hetongMoney.subtract(returnMoney);
            }
        }

        return null;
    }

    @Override
    public Moneys selectMoney(String returnCode) {
        return null;
    }

    @Override
    public Page<Moneys> selectMoneyList(MoneysVO moneysVO) {
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {



                return null;
            }
        };
        return null;
    }

    @Override
    public int add(Moneys moneys) {
        return 0;
    }

    @Override
    public int del(String[] ids) {
        return 0;
    }

    @Override
    public List<Hetong> selectHetongList() {
        return null;
    }
}
