//*******************************************************
// jn2631
// Author: Johanna Nelson
// 
// Scheduler.java
// 
// Repository for static methods used for Talk objects.
//*******************************************************

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Scheduler {
    private static ArrayList<Talk> talks;
    private static ArrayList<Talk> scheduledTalks;
     
    // Method for creating and sorting an ArrayList of talks from a text file
    public static ArrayList<Talk> makeTalks(String f) throws IOException {  

        try{
        
            File inFile = new File(f);
            Scanner input = new Scanner(inFile);
            talks = new ArrayList<Talk>();

            // Loop for reading each line of text file into Talk object
            while (input.hasNextLine()){
                // For each line, assign title, start and end data using Scanner              
                Scanner lineScanner = new Scanner(input.nextLine());
                String title = lineScanner.next();
                int start = lineScanner.nextInt();
                int end = lineScanner.nextInt();
                
                // Create new Talk object using these variables
                Talk t = new Talk(title, start, end);
                
                // Add Talk to ArrayList of talks
                talks.add(t);
            }
            input.close();
            
            // Sort the talks, once they are all in the ArrayList
            Collections.sort(talks);
        }
        
        // Catch clauses; explanatory by print lines
        catch (FileNotFoundException e) {
            System.out.println("Check the input of your file name.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Check the parameter input for method.");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Enter file name as a command line argument.");
        }
        catch (Exception e){
            System.out.println("You've reached an exception! Please try again.");
        }
        
        // The talks ArrayList will always be returned
        finally {    
            return talks;
        }
            
    }
 
    // Method for creating schedule with most possible talks in a day
    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> a) throws FileNotFoundException {
        
        try {
            talks = a;
            scheduledTalks = new ArrayList<Talk>();
                
                // Looping through each element in ArrayList talks
                for (int i = 0; i < talks.size(); i++){
                    
                    // First, adds the first element of talks to the schedule because of CompareTo method
                    if (scheduledTalks.size() == 0){
                        scheduledTalks.add(talks.get(i));
                    }
                    
                    // For all other talks, adds the talk if its start time is later than the end time of
                    // the final element in the schedule at that point 
                    else if (talks.get(i).getStartTime() > scheduledTalks.get(scheduledTalks.size() - 1).getEndTime()) {
                        scheduledTalks.add(talks.get(i));
                    }

                }
        
            // Creates and uses PrintWriter object to print each Talk in the schedule to 
            // an output file
            PrintWriter output = new PrintWriter("output.txt");              
            for (Talk i : scheduledTalks){
                output.println(i.toString());                
            }
            output.close();
        }
        
        // Catch clauses; explanatory by print line
        catch (FileNotFoundException e) {
            System.out.println("Check the input of your file name.");
        }
        
        // The talks ArrayList will always be returned
        finally {
            return scheduledTalks;
        }
    
    }

}
