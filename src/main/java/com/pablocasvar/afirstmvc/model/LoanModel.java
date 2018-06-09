package com.pablocasvar.afirstmvc.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Pablo on 27/05/2018.
 */
@Entity
@Table(name="prestamos")
public class LoanModel {

    //PROPIEDADES
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="identificador")
    private Integer id;

    @Column(name="fecha_asignacion")
    private Date startDate;

    @Column(name="fecha_regreso")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="libros_id", referencedColumnName = "id")
    private BookModel book;

    @ManyToOne
    @JoinColumn(name="usuarios_id", referencedColumnName = "id")
    private UserModel user;

    public LoanModel(){
        super();
    }

    public LoanModel(Integer id, Date startDate, Date endDate, BookModel book, UserModel user) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.book = book;
        this.user = user;
    }

    public LoanModel(Date startDate, Date endDate, BookModel book, UserModel user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.book = book;
        this.user = user;
    }

    public String formattedStartDate(){
        Locale locale = new Locale("es", "MX");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy", locale);

        return sdf.format(startDate);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoanModel{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", book=" + book +
                ", user=" + user +
                '}';
    }
}
