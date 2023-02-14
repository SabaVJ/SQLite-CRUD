package com.example.first_project;

public class ModelClass {

    int id;
    String name;
    String password;

    // empty constructor
    public ModelClass() {
    }



    public ModelClass(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public ModelClass(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
