package com.pablocasvar.afirstmvc.controllers;

import com.pablocasvar.afirstmvc.model.UserModel;
import com.pablocasvar.afirstmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Pablo on 21/04/2018.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String redirectToAllUsers(){
        return "redirect:/users/all";
    }

    //@RequestMapping(path = "/all" , method = RequestMethod.GET)
    @GetMapping("/all")
    public ModelAndView usersAll(){
        ModelAndView mav = new ModelAndView("users/usersAllView",
                                            "users",
                                            this.userService.findAll());
        return mav;
    }

    //@RequestMapping(path = "/newUserForm" , method = RequestMethod.GET)
    @GetMapping(path = "/new")
    public ModelAndView newUserForm(){
        ModelAndView mav = new ModelAndView("users/newUserFormView",
                                            "user",
                                            new UserModel());
        return mav;

    }

    @PostMapping("/register")
    public String register(@ModelAttribute(name="user") UserModel newUser){
        if(newUser.getId() == null || newUser.getId() == 0){
            this.userService.register(newUser);
        }else{
            this.userService.edit(newUser);
        }
        return "redirect:/users/all";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView(
                "users/newUserFormView",
                "user",
                userService.findById(id)
        );
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        this.userService.delete(id);
        return "redirect:/users/all";
    }

}
