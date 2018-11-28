package com.iblasterus.restsample.controllers;

import com.iblasterus.restsample.entities.Greeting;
import com.iblasterus.restsample.entities.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello World controller
 */
@Controller
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    /**
     * Simple request "Hello World!"
     *
     * @return string "Hello World!" (can see into browser)
     */
    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello World!";
    }

    /**
     * Greeting method
     * Can test by Postman
     *
     * @param request contain username
     * @return text of greeting
     */
    @RequestMapping(
            value = "/test_hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    @ResponseBody
    Greeting greeting(@RequestBody final User request) {
        Greeting response = new Greeting();
        response.setGreeting("Hello, " + request.getUsername());
        logger.info("RESPONSE:\n" + response.toString());
        return response;
    }
}
