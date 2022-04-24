package com.example.minstagram;

import android.widget.EditText;

public class getset extends RegisterActivity{
    private  String name,email,phone;

    public getset(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public getset(EditText name, String email, EditText phone) {
        super();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
