package com.example.demo.gmg.service.impl;


import com.example.demo.gmg.mapper.master.MasterMemberMapper;
import com.example.demo.gmg.mapper.slave.SlaveMemberMapper;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.gmg.bean.Member;
import com.example.demo.gmg.service.MemberService;
@Transactional
@Service
public class MemberServiceImpl implements MemberService{
	Logger log=Logger.getLogger(getClass());
     @Autowired
     private MasterMemberMapper masterMemberMapper;
     @Autowired
     private SlaveMemberMapper slaveMemberMapper;

	@Override
	public Member findBySlaveId(int id) {
		return slaveMemberMapper.findById(id);
	}
	@Override
	public Member findByMasterId(int id) {
		return masterMemberMapper.findById(id);
	}

}
