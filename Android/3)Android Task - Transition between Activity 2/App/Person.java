package com.example.campusts;

import java.io.Serializable;

public class Person implements Serializable { private String name; private int iin; private double gpa; private String subject;

public Person(String name, int iin,double gpa,String subject){
    this.gpa = gpa;
    this.subject = subject;
    this.name = name;
    this.iin = iin;
}


public String Student() {
    return "Name: " + name + ", " + "Iin: " + iin + ", " + "Gpa: " + gpa;
}

public String Teacher() {
    return "Name: " + name + "," + "Iin: " + iin + ", " + "Subject: " + subject;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getIin() {
    return iin;
}

public double getGpa() {
    return gpa;
}

public void setGpa(double gpa) {
    this.gpa = gpa;
}

public String getSubject() {
    return subject;
}

public void setSubject(String subject) {
    this.subject = subject;
}

public void setIin(int iin) {
    this.iin = iin;
}
