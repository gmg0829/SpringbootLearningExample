package com.gmg;

import com.gmg.filter.CheckSignFilter;
import com.gmg.listener.LoadConfigListener;
import com.gmg.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextListener;

@SpringBootApplication
//@ServletComponentScan
public class ServletFilterListenerInterceptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletFilterListenerInterceptorApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean checkSignFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new CheckSignFilter());
		filterRegistrationBean.addUrlPatterns("/");
		filterRegistrationBean.setOrder(2);
		filterRegistrationBean.addInitParameter("nocheck", "");
		return filterRegistrationBean;
	}

	@Bean
	public  ServletListenerRegistrationBean<ServletContextListener> servletListenerRegistrationBean(){
		ServletListenerRegistrationBean<ServletContextListener> register=new ServletListenerRegistrationBean<ServletContextListener>();
		register.setListener(new LoadConfigListener());
		return  register;
	}
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new MyServlet(),"a/");
	}
}
