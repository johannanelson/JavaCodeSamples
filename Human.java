/*****************************************
 * A template for a Human Nim player
 * 
 * @author Cannon
 
 ****************************************/ 
import java.util.Scanner;

public class Human {
    
    private int choice;
    private Scanner input;
    
    public Human(){
        input = new Scanner(System.in);
        choice = -1;
    }
    
    //method for a human move
    public void move(int mLeft){
        int marblesLeft = mLeft;
        int choiceLimit = (int)((marblesLeft/2));
        System.out.print("The current pile size is " + marblesLeft + ". Enter the # of marbles you want to take. "); 
        System.out.print("You must take at least one, and at most half of the marbles.\n");       
        choice = input.nextInt();
        while (choice > choiceLimit){
            
            System.out.print("This number is too large, please choose a number less than or equal to " + choiceLimit + ".\n");     
            choice = input.nextInt();
        }
        System.out.print("You chose " + choice + ".\n");
    }
        
    //returns current human choice
    public int getChoice() {
        return choice;
    }
}
 
    

    
    