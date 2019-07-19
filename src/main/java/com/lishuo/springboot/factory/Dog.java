package com.lishuo.springboot.factory;

public class Dog implements  Animal {
    @Override
    public String say() {
        return "我是可爱的小狗,汪~";
    }

    public Dog() {
    }
}
