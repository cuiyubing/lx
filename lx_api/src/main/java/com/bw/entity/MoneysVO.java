package com.bw.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MoneysVO implements Serializable {
    //合同编号
    private String hetongId;
    //类型  备注/收款人
    private String type;
    //内容
    private String content;

    //回款开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date huiTimestart;
    //汇款结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date huiTimeend;
    //金额 余款/回款
    private String propName;
    //最小余额
    private BigDecimal startyue;
    //最大余额
    private BigDecimal endyue;

    private Integer pageNum;
    private Integer pageSize;




}
