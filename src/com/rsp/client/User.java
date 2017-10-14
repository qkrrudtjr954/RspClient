package com.rsp.client;

public class User {
    int age;
    String name;
    int Rsp;

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

    public int getRsp() {
        return Rsp;
    }

    public void setRsp(int rsp) {
        Rsp = rsp;
    }

    @Override
    public String toString() {
        return name;
    }
}
