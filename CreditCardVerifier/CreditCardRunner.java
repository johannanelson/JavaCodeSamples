/* Johanna Nelson
 * jn2631
 * CreditCard.java
 */

public class CreditCard { 
    
    private String cardNumber;
    private int errorCode;
    private boolean valid;

    
    //main method
    public CreditCard(String n) {
        cardNumber = n;
        valid = true;
        errorCode = 0;   
    }
    
    //determines whether card is valid or not
    public void check() {   
        if (errorCode == 0) {    
            check1();
        }
        if (errorCode == 0) { 
            check2();
        }
        if (errorCode == 0) {
            check3();
        }
        if (errorCode == 0) { 
            check4();
        }
        if (errorCode == 0) { 
            check5();
        }
        if (errorCode == 0) {
            check6();
        }
    }                  
    
    //returns value of boolean Valid
    public boolean isValid() {
        return valid; 
    }

    //returns the value of errorCode
    public int getErrorCode() {
        return errorCode;
    }

    
    //Check 1: The first digit must be a 4.
    private void check1() {        
        int first = Integer.parseInt(cardNumber.substring(0,1));
        if (!(first == 4))
        {
            valid = false;
            errorCode = 1;
        }           
    }
    
    //Check 2: The fourth digit must be one greater than the fifth digit
    private void check2() {        
        int fourth = Integer.parseInt(cardNumber.substring(3,4));
        int fifth = Integer.parseInt(cardNumber.substring(4,5));
                                        
        if (fourth != (fifth + 1))
        {   
            valid = false;
            errorCode = 2;
        }
    }
    
    //Check 3: The product of the first, fifth, and ninth digits must be 24
    private void check3() {         
        int first = Integer.parseInt(cardNumber.substring(0,1));
        int fifth = Integer.parseInt(cardNumber.substring(4,5));
        int ninth = Integer.parseInt(cardNumber.substring(8,9));
        if (first * fifth * ninth != 24)
        {    
            valid = false;
            errorCode = 3;
        }
    }
    
    //Check 4: The sum of all digits must be evenly divisible by 4
    private void check4() {        
        int sum = 0;
        for (int i = 0; i < cardNumber.length(); i++)
        {     
            sum = sum + (int)cardNumber.charAt(i);
        }
        if (sum % 4 != 0)
        {    
             valid = false;
             errorCode = 4;
        }    
    }
    
    //Check 5: The sum of the first four digits must be one less than 
    //the sum of the last four digits  
    private void check5() {        
        int sumFirst4 = 0;
        int sumLast4 = 0;
        for (int i = 0; i < 4; i++) {    
            sumFirst4 = sumFirst4 + (int)cardNumber.charAt(i);
        }    
        for (int i = 8; i < 12; i++) {    
            sumLast4 = sumLast4 + (int)cardNumber.charAt(i);
        }
        if (sumFirst4 != sumLast4 - 1) {    
            valid = false;
            errorCode = 5;
        }    
    }
    
    //Check 6: If you treat the first two digits as a two-digit number, 
    //and the seventh and eight digits as a two digit number, their sum
    // must be 100.
    private void check6() {         
        int firstTwoDigits = 0;
        int seventhEighthDigits = 0;
        firstTwoDigits = Integer.parseInt(cardNumber.substring(0,2));
        seventhEighthDigits = Integer.parseInt(cardNumber.substring(6,8));
        if (firstTwoDigits + seventhEighthDigits != 100) {    
            valid = false;
            errorCode = 6;
        }    
    }
             
}
