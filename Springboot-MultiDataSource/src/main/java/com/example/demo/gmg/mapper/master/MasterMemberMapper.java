package com.example.demo.gmg.mapper.master;

import com.example.demo.gmg.bean.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MasterMemberMapper {
	
	int insertSelective(Member record);
    
	Member findById(@Param("id") int id);
}
