package com.bw.dao;

import com.bw.entity.Hetong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HeToDao extends JpaRepository<Hetong,String>, JpaSpecificationExecutor<Hetong> {
}
