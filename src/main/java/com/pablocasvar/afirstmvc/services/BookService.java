package com.pablocasvar.afirstmvc.services;

import com.pablocasvar.afirstmvc.model.BookModel;
import com.pablocasvar.afirstmvc.repositories.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Pablo on 28/04/2018.
 */
@Service
public class BookService {

    @Autowired
    private IBookRepository repository;

    public BookModel findById(Integer id){

        Optional<BookModel> found = this.repository.findById(id);
        try{
            return found.get();
        }catch(NoSuchElementException e){
            System.out.println("No se encontró el elemento");
        }

        return null;
    }

    public List<BookModel> findAll(){
        return this.repository.findAll();
    }

    public boolean delete(Integer idToDelete){
        this.repository.deleteById(idToDelete);
        return true;
    }

    public BookModel register(BookModel newBook){
        return this.repository.save(newBook);
    }

    public BookModel edit(BookModel bookModel){
        return this.repository.save(bookModel);
    }
}
