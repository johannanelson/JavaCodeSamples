//***********************************************************
// jn2631
// Author: Johanna Nelson
// 
// Player.java
// 
// Represents a player that can manipulate a hand of cards.
//***********************************************************

import java.util.ArrayList;

public class Player {
	
		
	private ArrayList<Card> hand;
	private double bankroll;
    private double bet;
		
	public Player(){		
	    hand = new ArrayList<Card>();
        bankroll = 100.0;
        bet = 0.0;
	}

    //Evaluates whether to add a new card to player's hand
    public void cardDecision(int ch, int c, ArrayList<Card> h, Deck d){
        int choice = ch;
        int cardNum = c;
        hand = h;
        Deck cards = d;
        Card newCard = cards.deal();
        if (choice == 1){
            removeCard(hand.get(cardNum));
            addCard(newCard);
        }
        else {
           choice = 2; 
        }
    }
	
    //Returns hand
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    //Adds card to hand
    public void addCard(Card c){
        Card card = c;
        hand.add(card);
	}

	//Removes card from hand
    public void removeCard(Card c){
        Card card = c;
        hand.remove(card);
    }
    
	//Receive bet amount from player	
    public void bets(double amt){
        bet = amt;        
    }
    	                              
    //Adjusts bankroll if player wins
    public void winnings(double odds){
        double hValue = odds;
        bankroll = bankroll + (hValue * bet);            
    }

    //Returns current balance of bankroll
    public double getBankroll(){
            return bankroll;
    }

}