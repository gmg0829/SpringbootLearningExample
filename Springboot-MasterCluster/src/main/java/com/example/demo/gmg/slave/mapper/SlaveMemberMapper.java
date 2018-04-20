package com.example.demo.gmg.slave.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.gmg.bean.Member;
@Mapper
public interface SlaveMemberMapper {
	
	int insertSelective(Member record);
    
	Member findById(@Param("id") int id);
}
