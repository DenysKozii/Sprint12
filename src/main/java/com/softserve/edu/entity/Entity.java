package com.softserve.edu.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Entity {

    private int id;

    private String name;
    private static int counter = 1;

    public Entity(String name) {
        id = counter++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
