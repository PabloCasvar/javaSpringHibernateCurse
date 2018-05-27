package com.pablocasvar.afirstmvc.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pablo on 21/04/2018.
 */
@Entity
@Table(name="usuarios")
public class UserModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer     id;

    @Column(name="nombre")
    private String  name;

    @Column(name="apellido_paterno")
    private String  lastnameP;

    @Column(name="apellido_materno")
    private String  lastnameM;

    @Column(name="edad")
    private int     age;

    @Column(name="direcccion")
    private String  address;

    @OneToMany(mappedBy = "user")
    private List<LoanModel> loans;

    public UserModel() {
        super();
    }

    public UserModel(Integer id, String name, String lastnameP, String lastnameM, int age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.lastnameP = lastnameP;
        this.lastnameM = lastnameM;
        this.age = age;
        this.address = address;
    }

    public UserModel(String name, String lastnameP, String lastnameM, int age, String address) {
        super();
        this.name = name;
        this.lastnameP = lastnameP;
        this.lastnameM = lastnameM;
        this.age = age;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastnameP() {
        return lastnameP;
    }

    public void setLastnameP(String lastnameP) {
        this.lastnameP = lastnameP;
    }

    public String getLastnameM() {
        return lastnameM;
    }

    public void setLastnameM(String lastnameM) {
        this.lastnameM = lastnameM;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastnameP='" + lastnameP + '\'' +
                ", lastnameM='" + lastnameM + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
