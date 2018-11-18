package com.iblasterus.restsample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello World controller
 */
@Controller
public class HelloController {
    /**
     * Simple request "Hello World!"
     *
     * @return string "Hello World!"
     */
    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello World!";
    }
}
