package com.bw.dao;

import com.bw.entity.Moneys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MoneysDao extends JpaRepository<Moneys,String>, JpaSpecificationExecutor<Moneys> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value="delete from t_moneys where return_code in (?1)")
    int deleteAllByIds(@Param("ids") String[] ids);

    List<Moneys> findAllByHetong_HetongId(String hetongId);

    Moneys findByReturnCode(String returnCode);
}
