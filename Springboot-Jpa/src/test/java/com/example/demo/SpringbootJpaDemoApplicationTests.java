package com.example.demo;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootJpaDemoApplication.class)
public class SpringbootJpaDemoApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	public void test() {
		/*List<User> u=userRepository.findByAgeLessThan(13);
		for (User user:u){
			System.out.println(user.getId());
		}*/
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Pageable pageable=new PageRequest(0,5);
		Page<User> page=userRepository.findByName(pageable,"gmg");
		for (User user:page){
			System.out.println(user.getId());
		}
	}

}
