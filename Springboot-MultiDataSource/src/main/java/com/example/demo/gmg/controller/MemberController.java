package com.example.demo.gmg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.gmg.bean.Member;
import com.example.demo.gmg.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	 @RequestMapping(value = "master/{id}", method = RequestMethod.GET)
	 @ResponseBody
	 public Member findByMasterId(@PathVariable("id") int id) {
		 Member member=memberService.findByMasterId(id);
		 System.out.println(member.getUsername());
	        return memberService.findByMasterId(id);
	    }
	 @RequestMapping(value = "slave/{id}", method = RequestMethod.GET)
	 @ResponseBody
	    public Member findBySlaveId(@PathVariable("id") int id) {
		 Member member=memberService.findBySlaveId(id);
		 System.out.println(member.getUsername());
	        return memberService.findBySlaveId(id);
	    }
	
}
