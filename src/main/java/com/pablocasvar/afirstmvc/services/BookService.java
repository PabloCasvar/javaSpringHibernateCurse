package com.pablocasvar.afirstmvc.services;

import com.pablocasvar.afirstmvc.model.BookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Pablo on 28/04/2018.
 */
@Service
public class BookService {

    private ArrayList<BookModel> books = new ArrayList<>();
    private int count;

    public BookService(){

        this.books.add(new BookModel(3, "El fin de la lectura", "Neuman", "Final", 100, "Segunda"));
        this.books.add(new BookModel(1, "El principito", "Francès", "Editorial A", 125, "Primera"));
        this.books.add(new BookModel(2, "Fìsica Universitaria", "Halliday, Resnick, Krane", "Editorial B", 1100, "Cuarta"));

        this.count = this.books.size();
    }


    public BookModel findById(int id){
        BookModel found = null;
        for (BookModel book : this.books){
            if(book.getId() == id) {
                found = book;
                break;
            }
        }
        return found;
    }

    public ArrayList<BookModel> findAll(){
        return this.books;
    }

    public boolean delete(int idToDelete){
        BookModel found = this.findById(idToDelete);
        if(found != null){
            return this.books.remove(found);
        }else {
            return false;
        }
    }

    public BookModel register(BookModel newBook){
        newBook.setId(++count);
        this.books.add(newBook);
        return newBook;
    }

    public BookModel edit(BookModel bookModel){
        BookModel book = this.findById(bookModel.getId());

        if(book != null){
            book.setTitle(bookModel.getTitle());
            book.setAuthor(bookModel.getAuthor());
            book.setEdition(bookModel.getEdition());
            book.setEditorial(bookModel.getEditorial());
            book.setPages(bookModel.getPages());
        }
        return book;
    }
}
