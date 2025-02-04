import java.io.Serializable;

public abstract class Employee implements Serializable {
    // Employee class for Personnel
    // Written by : Sydney Godwin, 4/5/2022

    //Stores Employee Name and Wage
    private String name;
    private double wage;
 
    //Employee Constructor
    public Employee(String name, double wage) {
         this.name = name;
         this.wage = wage;
    }

    //Sets employee name
    public void setName(String name) {
        this.name = name;
    }

    //Sets employee pay
    public void setPay(double wage) {
        this.wage = wage;
    }

    //Returns employee name
    public String getName() {
        return name;
    }

    //Returns employee pay
    public double getWage() {
       return wage;
    }

    //Methods
    public void increasePay (double percent){
        //Pre: payPerHour must be set, and percent must be above 0.
        //Post: payPerHour will be increased by inputted percent
        if( percent > 0){
            percent = percent /100;
            wage = getWage() + (getWage() * percent);
        }else{
            System.out.println("Please input a percent larger than 0");
        }
    }

    public abstract double computePay(int hours);

}
