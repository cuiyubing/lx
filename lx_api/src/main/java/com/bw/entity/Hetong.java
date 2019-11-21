package com.bw.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_hetong")
public class Hetong implements Serializable {
    @Id
    private String hetongId;//合同编号
    private String uid;//客户编号
    private BigDecimal hetongMoney;//合同金额;
    private String coment;//备注

}
