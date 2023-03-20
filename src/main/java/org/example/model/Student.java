package org.example.model;
public class Student {
    int id;
    String name,email;
    Teacher teacher;
    public void setId(int id){
        this.id= id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public Teacher getTeacher(){
        return teacher;
    }
}
