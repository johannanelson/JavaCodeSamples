/*****************************************
 * A template for a computer Nim player
 * 
 * @author Cannon
 ****************************************/ 

public class Computer{
    
    private int mode;
    private int choice;
    
    public Computer(int m){
        mode = m;
        choice = -1; 
    }
    
    //returns value of choice
    public int getChoice(){
        return choice;
    }    
    
    //decides whether computer plays smart or stupid
    public void move(int mLeft){   
        int marblesLeft = mLeft;
        System.out.print("The current pile size is " + marblesLeft + "."); 
        if (mode == 1){
            stupidMode(marblesLeft);
        }
        else //if mode = 2
            smartMode(marblesLeft);
    }
    
    //computer plays in stupid mode 
    //(random number between 1 and n/2)
    public void stupidMode(int mLeft) {
        int marblesLeft = mLeft;
        choice = (int) (Math.random() * (marblesLeft)/2) +1;
        System.out.print("Computer took " + choice + " marbles.\n");
    }
    
    //computer plays smart mode 
    //(computer chooses number that makes the statement 
    //marblesLeft = ((power of 2) - 1) true)
    public void smartMode(int mLeft) { 
        int marblesLeft = mLeft;
        int smartResult = 0;
        int difference = 0;
        int current = 0;
        int i = 0;
        if (marblesLeft != (Math.pow(2, i) - 1)) {
            for (i = 2; i < 6; i++) {
                current = (int)(Math.pow(2, i) - 1);
                if ((current < marblesLeft) && (current <= marblesLeft/2)){
                    smartResult = current;
                }   
            }  
            difference = (marblesLeft - smartResult); 
            choice = marblesLeft - difference;
            System.out.println("Computer took " + choice + " marbles.\n");
        }
        else
            stupidMode(marblesLeft);
    }
        
}       
    
  
