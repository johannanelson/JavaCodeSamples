/**
 * This program Perform different mathematical problems about the sums of numbers.
 * 
 * @author: <Johanna Nelson>
 * @date: <09/22/17>
 */

public class SumLoops {
    
    private int n;
    private int Num;
    private int SumA = 0;
    private int SumB = 0;
    private int ListC = 0;
    private int SumD = 0;
    private int SumofOdds = 0;
    private int SumE = 0;
    
    
    public SumLoops()
    {
        
    }
    
    public int SumsEven()
    {
        n = 2;
        while (n <= 100)
        {
            SumA = SumA + n;
            n = n + 2;
        }
        return SumA;
        //System.out.println("Sum of all even numbers between 2 and 100: " + SumA);
    }
    
    public int SumsSquares()
    {
        n = 1;
        while ((int)Math.pow(n,2) <= 100)
        {
            SumB = SumB + ((int)Math.pow(n, 2));
            n = n + 1;
        }
        return SumB;
        //System.out.println("Sum of all squares between 2 and 100: " + SumB);
    }
    
    public int PowersOfTwo()
    {
        n = 0;
        while (n <= 20)
        {
            SumC = SumC + (int)Math.pow(2,n);
            n = n + 1;
        }
        return ListC;
        //System.out.println("Sum of all powers of 2 from 2^0 to 2^20: " + ListC);
    }
    public int SumD(int a, int b)
    {
        n = a;
        if (n % 2 == 0)
                n = n + 1;
        while (n <= b)
        {
            SumD = SumD + n;
            n = n + 2;
        }
        return SumD;
        //System.out.println("Sum of all odd numbers between" + a + "and" + b + ": " + SumD);
    }
    
    public int SumofOdds(String Num)
    {
        //int Number = Integer.parseInt(Num);
        
        //Num = (int)Number;
        for (int i = 0; i < Num.length(); i++)
        {
            char ch = Num.charAt(i);
            if ((int)ch % 2 != 0)
            {
                SumE = (SumE + ch);
                return ch;
            }
            else
                i++;
                              
                //return SumE;
        }
        return SumofOdds;
    }
    
    //have input be a string
    //parse int 
}