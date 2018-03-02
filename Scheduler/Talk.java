//*******************************************************
// jn2631
// Author: Johanna Nelson
// 
// Talk.java
// 
// Models a talk.
//*******************************************************

public class Talk implements Comparable<Talk> {
	
	private String title; 
	private int start; 
    private int end;
	
	public Talk(String t, int s, int e){
        title = t;
        start = s;
        end = e;
        
	}
    
    // CompareTo method for sorting Talk objects
    public int compareTo(Talk t){
            Talk other = t;
            int answer = 0;
            if (this.end < other.end) { answer = -1; }
            else if (this.end > other.end) { answer = 1; }
            else{
                if (this.start < other.start) { answer = -1; }
                else if (this.start > other.start) { answer = 1; }
                else { answer = 0; }
            }
            return answer;
        }

	// Converts Talk object to a string
    public String toString(){
        String talkPrint = "";
        talkPrint = title + ": " + (Integer.toString(start) + " - " + Integer.toString(end));       
        return talkPrint;
    }
    
    // Returns start time of Talk object
    public int getStartTime() {
        return start;
    }
    
    // Returns end time of Talk object
    public int getEndTime() {
        return end;
    }

        
}
