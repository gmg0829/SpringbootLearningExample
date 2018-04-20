package com.example.demo.gmg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.gmg.bean.Member;
import com.example.demo.gmg.service.MemberService;
@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	@RequestMapping(value="/login")
	public String login(Member member,HttpServletRequest request){
	  memberService.insert(member);
			 return "index";
	
	
 }
	@RequestMapping(value="/index")
	public String index(Model model,HttpServletRequest request){
		 return "hello";
	
	
 }
	 @RequestMapping(value = "/api/member/{id}", method = RequestMethod.GET)
	    public Member findOneMember(@PathVariable("id") int id) {
	        return memberService.findById(id);
	    }
	 
	 @RequestMapping(value = "master/{id}", method = RequestMethod.GET)
	    public Member findByMasterId(@PathVariable("id") int id) {
		 Member member=memberService.findByMasterId(id);
		 System.out.println(member.getUsername());
	        return memberService.findByMasterId(id);
	    }
	 @RequestMapping(value = "slave/{id}", method = RequestMethod.GET)
	    public Member findBySlaveId(@PathVariable("id") int id) {
		 Member member=memberService.findBySlaveId(id);
		 System.out.println(member.getUsername());
	        return memberService.findBySlaveId(id);
	    }
	
}
