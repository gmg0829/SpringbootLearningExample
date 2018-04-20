package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.gmg.user.SpringbootJdbctemplateApplication;
import com.gmg.user.domain.User;
import com.gmg.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootJdbctemplateApplication.class) 
public class SpringbootJdbctemplateApplicationTests {

	 @Autowired
	 private UserService userService;
	 @Test
		public void test() throws Exception {
	
			//userService.create("gmgg", 1);
		 List<User> list=userService.getAllUsers();
          for(User u:list){
        	  System.out.println(u.getId()+"----"+u.getUsername());
          }

		}
}
