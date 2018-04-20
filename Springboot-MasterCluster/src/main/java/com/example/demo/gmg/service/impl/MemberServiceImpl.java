package com.example.demo.gmg.service.impl;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.gmg.bean.Member;
import com.example.demo.gmg.mapper.MemberMapper;
import com.example.demo.gmg.master.mapper.MasterMemberMapper;
import com.example.demo.gmg.service.MemberService;
import com.example.demo.gmg.slave.mapper.SlaveMemberMapper;
@Transactional
@Service
public class MemberServiceImpl implements MemberService{
	Logger log=Logger.getLogger(getClass());
     @Autowired
     private MemberMapper memberMapper;
     @Autowired
     private RedisTemplate redisTemplate; 
     @Autowired
     private MasterMemberMapper masterMemberMapper;
     @Autowired
     private SlaveMemberMapper slaveMemberMapper;
	@Override
	public int insert(Member member) {
		return memberMapper.insertSelective(member);
	}
	@Override
	public Member findById(int id) {
		
		// 从缓存中获取城市信息
        String key = "member_" + id;
        ValueOperations<String, Member> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	Member member = operations.get(key);

        	log.info("MemberServiceImpl.findById() : 从缓存中获取了成员 >> " + member.toString());
            return member;
        }

        // 从 DB 中获取城市信息
        Member member = memberMapper.findById(id);

        // 插入缓存
        operations.set(key, member, 10, TimeUnit.SECONDS);
        log.info("MemberServiceImpl.findById() : 成员插入缓存 >> " + member.toString());

        return member;
	}
	@Override
	public Member findBySlaveId(int id) {
		return slaveMemberMapper.findById(id);
	}
	@Override
	public Member findByMasterId(int id) {
		return masterMemberMapper.findById(id);
	}

}
