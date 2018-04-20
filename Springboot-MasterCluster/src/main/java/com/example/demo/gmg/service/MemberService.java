package com.example.demo.gmg.service;

import com.example.demo.gmg.bean.Member;

public interface MemberService {
   int insert(Member member);
   Member findById(int id);
   Member findBySlaveId(int id);
   Member findByMasterId(int id);
}
