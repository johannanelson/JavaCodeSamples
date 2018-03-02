//*******************************************************
// jn2631
// Author: Johanna Nelson
// 
// Game.java
// 
// Creates and executes rounds of a video poker game.
//*******************************************************

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Game {
	
	private Player p;
	private Deck cards;
    private ArrayList<Card> currentHand;
    private Scanner input;
    private String[] hand;
    private String [] cardStringArray;
    private int onePairMatches;
    private int kindMatches;
    private int tokens;
    private int numGames;
    private boolean playing;
    private String current;

    
    
	public Game(String[] testHand){
        p = new Player();
        cards = new Deck();
        currentHand = new ArrayList<Card>();        
        hand = Arrays.copyOf(testHand, testHand.length);
        String current = "";
        onePairMatches = -1;     
        kindMatches = -1;
        input = new Scanner(System.in);
        tokens = 0;
        playing = true;        
        cardStringArray = new String[5];
        convertTestHand(); 
        numGames = 0;
    }
          
	public Game(){
        p = new Player();
        cards = new Deck();
        currentHand = new ArrayList<Card>();
        String[] hand = new String[5];
        onePairMatches = 0;
        kindMatches = 0; 
        input = new Scanner(System.in);  
        tokens = 0;
        playing = true;
        cardStringArray = new String[5];
        numGames = 0;	
	}

    //For one-argument constructor test hand
    public void convertTestHand(){
        for (int i = 0; i < 5; i++){
            String current = hand[i];
            int s = 0;
            int r = Integer.parseInt(current.substring(1,current.length()));
            if (current.substring(0,1).equals("c")){
                s = 1;
            }
            if (current.substring(0,1).equals("d")){
                s = 2;
            }
            if (current.substring(0,1).equals("h")){
                s = 3;
            }
            if (current.substring(0,1).equals("s")){
                s = 4;
            }
            Card c = new Card(s, r);
            p.addCard(c);
            currentHand = p.getHand();           
        }                  
    }
    
//********************Beginning of main play method*********************//	 

    public void play(){
      while (playing = true) {  
        String handResult = ""; 
        System.out.println("Your bankroll is currently: $ " + p.getBankroll() + "0.\n");        
        System.out.println("Welcome to Video Poker!\n"); 
        System.out.println("How many tokens would you like to bet? (1-5).\n");		
        p.bets(input.nextInt());
        cards.shuffle();
        
        //Create hand of five cards if first game
        if ((numGames == 0) && (currentHand.isEmpty())){
            firstHand();
        }
        
        //Create hand of five cards if >first game
        if (numGames > 0){ 
            newHand(); 
        } 
          
        // Converts hand to array of card strings
        cardStringArray = cardToStringArray(currentHand);
        
        //Prints hand to player
        System.out.println("Here is your current hand: ");
        for (String element : cardStringArray){
            System.out.print(element + "\n");
        }
          
        //Asks player to modify the hand
        for (int i = 0; i < cardStringArray.length; i++){
            int choice = -1;
            System.out.print("\nDo you want to replace " + cardStringArray[i] + "?");
            System.out.println(" 1 = yes, 2 = no ");
            choice = input.nextInt();
            p.cardDecision(choice, i, currentHand, cards);
            p.getHand();
        }
        //Sorts the hand and reprints to player
        sort(currentHand);
        cardStringArray = cardToStringArray(currentHand);
        System.out.println("This is now your hand: ");
        for (String element : cardStringArray){
            System.out.print(element + "\n");
        }
        
        //Checks the hand and prints result to player  
        handResult = checkHand();
        System.out.println("\nYour hand: " + handResult);
        System.out.println("Your bankroll is now $" + p.getBankroll() + "0.");
          
        numGames = 1;
        
        //Asks if player wants to play again
        System.out.println("If you would like to play again, type yes");
        if (input.next() != "yes"){ 
            playing = false; 
        }    
      }
        
    }
    
//*******************End of main play method******************//    
     
    	//Creates first hand of the game
    public void firstHand(){
        for (int i = 0; i < 5; i++){
            //Card currentCard = cards.deal();
            //currentHand.add(i, currentCard);
            Card c = cards.deal();
            p.addCard(c);            
        }
        currentHand = p.getHand();        
    }
    
    //Creates new hand at the start of each new game
    public void newHand(){
        p.getHand().clear();
        for (int i = 0; i < 5; i++){
            Card c = cards.deal();
            p.addCard(c);            
        }
        currentHand = p.getHand();          
    }
    
    //Converts hand array list to hand string array (for printing) 
    public String[] cardToStringArray(ArrayList<Card> a){
        ArrayList<Card> cardList = a;
        String cardString = "";
        for (int i = 0; i < 5; i++){
            cardString = cardList.get(i).toString();
            cardStringArray[i] = cardString;        
        }
        return cardStringArray;
    }
    
    //Sorts hand
	public void sort(ArrayList<Card> h){
    	ArrayList<Card> currentHand = h;
        Collections.sort(currentHand);
    }
    
    //Checks what the hand is
    public String checkHand(){
        sort(currentHand);
        String handType = "";        
        if (royalFlush() == true){ 
            handType = "royal flush"; 
            p.winnings(250);            
        }
        else if (straightFlush() == true) { 
            handType = "straight flush"; 
            p.winnings(50);            
        }
        else if (fourOfAKind() == true) { 
            handType = "four of a kind";
            p.winnings(25);            
        }
        else if (fullHouse() == true) { 
            handType = "full house";
            p.winnings(6);            
        }
        else if (flush() == true) { 
            handType = "flush"; 
            p.winnings(5);            
        }
        else if (straight() == true) { 
            handType = "straight";
            p.winnings(4);            
        }
        else if (threeOfAKind() == true) { 
            handType = "three of a kind";
            p.winnings(3);            
        }
        else if (twoPair() == true) { 
            handType = "2 pair"; 
            p.winnings(2);            
        }
        else if (onePair() == true) { 
            handType = "1 pair"; 
            p.winnings(1);            
        }
        else if (noPair() == true) {
            handType = "no pair"; 
            p.winnings(-1);            
        }
        return handType;   	
	}
    
    public boolean royalFlush(){
        boolean success = false;
        
        Card card1 = currentHand.get(0);
        Card card2 = currentHand.get(1);
        Card card3 = currentHand.get(2);
        Card card4 = currentHand.get(3);
        Card card5 = currentHand.get(4);        
        if (straightFlush() == true){                             
            if ((card1.rank == 10)&& card4.rank == 13){
                success = true; 
            }
        }   
        return success;
    }
    
    public boolean straightFlush(){
        boolean success = false;
        if ((flush() == true)&&(straight() == true)){
            success = true;
        }
        return success;        
    }
    
    public boolean fourOfAKind(){
        boolean success = false;
        Card card1 = currentHand.get(0);
        Card card2 = currentHand.get(1);
        Card card3 = currentHand.get(2);
        Card card4 = currentHand.get(3);
        Card card5 = currentHand.get(4);
        if ((card1.rank == card4.rank)
         ||(card2.rank == card5.rank)){
            success = true;
        }
        return success;        
    }   
	
    public boolean fullHouse(){
        boolean success = false;
        if ((threeOfAKind() == true) && (onePair() == true)){
            success = true;
        }
        return success;            
    }
	
    public boolean flush(){
        boolean success = false;                            
        Card card1 = currentHand.get(0);
        Card card2 = currentHand.get(1);
        Card card3 = currentHand.get(2);
        Card card4 = currentHand.get(3);
        Card card5 = currentHand.get(4);   
        if ((card1.suit == card2.suit) && (card2.suit == card3.suit)){
           if ((card3.suit == card4.suit)&&(card4.suit == card5.suit)) {
               success = true;
           }
        }                          
        return success;
    }
    
    public boolean straight(){
        boolean success = false;                                    
		Card card1 = currentHand.get(0);
        Card card2 = currentHand.get(1);
        Card card3 = currentHand.get(2);
        Card card4 = currentHand.get(3);
        Card card5 = currentHand.get(4);                            
        if ((card5.rank == (4 + card1.rank))
            &&(card4.rank == (2 + card2.rank))){
            if (noPair() == true) { 
                success = true; 
            }                       
        }      
        return success;
    }                            
    
    public boolean threeOfAKind() {
        boolean success = false;        
        for (int i = 0; i < 3; i++){
            Card card1 = currentHand.get(i);
            Card card3 = currentHand.get(i+2);
            if (card1.rank == card3.rank){
                success = true;
            }       
        }
        return success;
    }

    public boolean twoPair() {
        boolean success = false;
        Card card1 = currentHand.get(0);
        Card card2 = currentHand.get(1);
        Card card3 = currentHand.get(2);
        Card card4 = currentHand.get(3);
        Card card5 = currentHand.get(4);
        if ((card1.rank == card2.rank)&&(card3.rank == card4.rank)
         ||((card2.rank == card3.rank)&&(card4.rank == card5.rank))
         ||(card1.rank == card2.rank)&&(card4.rank == card5.rank)) {
            success = true;
        }  
        else {
            success = false;
        }
        return success;
    }
    

    public boolean onePair(){
        boolean success = false;
        onePairMatches = 0;
        String match = "";
        Card card1 = currentHand.get(0);
        Card card2 = currentHand.get(1);
        Card card3 = currentHand.get(2);
        Card card4 = currentHand.get(3);
        Card card5 = currentHand.get(4);
        if ((card1.rank == card2.rank)||(card2.rank == card3.rank)
         ||(card3.rank == card4.rank)||(card4.rank == card5.rank)) {
            success = true;
            onePairMatches = 1;
        }
      
        return success;            
    }
    
    public boolean noPair(){
        boolean success = false;
        if (onePair() != true) { success = true; }
            
        /*if (onePairMatches == 0) { 
            success = true;
        }*/
        return success;
    }
    
    
    
}
