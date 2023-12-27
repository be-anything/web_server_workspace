package com.sh.ajax.student.model.entity;

public class Student {
    private Long id;
    private String name;

    public Student() {
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
