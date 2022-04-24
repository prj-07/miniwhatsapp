package com.example.minstagram;

import android.widget.EditText;

public class ReadWriteUser {

    public String NAME,EMAIL,PHONENO;

    public ReadWriteUser(String name,String email,String phone){
        this.NAME = name;// initializing variables
        this.EMAIL = email;
        this.PHONENO = phone;
    }

    public ReadWriteUser(EditText name, String email, EditText phone) {
    }
}
