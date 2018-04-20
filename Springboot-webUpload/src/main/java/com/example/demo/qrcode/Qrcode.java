package com.example.demo.qrcode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gmg on 2017/12/3.
 */
@Controller
public class Qrcode{
@RequestMapping(value = "qrcodeIndex")
public String qrcode(){
    return "qrcode";
}
}
