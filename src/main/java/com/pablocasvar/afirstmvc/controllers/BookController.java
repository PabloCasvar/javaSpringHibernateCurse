package com.pablocasvar.afirstmvc.controllers;

import com.pablocasvar.afirstmvc.model.BookModel;
import com.pablocasvar.afirstmvc.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Pablo on 21/04/2018.
 */
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ModelAndView booksAll(){


        ModelAndView mav = new ModelAndView("books/booksAllView",
                "books",
                bookService.findAll());
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView booksNewForm(){
        ModelAndView mav = new ModelAndView("books/newBookFormView",
                "bookModel",
                new BookModel());
        return mav;
    }

    @PostMapping(path = "/register")
    public String register(
            @ModelAttribute(name = "bookModel") BookModel bookModel){

        if(bookModel.getId() == 0){
            this.bookService.register(bookModel);
        } else {
            this.bookService.edit(bookModel);
        }

        return "redirect:/books/all";
    }

    @GetMapping(path = "/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){

        ModelAndView mav = new ModelAndView(
                "books/newBookFormView",
                "bookModel",
                bookService.findById(id));
        return mav;
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id){

        bookService.delete(id);

        return "redirect:/books/all";
    }
}
