/* Your code must work with test class.
   Do not alter this class.
*/

import java.util.ArrayList;
import java.io.*;

public class ScheduleTest{

    public static void main(String[] args){

        // First, use a command line argument to speicify the f
        // name of the file containing the talks.
        // Then write a static method makeTalks that returns
        // an ArrayList of talks. This method must handle any exceptions.

        if (args.length>0)
        {
	        try
            {    
                ArrayList<Talk> talks = Scheduler.makeTalks(args[0]);
           
                // Next, pass the ArrayList of talks to the staic method
                // scheduleTalks to schedule the maximum number of talks in 
                // the ArrayList.
                ArrayList<Talk> scheduledTalks=Scheduler.scheduleTalks(talks);

                // Finally, print the list of scheduled talks. Notice this requires a
                // toString method in the Talk class. You will have to provide one.
                for (Talk talk:scheduledTalks){
                    System.out.println(talk);
                }
            }		
	        catch(IOException e)
            {	    
                System.out.println("There is a problem with the file you specified");
            }

        }
	    else
        {
            System.out.println("You must specify a file name at the command line");
        }
    }
}    
