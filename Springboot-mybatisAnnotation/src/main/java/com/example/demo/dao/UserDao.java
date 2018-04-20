/**
 * 
 */
package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.User;

/** 
* @ClassName: UserDao 
* @Description: TODO
* @author gmg 
* @date 2017年8月15日 上午10:10:00  
*/
@Mapper
public interface UserDao {
	@Select("select * from user where id=#{id}")
	@Results({
		@Result(property="id",column="id"),
		@Result(property="name",column="name"),
		@Result(property="pwd",column="pwd"),
	})
   User findById(@Param("id") int id);
}
