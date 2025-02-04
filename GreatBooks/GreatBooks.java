import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GreatBooks{
    // This program will catalog, display and search book records in a file.
    // Written by : Sydney Godwin, 2/27/2022

    //Instance Variables
    public ArrayList<LibraryBook> collection;
    public static boolean filled = false;

    // Great Books Constructor
    public GreatBooks(){
		collection = new ArrayList<LibraryBook>();
	}

    //Main Method
    public static void main(String[] args) {
      //Opening text
        System.out.println("\t \t THE BOOK SEARCH PROGRAM \t \t");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("What file is your book data stored in?");

      //Creates library
        GreatBooks set1 = new GreatBooks();
        
      //Fills library
        while(filled == false){
            set1.startUp();
        }
       
       //Sorts Library
        set1.sort();
        System.out.println("A total of " + set1.collection.size() + " books have been inputted and sorted by title");
        
        System.out.print("Please Hit Return to Continue...");
        set1.enter();

      //User menu
        set1.menu();

    }

     public void startUp(){
     //Pre: .Dat files must be in directory
     //Post: Chooses .dat file for input into ArrayList
        System.out.println("Here are the files in the current directory :");
        //Get all files from directory - Pulled from Dr. Digh Code
        
        File curDir = new File(".");
        String[] fileNames = curDir.list();
        ArrayList<String> data = new ArrayList<String>();

        //Find files which may have data. (aka, are in the .dat format)
        for(String s:fileNames){
            if(s.endsWith(".dat")){
                data.add(s);
            }
        }

        if(data.size() == 0){
            System.out.println("\t \t ** There are no files available, input files then restart** \t \t");
            System.exit(0);
        }
        else{
            //Print out files
            System.out.printf("%s", data);
            System.out.println();

            //User picks file to input
            Scanner in = new Scanner(System.in);
            System.out.print("Filename: ");
            String choice = in.next();

            //Checks if user choice is correct
            if(data.contains(choice.toLowerCase())){ //Allows for uppercase version of file name
                input(choice.toLowerCase());
                filled = true;
            }else{
                System.out.println("\t \t ** Can't open input file. Try again ** \t \t");
                System.out.println();
            }
        }
    }

    public void input(String c){
    //Pre: Name of .dat file needed as parameter
    //Post: Book records from .dat file are inputted into arrayList
        try {
            //Scans through file inputted
            File inputFile = new File(c);
            Scanner a = new Scanner (inputFile);
            a.useDelimiter(";");
        
            //While scanning per line, enters data fields for each book
            while ((a.hasNextLine())){
                String title = a.next();
                String author = a.next();
                int copy = a.nextInt();
                Double price = a.nextDouble();
                String genre = a.next();

                LibraryBook book = new LibraryBook(title, author, copy, price, genre);

                //adds book to collection
                collection.add(book);
            
                a.nextLine();

            }
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong with fill");
        }

    }

    public ArrayList<LibraryBook> sort(){
    //Pre: Book records must be inputted into ArrayList
    //Post: Arraylist is sorted using a selection sort algorithm by title alphabetically and returned
        String small;
        int j = 0;
        int smallIndex = 0;      
    
        for(int i = 0;i<collection.size() - 1; i++){
            small = collection.get(i).getTitle();
            smallIndex = i;
            for(j = i+1 ; j<collection.size() ;j++){
                String a = collection.get(j).getTitle();
                if(a.compareTo(small) < 0){
                    small = collection.get(j).getTitle();
                    smallIndex = j;                    
                }
            }
    
            if (i != smallIndex) {
                LibraryBook temp = collection.get(smallIndex);
                collection.set(smallIndex, collection.get(i));
                collection.set(i, temp);
            }
        }
        return collection;
    }

    public void menu(){
    //Pre: Book records must sorted in ArrayList
    //Post: User is able to either, display records, search for a record, or exit
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("\t \t THE GREAT BOOKS SEARCH PROGRAM \t \t");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("1) Display all book records \n2) Search for a book by Title \n3) Exit Search Program \n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.print("Please enter your choice > ");
        try {
            while( choice != 3){
                choice = scan.nextInt();
                switch(choice){
                    case 1:
                        displayBooks();
                        break;
                    case 2:
                        int s = search();
                        if(s == -1){
                            System.out.println("Sorry the book was NOT found.");
                            System.out.print("Please Hit Return to Continue...");
                            enter();
                            break;

                        }if( s > -1){
                            System.out.println();
                            print(s);
                            System.out.print("Please Hit Return to Continue...");
                            enter();
                            break;
                        }
                        break;

                    case 3:
                        System.out.println("Have a nice day! \nGoodbye. :-)");
                        System.exit(0);
                    default:
                        System.out.println("Please Enter a Number Between 1 and 3");
                        Thread.sleep(1500); //Causes the execution to pause so user can read message
                        break;
                }
                clearScreen();
                menu();
            }
        } catch (Exception e) {
            String red = "\u001B[31m";
            String white = "\u001B[37m";
            System.out.println("You have made an " + red + "error " + white + ". Please try again.");
            System.out.print("Please Hit Return to Continue...");
            enter();
            menu();
        }  
    }

    public int search(){
    //Pre: Book records must be sorted alphabetically in ArrayList
    //Post: Use rinputted book search is found using a binary search and printed
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.print("Search Title > ");
        String t = in.nextLine();
        t = t.toLowerCase();


        int left = 0, right = collection.size() - 1; 
        
        while (left <= right)
        { 
            int mid = left + (right - left) / 2; 
    
            if (collection.get(mid).getTitle().toLowerCase().compareTo(t) == 0){
                return mid; 
            }

            if (collection.get(mid).getTitle().toLowerCase().compareTo(t) < 0){ 
                left = mid + 1; 
    
            }else{
                right = mid - 1;
            } 
        } 
    
        // element not found return -1
        return -1; 
    } 

    public void enter(){
    //Pre: User must be prompted to press return or M button
    //Post: Screen is cleared
        Scanner readinput = new Scanner(System.in);
        String input = readinput.nextLine();
        if(input.equals("")){
            clearScreen();
        }
        if(input.equals("M") || input.equals("m")){
            clearScreen();
            menu();
        }
    }

    //Dr. Digh clearScreen code
    private static void clearScreen(){
        System.out.println("\u001b[H\u001b[2J");
    }

    public void displayBooks(){
    //Pre: Book records must be sorted alphabetically into ArrayList
    //Post: The arraylist is iterated through and prints each record individually
        for (int i = 0; i < collection.size();i++){
            print(i);
            
            System.out.print("Please Hit Return to Continue or M for Menu...");
            enter();
        }
    }

    public void print(int i){
    //Pre: Book records must be sorted alphabetically into ArrayList and an index parameter must be entered
    //Post: Arraylist record is printed based on index parameter given 
        String title = collection.get(i).getTitle();
        String author = collection.get(i).getAuthor();
        int copy = collection.get(i).getCopyright();
        Double price = collection.get(i).getPrice();
        String p = String.format("%.2f", price);
        String genre = collection.get(i).getGenre();
        
        //Creates full genre title
        switch(genre){
            case "p":
                genre = "Poetry";
                break;
            case "d":
                genre = "Drama";
                break;
            case "f":
                genre = "Fiction";
                break;
            case "a":
                genre = "Adventure";
                break;
            case "m":
                genre = "Mystery";
                break;
            default:
              break;
        }
        
       System.out.print("Record " + (i+1));
       System.out.printf("\n-------------------------- \n%1$" + title.length() + "s", "Title: \t \t"+ title);
       System.out.printf("\n%1$" + author.length() + "s", "Author's Name:  "+ author);
       System.out.println("\nCopyright: \t" + copy);
       System.out.println("Price: \t \t" + p);
       System.out.printf("%1$" + genre.length() + "s", "Genre: \t \t"+ genre + "\n");
       System.out.println("----------------------------");
       System.out.println();
        
    }

}
