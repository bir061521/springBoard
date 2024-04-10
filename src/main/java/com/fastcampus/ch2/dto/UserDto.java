package com.fastcampus.ch2.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserDto {
    private String id;
    private String pwd;
    private String name;

    private String email;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private String birth;
    private String sns;

    public UserDto(){}

    public UserDto(String id, String pwd, String name, String email, Date birth, String sns) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.birth = String.valueOf(birth);
        this.sns = sns;
    }
    public UserDto(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", sns='" + sns + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {

        this.birth = birth;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }
}


