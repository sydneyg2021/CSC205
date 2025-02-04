import java.io.Serializable;

public class SalariedEmployee extends Employee implements Serializable {
    // SalariedEmployee class for Personnel
    // Written by : Sydney Godwin, 4/5/2022

    private double pay;
    private double wage;

    //Salaried Employee Constructor
    public SalariedEmployee(String name, double salary) {
        super(name,salary);
        
    }

    //Sets employee hourly salary
    public void setSalary(double salary) {
        wage = salary;
    }

    //Returns employee hourly salary
    public double getSalary() {
        return wage;
    }


    public double computePay(int hours) {
        //Pre: Wage must be set
        //Post: Pay is computed at a flat rate

        pay = getSalary() / 52;
        return pay;

    }

    public String toString(){
        //Pre: Employee must have a name, and pay rate
        //Post: Prints formatted name and wage
        //Uses Dr.Digh Utilities Program
        
        String print;

        print = Utilities.pad(getName(),20) + Utilities.pad(("$" + Utilities.toDollars(getWage()) + "/year"),20);

        return print;
    }
    
}
