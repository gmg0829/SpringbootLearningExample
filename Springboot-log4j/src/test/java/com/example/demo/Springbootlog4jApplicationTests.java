package com.example.demo;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Springbootlog4jApplication.class)
public class Springbootlog4jApplicationTests {
 private Logger log=Logger.getLogger(getClass());
	@Test
	public void contextLoads() {
		log.info("infolevel");
		log.debug("debuglevel");
		log.error("errorleve");
	}

}
