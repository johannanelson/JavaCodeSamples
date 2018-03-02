//*******************************************************
// jn2631
// Author: Johanna Nelson
// 
// Card.java
// 
// Represents a single card.
//*******************************************************

public class Card implements Comparable<Card> {
	
	int suit; 
	int rank; 
	
	public Card(int s, int r){
        suit = s;
        rank = r;
        
	}
	
	//Compareto method for sorting hand
    public int compareTo(Card c){    		
        Card other = c;
        int answer = 0;
        
        //Compares ranks if ranks aren't equal
        if ((this.rank) - (other.rank) != 0) {
            if (this.rank < other.rank) { answer = -1; }
            if (this.rank > other.rank) { answer = 1; }
        }
        //Compares suits if ranks are equal
        if ((this.rank) - (other.rank) == 0) {
            //compare suits if ranks are equal
            if (this.suit < other.suit) { answer = -1; }
            if (this.suit > other.suit) { answer = 1; }
        }    
        
        return answer;

	}

	//Converts a card object to a string
    public String toString(){
        String cardPrint = "";
        int r = this.rank
            if (r < 11){                
            	cardPrint = (Integer.toString(r) + getStringSuit(suit));                         
            }
			else if (r == 11){
				cardPrint = ("Jack" + getStringSuit(suit));
            }
            else if (r == 12){
				cardPrint = ("Queen" + getStringSuit(suit));                
            }
            else if (r == 13){
				cardPrint = ("King" + getStringSuit(suit));                
            }
            else if (r == 14){
				cardPrint = ("Ace" + getStringSuit(suit));                
            }
          
        
    return cardPrint;
    }
        
    //Returns value of suits for toString method    
    public String getStringSuit(int n){
    	int num = Integer.valueOf(n);
    	String suit = "";
		switch (num){
            case 1: suit = " of clubs";
                    break;
            case 2: suit = " of diamonds";
                    break;
            case 3: suit = " of hearts";
                    break; 
            case 4: suit = " of spades";
                	break;
        }
        return suit;
    }
    
    public int getSuit() {
        return suit;
    }
    
    public int getRank(){
        return rank;
    }
}