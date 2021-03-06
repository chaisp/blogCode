package com.example.demo.repository;

import com.example.demo.model.po.BaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository <E extends BaseEntity>extends JpaRepository<E,Long>,JpaSpecificationExecutor<E>{
    
}
