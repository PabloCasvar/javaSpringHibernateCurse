package com.pablocasvar.afirstmvc.controllers;

import com.pablocasvar.afirstmvc.model.BookModel;
import com.pablocasvar.afirstmvc.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Pablo on 21/04/2018.
 */
@Controller
@RequestMapping("/books")
public class BookController {

    //todo: remove and save informaion in the database
    private List<BookModel> books;
    private int count;

    public BookController(){
        this.books = new ArrayList<>();
        this.books.add(new BookModel(1, "La Metamorfosis", "FranK Kafka", "Editorial A", 110, "Primera"));
        this.books.add(new BookModel(2, "El Principito", "Antoine de Saint-Exupéry", "Editorial B", 110, "Tercera"));
        this.books.add(new BookModel(3, "Física Universitaria", "Halliday, Resnik, Krane", "Editorial C", 1100, "Cuarta"));
        this.count = this.books.size();
    }

    @GetMapping("/all")
    public ModelAndView booksAll(){
        ModelAndView mav = new ModelAndView("books/booksAllView",
                "books",
                this.books);
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
            bookModel.setId(++count);
            this.books.add(bookModel);
        } else {
            for (BookModel book : this.books){
                if(book.getId() == bookModel.getId()){
                    book.setTitle(bookModel.getTitle());
                    book.setAuthor(bookModel.getAuthor());
                    book.setEdition(bookModel.getEdition());
                    book.setEditorial(bookModel.getEditorial());
                    book.setPages(bookModel.getPages());
                    break;
                }
            }
        }

        return "redirect:/books/all";
    }

    @GetMapping(path = "/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        BookModel bookFound = null;

        for(BookModel book : this.books){
            if(book.getId() == id){
                bookFound = book;
                break;
            }
        }

        ModelAndView mav = new ModelAndView(
                "books/newBookFormView",
                "bookModel",
                bookFound);
        return mav;
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id){

        BookModel book;
        for(Iterator<BookModel> iter = this.books.listIterator(); iter.hasNext();){
            book = iter.next();
            if(book.getId() == id){
                iter.remove();
                break;
            }
        }

        return "redirect:/books/all";
    }
}
