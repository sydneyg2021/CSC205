import java.io.File;
import java.io.IOException;
import java.util.*;

public class Bingo {
    // This program will play Bingo with the integers given in the file bingo.in
    // Written by : Sydney Godwin, 2/5/2022

    // Create a class instance variable for bingo Card
    private int [] [] card;
    private boolean win;
    private String winType;
    private ArrayList<Integer> picks;

    //MAIN
    public static void main(String[] args){

        //Multiple Players
        Bingo [] arr = new Bingo[5];

        for(int i = 0; i < arr.length; i++){
            //Prints Player Tag
            System.out.println("Player " + (i + 1));
            System.out.println();

            //Calls constructor
            arr[i] = new Bingo(5,5);
            //Bingo myCard = new Bingo(5, 5);

            //Fills Bingo Card
            arr[i].initialize();

            //Prints Unmarked Card
            arr[i].printCard();;
            System.out.println();

            //Plays Game
            arr[i].playGame();
            System.out.println();

            //Prints Marked Card
            arr[i].printCard();
            System.out.println();
            System.out.println();

        }



    }

    //A constructor that initializes the rows and columns to values specified by the parameters.
    public Bingo (int myRow, int myColumn){
       card = new int [myRow] [myColumn];
       win = false;
       winType = "";
       picks = new ArrayList<Integer> (5);
    }

    public void initialize(){
        //pre: A 2D Array must be constructed
        //post: A 2D Array will be initialized with the integers present in a file. 

        try{
            int value = 0;

            Scanner in = new Scanner(System.in);
            in = new Scanner(new File("bingo.in"));

            while ((in.hasNext())){
                for(int i = 0; i < card.length; i++) {
                    for(int j = 0; j < card[i].length; j++) {
                        value = in.nextInt();
                        card[i][j] = value;
                    }
                }
            }
            in.close();
        }
        
        catch (IOException e){ //catches if the bingo.in isn't present
            System.out.println(e.getMessage());
        }
    }

    public void printCard(){
        //pre: Bingo Card must be initialized.
        //post: Bingo card is formatted and printed. 

        //Title Print
        String title[] = {"  B  ","  I  "," N  "," G "," O  "}; 
		for(int i = 0; i < title.length; i++){ 
			System.out.print(" " + title[i]); 
		}
		System.out.println(); 
        for(int i = 0; i <title.length + 8; i++){
            System.out.print("--"); 
        }
        System.out.println();

        //Card Print
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if(card [row] [col] == 0){
                    System.out.printf("|" + "%4s", "X");
                }
                else{
                    System.out.printf("|" + "%4d", card [row] [col]);
                }
                }
                System.out.print("|");
                System.out.println();
            }
            for(int a = 0; a <title.length + 8; a++){
                System.out.print("--"); 
            }
        }

    public void playGame(){
        //pre: UnMarked Bingo card must exist.
        //post: Declares type of win and Marked Bingo card.

        //Loops while win is false until win is true
        while(win != true){
            generate();
            checkWin();
        }

        //Prints numbers from the bin
        System.out.println("BINGO NUMBERS PICKED AT RANDOM FROM BIN: ");
        printBin();
        System.out.println("");
        
        //Win Statement print
        System.out.println("You win with a " + winType + " bingo after " + picks.size() + " picks!");

    }

    public void generate(){
        //pre: Unmarked Bingo Card must exist.
        //post: Generates bin number and adds to picks list. Marks Card for future print.

        //Generates int value
        int pick = Math.round((int)(Math.random() * 74 + 1));
        picks.add(pick);
    
        //Checks for pick on card and replaces it with a zero
        for(int i = 0; i < card.length; i++) {
            for(int j = 0; j < card[i].length; j++) {
                if(card [i][j] == pick){
                    card[i] [j] = 0;
                }
            }
        }
    }

    public boolean checkWin(){
        //pre: Values must be generated and marked.
        //post: Checks for BINGO and type
        
        int sum = 0;

        //Check if win is horizontal
        for(int i = 0; i < 5; i++){
            sum = 0;
            for(int j = 0; j< 5; j++){
                sum = sum + card [i] [j];
            }
            if(sum == 0){
                winType = "horizontal";
                win = true;
                return win;
            }
        }
        sum = 0;

        //Check if win is vertical
        for(int i = 0; i < 5; i++){
            sum = 0;
            for(int j = 0; j< 5; j++){
                sum = sum + card [j] [i];
            }
            if(sum == 0){
                winType = "vertical";
                win = true;
                return win;
            }
        }
        sum = 0;

        //Check if win is diagonal (Top left to bottom right)
        for(int a = 0; a < 1; a++){
            for (int i = 0; i < 5; i++){
                sum = sum + card [i] [i];
            }
            if(sum == 0){
                winType = "diagonal";
                win = true;
                return win;
                
            }
        }
        sum = 0;

        //Check if win is diagonal (Top Right to bottom left)
        
        for (int i = 0; i < 5; i++) {
            sum = sum +  card [i][4-i];
        }
        if(sum == 0){
            winType = "diagonal";
            win = true;
            return win;
                
        }
        sum = 0;
        return win;
    }

    public void printBin(){
        //pre: Values must be generated and added to Bin List.
        //post:Removes duplicates and prints Bin list.

        //Removes duplicate values
        ArrayList<Integer> bin = new ArrayList<Integer>();

        for (int element : picks) {
            if (!bin.contains(element)) {
                bin.add(element);
            }
        }

        //sets picks to non duplicates
        picks.clear();
        for(int elements: bin){
            picks.add(elements);
        }


        //Prints Bin values
       Arrays.toString(bin.toArray());
       System.out.print(bin);
    }
}