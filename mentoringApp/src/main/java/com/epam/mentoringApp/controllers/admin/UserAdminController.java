package com.epam.mentoringApp.controllers.admin;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentoringApp.model.User;
import com.epam.mentoringApp.services.UserService;

@Controller
public class UserAdminController {
    private static final Logger logger = Logger.getLogger(UserAdminController.class);

    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/admin/users", method = RequestMethod.GET)
    public String list(Model model) {
        logger.debug("printHello");
        List<User> list = userService.list();
        model.addAttribute("user", new User());
        model.addAttribute("users", list);

        return "users";
    }
    
    @RequestMapping(value="/admin/users", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){         
        if (user.getId() == null) {
            // new person, add it
            this.userService.create(user);
        } else {
            // existing person, call update
            this.userService.update(user);
        }
        return "redirect:/admin/users";
    }
    
    @RequestMapping(value="/admin/users/{id}", method = RequestMethod.GET)
    public String detailView(Model model, @PathVariable Long id) {
        User user = userService.read(id);
        model.addAttribute("user", user);        
        return "userDetails";
    }
}