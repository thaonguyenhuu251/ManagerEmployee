package com.example.manageremployee;

public abstract class Employee {
    private String id;
    private String name;
    public abstract double salary();
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.id+" - "+this.name;
    }
}
