package com.pablocasvar.afirstmvc.model;

/**
 * Created by Pablo on 21/04/2018.
 */

public class UserModel {

    private int     id;
    private String  name;
    private String  lastnameP;
    private String  lastnameM;
    private int     age;
    private String  address;

    public UserModel() {
        super();
    }

    public UserModel(int id, String name, String lastnameP, String lastnameM, int age, String address) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
