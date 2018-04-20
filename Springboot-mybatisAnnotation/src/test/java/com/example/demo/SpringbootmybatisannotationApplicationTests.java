package com.example.demo;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringbootmybatisannotationApplication.class)
public class SpringbootmybatisannotationApplicationTests {
	@Autowired
	UserService userService;
	@Test
	public void contextLoads() {
	User user=userService.findById(4);
	System.out.println(user.getName());
	}
	@Autowired
	private Task task;

	@Test
	public void test() throws Exception {

		long start = System.currentTimeMillis();

		Future<String> task1 = task.doTask1();
		Future<String> task2 = task.doTask2();
		Future<String> task3 = task.doTask3();

		while(true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

	}
}
