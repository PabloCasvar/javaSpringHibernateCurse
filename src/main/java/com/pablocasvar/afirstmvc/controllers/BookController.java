package com.pablocasvar.afirstmvc.controllers;

import com.pablocasvar.afirstmvc.model.BookModel;
import com.pablocasvar.afirstmvc.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo on 21/04/2018.
 */
@Controller
@RequestMapping("/books")
public class BookController {

    //todo: remove and save informaion in the database
    private List<BookModel> books;

    public BookController(){
        this.books = new ArrayList<>();
    }

    @GetMapping("/all")
    public ModelAndView booksAll(){
        ModelAndView mav = new ModelAndView("books/booksAllView");
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView booksNewForm(){
        ModelAndView mav = new ModelAndView("books/newBookFormView");
        return mav;
    }

    @PostMapping(path = "/register")
    public String register(BookModel newBook){
        System.out.println(newBook);
        return "redirect:/books/all";
    }
}
