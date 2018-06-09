package com.pablocasvar.afirstmvc.services;

import com.pablocasvar.afirstmvc.model.LoanModel;
import com.pablocasvar.afirstmvc.repositories.ILoanRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Pablo on 02/06/2018.
 */
@Service
public class LoanService{

    @Autowired
    private ILoanRepository loanRepository;

    public LoanModel saveNewLoan(LoanModel newLoan) {

        int stock = newLoan.getBook().getStock();
        newLoan.getBook().setStock(--stock);

        this.loanRepository.save(newLoan);

        return this.loanRepository.save(newLoan);
    }

    public List<LoanModel> listAll(){
        return this.loanRepository.findAll();
    }

    public boolean deleteLoan(Integer id){
        LoanModel loan = this.findById(id);

        if (loan != null){
            int stock = loan.getBook().getStock();
            loan.getBook().setStock(++stock);
        }

        this.loanRepository.deleteById(id);
        return true;
    }

    public LoanModel update(LoanModel loanModel){
        return this.loanRepository.save(loanModel);
    }

    public LoanModel findById(Integer id){
        Optional<LoanModel> found =  this.loanRepository.findById(id);

        /*try{
            return found.get();
        }catch(NoSuchElementException e){
            System.out.println("No se encontró el elemento");
        }*/

        if(found.isPresent()){
            return found.get();
        }

        return null;
    }
}
