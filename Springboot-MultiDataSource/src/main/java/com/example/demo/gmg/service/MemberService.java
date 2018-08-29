package com.example.demo.gmg.service;

import com.example.demo.gmg.bean.Member;

public interface MemberService {

   Member findBySlaveId(int id);

   Member findByMasterId(int id);
}
