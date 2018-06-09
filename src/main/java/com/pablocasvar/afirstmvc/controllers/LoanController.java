package com.pablocasvar.afirstmvc.controllers;

import com.pablocasvar.afirstmvc.model.BookModel;
import com.pablocasvar.afirstmvc.model.LoanModel;
import com.pablocasvar.afirstmvc.model.UserModel;
import com.pablocasvar.afirstmvc.services.BookService;
import com.pablocasvar.afirstmvc.services.LoanService;
import com.pablocasvar.afirstmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Pablo on 27/05/2018.
 */
@Controller
@RequestMapping(path = "/loan")
public class LoanController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private LoanService loanService;

    @GetMapping(path = "")
    public String rediretToAll(){
        return "redirect:/loan/all";
    }

    @GetMapping(path = "/all")
    public ModelAndView showAllLoans(){
        ModelAndView mav = new ModelAndView("loans/loansAllView");
        List<LoanModel> prestamos = this.loanService.listAll();
        mav.addObject("loans", prestamos);
        return mav;
    }

    @GetMapping(path = "/newLoanForm")
    public ModelAndView newLoanForm(){
        ModelAndView mav = new ModelAndView(
                "loans/newLoanView",
                "loanModel",
                new LoanModel());

        List<UserModel> users = this.userService.findAll();

        List<BookModel> books = this.bookService.findAllAvailable();

        mav.addObject("usuarios", users);
        mav.addObject("libros", books);

        return mav;
    }

    @PostMapping(path="/register")
    public String register(
            @RequestParam(name="bookId") Integer bookId,
            @RequestParam(name="userId") Integer userId,
            @RequestParam(name="startDate") String strStartDate,
            @RequestParam(name="endDate") String strEndDate){

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(strStartDate);
            Date endDate   = sdf.parse(strEndDate);

            BookModel book = this.bookService.findById(bookId);
            UserModel user = this.userService.findById(userId);

            LoanModel loanModel = new LoanModel(startDate, endDate, book, user);
            loanModel = this.loanService.saveNewLoan(loanModel);
            System.out.println(loanModel);
        }catch(ParseException e){

        }

        return "redirect:/loan/all";
    }

    @GetMapping(path="/delete/{id}")
    public String deleteLoan(
            @PathVariable(name = "id") Integer idToDelete
    ){
        this.loanService.deleteLoan(idToDelete);
        return "redirect:/loan/all";
    }

    @GetMapping(path = "/edit/{id}")
    public ModelAndView editLoan(
            @PathVariable(name = "id") Integer id
    ){
        ModelAndView mav = new ModelAndView(
                "loans/newLoanView",
                "loanModel",
                loanService.findById(id)
        );

        return mav;
    }
}

