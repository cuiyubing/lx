package com.bw.service.impl;

import com.bw.dao.HeToDao;
import com.bw.dao.MoneysDao;
import com.bw.entity.Hetong;
import com.bw.entity.Moneys;
import com.bw.entity.MoneysVO;
import com.bw.entity.ReturnMoneyVO;
import com.bw.service.MoneysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.*;

@Service
public class MoneysServiceImpl implements MoneysService {

    @Autowired
    private MoneysDao moneysDao;
    @Autowired
    private HeToDao heToDao;

    @Override
    public BigDecimal selectByHetongId(ReturnMoneyVO returnMoneyVO) {
        String hetongId = returnMoneyVO.getHetongId();
        BigDecimal returnMoney = returnMoneyVO.getReturnMoney();
        Optional<Hetong> heToDaoById = heToDao.findById(hetongId);//通过合同编号查询合同
        if(heToDaoById.isPresent()){//判断是否存在
            Hetong hetong = heToDaoById.get();
            BigDecimal hetongMoney = hetong.getHetongMoney();//获得合同金额

            List<Moneys> list = moneysDao.findAllByHetong_HetongId(hetongId);//通过合同编号查询回款记录
            System.out.println(list);
            BigDecimal num= new BigDecimal(0);
            if(list!=null&&list.size()>0){//判断是否有汇款记录
                for(Moneys m:list){
                    hetongMoney=hetongMoney.subtract(m.getReturnMoney());//用合同金额-每次回款金额
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

       return moneysDao.findByReturnCode(returnCode);
    }

    @Override
    public Page<Moneys> selectMoneyList(MoneysVO moneysVO) {
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(moneysVO.getHetongId()!=null){
                    Predicate p1 = cb.equal(root.get("hetong").get("hetongId"), moneysVO.getHetongId());
                    list.add(p1);
                }
                if(moneysVO.getType()!=null){
                    Predicate p2 = cb.like(root.get(moneysVO.getType()), "%" + moneysVO.getContent() + "%");
                    list.add(p2);
                }
                if(moneysVO.getHuiTimestart()!=null){
                    Predicate p3 = cb.greaterThan(root.get("returnTime"), moneysVO.getHuiTimestart());
                    list.add(p3);
                }
                if(moneysVO.getHuiTimeend()!=null){
                    Predicate p4 = cb.lessThan(root.get("returnTime"), moneysVO.getHuiTimeend());
                    list.add(p4);
                }
                if(moneysVO.getPropName()!=null){
                    if(moneysVO.getStartyue()!=null){
                        Predicate p5 = cb.ge(root.get("yue"), moneysVO.getStartyue());
                        list.add(p5);
                    }
                    if(moneysVO.getEndyue()!=null){
                        Predicate p6 = cb.ge(root.get("yue"), moneysVO.getEndyue());
                        list.add(p6);
                    }
                }
                Predicate[] arr = list.toArray(new Predicate[list.size()]);
                return cb.and(arr);
            }
        };
        return moneysDao.findAll(spec,PageRequest.of(moneysVO.getPageNum()-1,moneysVO.getPageSize()));
    }

    @Override
    public int add(Moneys moneys) {
        Moneys moneys1 = moneysDao.save(moneys);
        if(moneys1!=null){
            return 1;
        }
        return 1;
    }

    @Override
    public int del(String[] ids) {
        return moneysDao.deleteAllByIds(ids);
    }

    @Override
    public List<Hetong> selectHetongList() {
        return heToDao.findAll();
    }
}
