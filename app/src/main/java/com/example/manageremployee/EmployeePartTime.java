package com.example.manageremployee;

public class EmployeePartTime extends Employee {
    @Override
    public double salary() { return 150;
    }
    @Override
    public String toString() {
        return "PartTime: "+ super.toString() +" - luong "+ salary();
    }
}
