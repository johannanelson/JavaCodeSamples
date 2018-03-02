/*****************************************
 * A template for a Nim game
 * 
 * @author Cannon
 
 ****************************************/ 

import java.util.Scanner;

public class Game{
    
    private int marbles;
    private int marblesLeft;
    private Human humanPlayer;
    private Computer computerPlayer;
    
    
    //Game object
    public Game(int difficulty){
        
        marbles = (int) (Math.random() * 90) + 10;
        marblesLeft = marbles;
        humanPlayer = new Human();
        computerPlayer = new Computer(difficulty);       
    }
    
    //Returns current number of marbles left
    public int getMarblesLeft(){
        return marblesLeft;
    }

    //Randomly decides whether the computer or human plays first
    public void play() {
        int first = (int) (Math.random() * 2 + 1);
        if (first == 1){
            playComputerFirst();
        }
        else
            playHumanFirst();
         
    }
    
    //method to use if computer is chosen as the first player
    public void playComputerFirst(){
        int lastPlayer = 0;
        System.out.println("Current pile size is " + marblesLeft + ".\n");
        System.out.println("Computer has been chosen to play first.\n");
        while (marblesLeft > 1) {
            computerPlayer.move(marblesLeft);
            marblesLeft = marblesLeft - computerPlayer.getChoice();
            lastPlayer = 1; 
            if (marblesLeft > 1){
                humanPlayer.move(marblesLeft);
                marblesLeft = marblesLeft - humanPlayer.getChoice();
                lastPlayer = 2;
            }   
        }
        if (lastPlayer == 1){
            System.out.println("Computer wins!");
        }
            else
                System.out.println("Human wins!");                             
    }
    
    //method to use if human is chosen as the first player
    public void playHumanFirst(){
        int lastPlayer = 0;
        System.out.println("You have been chosen to play first.\n");
        while (marblesLeft > 1) {
            humanPlayer.move(marblesLeft);
            marblesLeft = marblesLeft - humanPlayer.getChoice();
            lastPlayer = 1;
            if (marblesLeft > 1){
                computerPlayer.move(marblesLeft);
                marblesLeft = marblesLeft - computerPlayer.getChoice();
                lastPlayer = 2;
            }   
        }
        if (lastPlayer == 1){
            System.out.println("Human wins!");
        }
            else
                System.out.println("Computer wins!");                           
    }
    
    
}