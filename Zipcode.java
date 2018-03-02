/*****************************************
 * Zipcode Test
 * 
 * @author Johanna Nelson
 
 ****************************************/ 
import java.util.Scanner;
import java.lang.StringBuilder;

public class Zipcode {
    
    private int zipCode;
    private String barCode;
    private String digit1;
    private String digit2;
    private String digit3;
    private String digit4;
    private String digit5;
    private String code1;
    private String code2;
    private String code3;
    private String code4;
    private String code5;
    private String code6;
    private String code7;
    private String code8;
    private String code9;
    private String code0;
    private StringBuilder zipFinal;
    
    
    
    //for use if integer (presumably a zipcode) is inputted
    public Zipcode(int zip){
        
        zipCode = zip;
        barCode = "|";
        code1 = ":::||";
        code2 = "::|:|";
        code3 = "::||:";
        code4 = ":|::|";
        code5 = ":|:|:";
        code6 = ":||::";
        code7 = "|:::|";
        code8 = "|::|:";
        code9 = "|:|::";
        code0 = "||:::";   
    }
     
    //for use if string (barcode) is inputted
    public Zipcode(String bar){
        zipCode = 0;
        barCode = bar;
        zipFinal = new StringBuilder("");
        digit1 = barCode.substring(1,6);
        digit2 = barCode.substring(6,11);
        digit3 = barCode.substring(11,16);
        digit4 = barCode.substring(16,21);
        digit5 = barCode.substring(21,26);
    }
     
    //return value of zipcode (translated barcode)
    public String getZIPcode(){
        barToZip();
        return String.valueOf(zipFinal);
    }
    
    //return value of barcode (translated zipcode)
    public String getBarcode(){
        zipToBar();
        return barCode;
    }
        
    //converts an inputted zipcode to barcode
    public void zipToBar(){ //zipcode to barcode        
        String zipCodeString = String.valueOf(zipCode) + this.checkDigit();
        int current = 0; //Q: is it okay to initialize these to 0?
        
        for (int i = 1; i < zipCodeString.length(); i++){
            current = Integer.parseInt(zipCodeString.substring((i-1), i));
            barCode = barCode + this.barCodeValue(current);
        }
        barCode = barCode + "|";
    }
    
    //begins conversion from barcode to zipcode
    public void barToZip() { 
        
        //reports input errors or mismatch in the digits:
        if (barCode.length() != 27){
            System.out.println("You inputted the barcode wrong. Check if you added the extra bars at the beginning and end.\n");  
        }    
        else
            System.out.println("Your barcode formatting looks good. Let's proceed.\n");

        for (int i = 1; i < 22; i = i + 5) {        
            String currentCode = barCode.substring(i,(i+5));
            if ((currentCode.equals(":::||")) == true) {            
                this.buildZipCode("1");
            }
            if ((currentCode.equals("::|:|")) == true) {            
                this.buildZipCode("2");
            }
            if ((currentCode.equals("::||:")) == true) {            
                this.buildZipCode("3");
            }
            if ((currentCode.equals(":|::|")) == true) {            
                this.buildZipCode("4");
            }
            if ((currentCode.equals(":|:|:")) == true) {            
                this.buildZipCode("5");
            }
            if ((currentCode.equals(":||::")) == true) {            
                this.buildZipCode("6");
            }
            if ((currentCode.equals("|:::|")) == true) {            
                this.buildZipCode("7");
            }
            if ((currentCode.equals("|::|:")) == true) {            
                this.buildZipCode("8");
            }
            if ((currentCode.equals("|:|::")) == true) {            
                this.buildZipCode("9");
            }
            if ((currentCode.equals("||:::")) == true) {            
                this.buildZipCode("0");
            }

        } 
    }
     
    //completes conversion of barcode to zipcode
    //using data from barToZip()
    public StringBuilder buildZipCode(String digit){
        String current = digit;
        zipFinal.append(current); 
        return zipFinal; 
    }
      
    //switch cases to find a zipcode digit's matching barcode
    public String barCodeValue(int num){ 
        int number = num;
        String barCode = "";
        switch (number){
            case 1: barCode = ":::||";
                    break;
            case 2: barCode = "::|:|";
                    break;
            case 3: barCode = "::||:";
                    break;
            case 4: barCode = ":|::|";
                    break;
            case 5: barCode = ":|:|:";
                    break;
            case 6: barCode = ":||::";
                    break;
            case 7: barCode = "|:::|";
                    break;
            case 8: barCode = "|::|:";
                    break;
            case 9: barCode = "|:|::";
                    break;
            case 0: barCode = "||:::"; 
                    break;
        }
        return barCode;
    
    }             
  
    //computes the check digit of a zipcode 
    public String checkDigit(){ 
        String zipCodeString = String.valueOf(zipCode);
        int zipCodeSum = 0;
        int checkDigit = 0;
        for (int i = 0; i < (zipCodeString.length()); i++){
            zipCodeSum = zipCodeSum + (int)zipCodeString.charAt(i);
        }
        if ((zipCodeSum % 10) != 0){
            checkDigit = zipCodeSum -(zipCodeSum - (zipCodeSum % 10));
        }
        else
            checkDigit = 0;
        return String.valueOf(checkDigit);
     }  

}