package com.bw.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "t_moneys")
public class Moneys implements Serializable {
    @Id
    private String returnCode;//回款编号
    @ManyToOne
    @JoinColumn(name = "hetong_id",referencedColumnName = "hetong_id")
    private Hetong hetong;//合同编号

    private BigDecimal returnMoney;//回款金额
    private String returnName;//回款人
    private String coment;//备注
    private BigDecimal yue;//余款
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnTime;//回款时间
    private BigDecimal hetongMoney;//合同金额



}
