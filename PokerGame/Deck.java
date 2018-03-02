//*******************************************************
// jn2631
// Author: Johanna Nelson
// 
// Deck.java
// 
// Represents a deck of cards.
//*******************************************************

import java.util.Scanner;
public class Deck {
	
	private Card[] cards;
	private int top; 
	
	public Deck() { 
        top = 0;
        cards = new Card[52];
        createDeck();        
	}
    
    //Creates a new deck
    public void createDeck(){
        int currentNum = 0;	
        for (int i = 1; i < 5; i++)  {
            for (int j = 1; j < 14; j++) {              
                cards[currentNum] = new Card(i,j);                
                currentNum++;                
            }        
        } 
    }
    
    //Shuffles the deck
    public void shuffle(){ 
        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < cards.length; j++){
                Card temp = cards[j];
                int newPosition = (int)(Math.random() * 52); 
                cards[j] = cards[newPosition];
                cards[newPosition] = temp;
            }
        }
            
	}
    
	//Deals top card of the deck
	public Card deal(){       
        top++;
        return cards[top - 1];   
	}

}
