package com.example.demo.gmg.master.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.gmg.bean.Member;
@Mapper
public interface MasterMemberMapper {
	
	int insertSelective(Member record);
    
	Member findById(@Param("id") int id);
}
