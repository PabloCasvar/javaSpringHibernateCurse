package com.pablocasvar.afirstmvc.controllers;

import com.pablocasvar.afirstmvc.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo on 21/04/2018.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    //todo: remove and save informaion in the database
    private List<UserModel> users;

    public UserController(){
        this.users = new ArrayList<>();
        this.users.add(new UserModel(1, "Manuel", "Pérez", "Rodríguez", 34, "caslle s/N"));
        this.users.add(new UserModel(2, "Pedro", "Hernández", "Jimenez", 56, "calle principal"));
        this.users.add(new UserModel(3, "Ernesto", "Galo", "Pereira", 45, "Calle Uno"));
    }

    //@RequestMapping(path = "/all" , method = RequestMethod.GET)
    @GetMapping("/all")
    public ModelAndView usersAll(){
        ModelAndView mav = new ModelAndView("users/usersAllView");
        mav.addObject("users", this.users);
        return mav;
    }

    //@RequestMapping(path = "/newUserForm" , method = RequestMethod.GET)
    @GetMapping(path = "/new")
    public ModelAndView newUserForm(){
        ModelAndView mav = new ModelAndView("users/newUserFormView");
        return mav;
    }

    @PostMapping("/register")
    public String register(
            @RequestParam(name = "name")        String name,
            @RequestParam(name = "lastnameP")   String lastnameP,
            @RequestParam(name = "lastnameM")   String lastnameM,
            @RequestParam(name = "age")         int    age,
            @RequestParam(name = "address")     String address
            ){

        //todo: implementar proceso para gurdar usuarios
        UserModel newUser = new UserModel(name, lastnameP, lastnameM, age, address);
        this.users.add(newUser);

        return "redirect:/users/all";
    }

}
