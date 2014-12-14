package com.epam.mentoringApp.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        logger.debug("printHello");
        model.addAttribute("message", "21Hello Spring MVC Framework!");

        return "hello";
    }

}