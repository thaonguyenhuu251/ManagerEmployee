package com.example.manageremployee;

public class EmployeeFullTime extends Employee{
    @Override
    public double salary() {
        return 500;
    }

    @Override
    public String toString() {
        return "FullTime: "+ super.toString() +" - luong "+ salary(); }
}
