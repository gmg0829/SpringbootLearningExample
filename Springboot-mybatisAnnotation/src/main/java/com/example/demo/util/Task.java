/**
 * 
 */
package com.example.demo.util;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/** 
* @ClassName: Taskj 
* @Description: TODO
* @author gmg 
* @date 2017年8月16日 上午11:26:11  
*/
@Component
public class Task{
	Random random=new Random();
	@Async
  public Future<String> doTask1() throws Exception{
	  System.out.println("开始任务一");
	  long start=System.currentTimeMillis();
	  Thread.sleep(random.nextInt(10000));
	  long end=System.currentTimeMillis();
	  System.out.println("完成任务一耗时"+(end-start));
	  return new AsyncResult<String>("任务一完成");
  }
	@Async
  public Future<String> doTask2() throws Exception{
	  System.out.println("开始任务二");
	  long start=System.currentTimeMillis();
	  Thread.sleep(random.nextInt(10000));
	  long end=System.currentTimeMillis();
	  System.out.println("完成任务二耗时"+(end-start));
	  return new AsyncResult<String>("任务二完成");
  }
	@Async
  public Future<String> doTask3() throws Exception{
	  System.out.println("开始任务三");
	  long start=System.currentTimeMillis();
	  Thread.sleep(random.nextInt(10000));
	  long end=System.currentTimeMillis();
	  System.out.println("完成任务三耗时"+(end-start));
	  return new AsyncResult<String>("任务三完成");
  }
}
