package com.epam.mentoringApp.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentoringApp.model.User;
import com.epam.mentoringApp.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        logger.debug("printHello");
        List<User> list = userService.list();
        model.addAttribute("user", new User());
        model.addAttribute("users", list);

        return "users";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("user") User user){         
        if (user.getId() == 0) {
            // new person, add it
            this.userService.create(user);
        } else {
            // existing person, call update
            this.userService.update(user);
        }
        return "redirect:/users";
    }
    
    
    
//    //TODO
//    @RequestMapping(value="/{id}", method = RequestMethod.GET)
//    public String detailView(Model model) {
//        logger.debug("printHello");
//        model.addAttribute("message", "21Hello Spring MVC Framework!");
//
//        return "hello";
//    }
//    
//    
//    @RequestMapping(method = RequestMethod.GET)
//    public String printHello(Model model) {
//        logger.debug("printHello");
//        model.addAttribute("message", "21Hello Spring MVC Framework!");
//
//        return "hello";
//    }
//    
//    
//    //TODO
//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String listPersons(Model model) {
//        model.addAttribute("person", new User());
//        model.addAttribute("listPersons", this.userService.list());
//        return "person";
//    }
//     
//    //For add and update person both
//    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
//    public String addPerson(@ModelAttribute("person") Person p){
//         
//        if(p.getId() == 0){
//            //new person, add it
//            this.personService.addPerson(p);
//        }else{
//            //existing person, call update
//            this.personService.updatePerson(p);
//        }
//         
//        return "redirect:/persons";
//         
//    }
//     
//    @RequestMapping("/remove/{id}")
//    public String removePerson(@PathVariable("id") int id){
//         
//        this.personService.removePerson(id);
//        return "redirect:/persons";
//    }
//  
//    @RequestMapping("/edit/{id}")
//    public String editPerson(@PathVariable("id") int id, Model model){
//        model.addAttribute("person", this.personService.getPersonById(id));
//        model.addAttribute("listPersons", this.personService.listPersons());
//        return "person";
//    }

}