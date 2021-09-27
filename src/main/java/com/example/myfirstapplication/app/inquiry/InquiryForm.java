package com.example.myfirstapplication.app.inquiry;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//@Data
public class InquiryForm {

    @Size(min = 1,max = 20, message = "Please input 20 chars or less")
    private String name;

    @NotNull
    @Email(message = "Invalid Email")
    private String email;

    @NotNull
    private String contents;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public InquiryForm() {
    }

    public InquiryForm(String name, String email, String contents) {
        this.name = name;
        this.email = email;
        this.contents = contents;
    }
}
