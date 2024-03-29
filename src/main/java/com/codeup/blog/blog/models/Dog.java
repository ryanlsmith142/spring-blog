package com.codeup.blog.blog.models;

import javax.persistence.*;

//Removed Entity annotation so that it wouldn't be created inside of database

@Table(name="dogs", uniqueConstraints = @UniqueConstraint(name = "UK_name_AND_reside_state", columnNames={"name", "resideState"}))
public class Dog {

    public Dog(){}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, columnDefinition = "int(11) UNSIGNED")
    private long id;

    @Column(unique=true, nullable=false, columnDefinition="tinyint(3) UNSIGNED")
    private long age;

    @Column(nullable=false, columnDefinition="varchar(200)")
    private String name;

    @Column(columnDefinition="char(2) DEFAULT 'XX'")
    private String resideState;

    public Dog(long id, long age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
