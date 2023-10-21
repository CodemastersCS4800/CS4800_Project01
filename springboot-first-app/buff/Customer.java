package com.javaguides.springboot.model;

public class Customer {

    private  long   id;
    private  String name;
    private  String email;


    //constructor
    public Customer(){
    }
    //Everthing Constructor
    public Customer(long id, String name,String email){
        this.name = name;
        this.id = id;
        this.email = email;

    }
    //Constructor w/o id
    public Customer(String name, String email){
        this.name = name;
        this.email = email;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
