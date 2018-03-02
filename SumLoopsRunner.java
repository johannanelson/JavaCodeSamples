//Runnner for Class SumLoops (E6.2)

import java.util.Scanner;
public class SumLoopsRunner{ 
    public static void main(String[] args) {
    
        SumLoops user = new SumLoops();
        System.out.println("Sum of all even numbers between 2 and 100: " + user.SumsEven());
        System.out.println("Sum of all squares between 1 and 100: " + user.SumsSquares());
        System.out.println("All powers of 2 from 2^0 to 2^20: " + user.PowersOfTwo());
        System.out.println("Sum of all odd numbers between 2 and 81: " + user.SumD(2,81));
        System.out.println("Sum of all odd numbers in 495: " + user.SumofOdds("495"));    
    }
}