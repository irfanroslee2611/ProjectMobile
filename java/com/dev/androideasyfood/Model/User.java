package com.dev.androideasyfood.Model;

import com.google.firebase.database.PropertyName;

/**
 * Created by user on 10/17/2017.
 */

public class User {
    @PropertyName("Name")
    private String Name;
    @PropertyName("Password")
    private String Password;
    @PropertyName("Phone")
    private String Phone;
    @PropertyName("Email")
    private String Email;

    public User(){
    }

    public User(String name, String password,String email) {
        Name = name;
        Password = password;
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @PropertyName("Name")
    public String getName(){
        return Name;
    }

    @PropertyName("Name")
    public void setName(String name){Name = name;}

    @PropertyName("Password")
    public String getPassword(){
        return Password;
    }

    @PropertyName("Email")
    public String getEmail() {
        return Email;
    }

    @PropertyName("Email")
    public void setEmail(String email) {
        Email = email;
    }
}
