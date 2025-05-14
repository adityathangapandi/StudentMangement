package com.project.student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String rollno;
    private String name;
    private String email;
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
   public void setRollno(String rollno){
        this.rollno=rollno;
   }
   public String getRollno(){
       return rollno;
   }
   public void setEmail(String email){
        this.email=email;
   }
   public String getEmail(){
        return email;
   }
}
