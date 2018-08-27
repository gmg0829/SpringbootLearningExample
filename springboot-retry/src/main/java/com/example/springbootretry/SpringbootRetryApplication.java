package com.example.springbootretry;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
@EnableRetry
public class SpringbootRetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRetryApplication.class, args);
	}
}
