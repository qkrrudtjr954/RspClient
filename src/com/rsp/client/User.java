package com.rsp.client;

public class User {
    int age;
    int rsp;

    public int getRsp() {
        return rsp;
    }

    public void setRsp(int rsp) {
        this.rsp = rsp;
    }

    String name;

    public User() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}
