package com.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mganes004c on 5/4/17.
 */
@RestController
public class TestController {

    @RequestMapping(value = "sleuthtest", method = RequestMethod.GET)
    public ResponseEntity<String> testSleuth(@RequestParam String greeting) {
        if(greeting.equalsIgnoreCase("hello")) {
            return new ResponseEntity<> ("Hello World", HttpStatus.OK);

        } else {
            throw new RuntimeException("This is a test error");
        }
    }
}
