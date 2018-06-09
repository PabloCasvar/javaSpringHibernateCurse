package com.pablocasvar.afirstmvc.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pablo on 21/04/2018.
 */
@Entity
@Table(name = "libros")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="titulo")
    private String  title;

    @Column(name="autor")
    private String  author;

    @Column(name="editorial")
    private String  editorial;

    @Column(name="paginas")
    private int     pages;

    @Column(name="edicion")
    private String  edition;

    @Column(name="existencia")
    private Integer stock;

    @OneToMany(mappedBy="book")
    private List<LoanModel> loans;

    public BookModel() {
        super();
        this.id = 0;
    }

    public BookModel(Integer id, String title, String author, String editorial, int pages, String edition, Integer stock) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.pages = pages;
        this.edition = edition;
        this.stock = stock;
    }

    public BookModel(String title, String author, String editorial, int pages, String edition, Integer stock) {
        super();
        this.id = 0;
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.pages = pages;
        this.edition = edition;
        this.stock = stock;
    }

    public Integer getStock(){
        return this.stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }

    public List<LoanModel> getLoans(){
        return loans;
    }

    public void setLoans(List<LoanModel> loans){
        this.loans = loans;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editorial='" + editorial + '\'' +
                ", pages=" + pages +
                ", edition='" + edition + '\'' +
                ", stock='" + stock + '\'' +
                '}';
    }
}

