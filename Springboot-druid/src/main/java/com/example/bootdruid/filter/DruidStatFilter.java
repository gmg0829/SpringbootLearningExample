package com.example.bootdruid.filter;


import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 配置监控拦截器
 * druid监控拦截器
 * @ClassName: DruidStatFilter
 * @author gmg
 * @date 2017年7月24日 上午10:53:40
 */
@WebFilter(filterName="druidWebStatFilter",
        urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),// 忽略资源
        })
public class DruidStatFilter extends WebStatFilter {

}
