package io.github.olgazskiba.lectureSpring.mySpring.bean;

import io.github.olgazskiba.lectureSpring.mySpring.MyContext;

public class SuperVilan implements Humanable{

    String name = "superVilan!";

    @Override
    public void speak() {
        MyContext.getHuman("SuperVilan");
    }
}
