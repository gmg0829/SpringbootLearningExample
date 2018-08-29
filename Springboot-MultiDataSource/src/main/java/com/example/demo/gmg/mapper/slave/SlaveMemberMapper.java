package com.example.demo.gmg.mapper.slave;

import com.example.demo.gmg.bean.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SlaveMemberMapper {
	
	int insertSelective(Member record);
    
	Member findById(@Param("id") int id);
}
