package com.gmg.frame.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *@author	作者gmg
 *@date	创建时间：2018年4月26日 下午14:35:23
 *@version	版本： 1.0
 *说明：控制层
 */

@Controller
public class LoginController {
	
    @RequestMapping("/tologin")
    public String login() {
        return "/login";
    }

}

