import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class Personnel {
    // Personnel: Maintains wage information for the employees of a company.
    // Written by: Sydney Godwin, 4/5/2022

    //ArrayList of Employees
    public static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String [] args)
	{
		menu();
	}

    //Prints options
    public static void menuPrint(){
        System.out.println("----------------------------------------");
        System.out.println("|Commands: n - New employee            |");
        System.out.println("|          c - Compute paychecks       |");
        System.out.println("|          r - Raise wages             |");
        System.out.println("|          p - Print records           |");
        System.out.println("|          d - Download data           |");
        System.out.println("|          u - Upload data             |");
        System.out.println("|          q - Quit                    |");
        System.out.println("----------------------------------------");
    }
    
    //Menu of options + loop
    public static void menu(){
        //Scanner Setup
        Scanner in = new Scanner(System.in);
        String choice = "a";

        menuPrint();
        System.out.print("Enter command: ");
        choice = (in.next()).toLowerCase();

        //While loop for quitting
        while( choice.toLowerCase() != "q" ){
            switch (choice) {
                case "n":
                  System.out.println();
                  n();
                  break;
                case "c":
                  System.out.println();
                  c();
                  break;
                case "r":
                  System.out.println();
                  r();
                  break;
                case "p":
                  System.out.println();
                  p();
                  break;
                case "d":
                  System.out.println();
                  d();
                  break;
                case "u":
                  System.out.println();
                  u();
                  break;
                case "q":
                    System.exit(0);
                
                default:
                    System.out.println("Command was not recognized; please try again.");
            }
            menuPrint();
            System.out.print("Enter command: ");
            choice = (in.next()).toLowerCase();

        }
    }

    //Methods
    //Add new employee
    public static void n(){
        //Pre: Employee array must be initialized
        //Post: Hourly or Salaried employee is added.
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of new employee (Last, First): ");
        String name = input.nextLine();

        System.out.print("Hourly (h) or salaried (s): ");

        //Checks for H/h && S/s
        switch(input.nextLine().toLowerCase()){
          case "h":
            System.out.print("Enter hourly wage: ");
            double wage = input.nextDouble();
            HourlyEmployee a = new HourlyEmployee(name, wage);
            employees.add(a);
            break;

          case "s":
            System.out.print("Enter annual salary: ");
            int salary = input.nextInt();
            SalariedEmployee b = new SalariedEmployee(name,salary);
            b.setSalary(salary);
            employees.add(b);
            break;

          default:
            System.out.println("Input was not (h) or (s); please try again.");
            System.out.println();
        }
      }
    
    //Compute Paychecks
    public static void c(){
      //Pre: Wages must be set
      //Post: Outputs total wage by hours worked
      Scanner in = new Scanner(System.in);
      int j = 0;
      for(Employee i: employees){
        System.out.print("Enter number of hours worked by " + employees.get(j).getName() + ": ");
        int hours = in.nextInt();
        System.out.println("Pay: " + "$" + Utilities.toDollars((employees.get(j).computePay(hours))));
        j++;
      }
    }

    //Raise wages
    public static void r(){
      //Pre: Wages must be set
      //Post: Increases wages by a percentage
      Scanner in = new Scanner(System.in);
      System.out.print("Enter percentage increase: ");
      double percent = in.nextDouble();
      System.out.println("New wages");
      System.out.println("---------");
      int j = 0;
      for(Employee i: employees){
        employees.get(j).increasePay(percent);
        System.out.println(employees.get(j).toString());
        j++;
      }
    }

    //Print records
    public static void p(){
      //Pre: Employees must be added to arrayList
      //Post: Outputs Employee list
      int j = 0;
      for(Employee i: employees){
        System.out.println(employees.get(j).toString());
        j++;
      }
    }

    //Download data
    public static void d(){
      //Pre: Arraylist must exist
      //Post: Outputs arraylist into file "Employees.dat"
      //Uses code from Canvas: Reading and Writing Objects.docx
      String fileName = "Employees.dat";
        try {
          FileOutputStream fileOut =
            new FileOutputStream(fileName);
          ObjectOutputStream out =
            new ObjectOutputStream(fileOut);
          out.writeObject(employees);
          out.close();
        }
        catch (IOException e) {
          System.out.println(e.getMessage());
        }
    }

    //Upload data
    public static void u(){
      //Pre: "Employees.dat" must exist
      //Post: Inputs "Employees.dat" into arraylist
      //Uses code from Canvas: Reading and Writing Objects.docx

      String fileName = "Employees.dat";
        try {
          FileInputStream fileIn =
            new FileInputStream(fileName);
          ObjectInputStream in =
            new ObjectInputStream(fileIn);
          employees = (ArrayList<Employee>) in.readObject();
          in.close();
        }
        catch (IOException e) {
          System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
          System.out.println(e.getMessage());
        }
        for (int i = 0;  i < employees.size();  i++)
                System.out.println(employees.get(i));
    }
}
