import java.io.Serializable;

public class HourlyEmployee extends Employee implements Serializable {
    // HourlyEmployee class for Personnel
    // Written by : Sydney Godwin, 4/5/2022

    private double pay;

    //Hourly Employee Constructor
    public HourlyEmployee(String name, double wage) {
        super(name, wage);
    }

    public double computePay(int hours) {
        //Pre: Wage must be set, hours must be inputted.
        //Post: Pay is computed by hours under or over 40 and returned.

        if(hours <= 40){
            pay = getWage() * hours;
        }else{
            pay = getWage() * 40;
            hours = hours - 40;
            pay = pay + (getWage()* 1.5 * hours);
        }
        return pay;
    }

    public String toString(){
        //Pre: Employee must have a name, and pay rate
        //Post: Prints formatted name and wage
        //Uses Dr.Digh Utilities Program
        
        String print;

        print = Utilities.pad(getName(),20) + Utilities.pad(("$" + Utilities.toDollars(getWage()) + "/hour"),20);

        return print;
    }

}
