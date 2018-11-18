package math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created on 11-11-2018
 */

/**
 * @author Hanan And Zena And Sally
 * Calculating a Berlin tax that could be done on a beer mat.
 */
public class TaxCalc {
    static int nFamilyMembers;
    static int exemption;
    static double income;
    static double age;
    static double taxTotal;

    public static void main(String[] args) {

        // A Reader stream to read from the console
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println ("Welcome to the new Palestine tax calculator Annually.");
        System.out.print   ("How much did you earn last year? ");
        try {
            income = Double.parseDouble(in.readLine());
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        System.out.print("Enter Your Age: ");
        try {
            String s = in.readLine();
           age = Integer.valueOf(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
//     check income

        if (income <= 0) {
            System.out.println ("We  can not calculate for 0 income !");
            print_tax(taxTotal );
        }

        
        if (income <= 1450) {
            System.out.println ("Your Income is Equal or less than Minimum wage ");     
            print_tax(taxTotal );
        }
        System.out.print("Enter the number of dependents Family you have, including yourself: ");
        try {
            String s = in.readLine();
            nFamilyMembers = Integer.valueOf(s).intValue();
        } catch (IOException e) {
            e.printStackTrace();
        }

//     check number of family members

       if (nFamilyMembers <= 0) {
          System.out.println("Did you forget to count yourself?");
          print_tax(taxTotal );
          }
       
//     check Your age      
       
       if (age <= 25) {
           System.out.println("Are You Still Studing?");
           print_tax(taxTotal );
           }

//    compute tax total

      if (income < 2000 && income > 1450)
         taxTotal = 0.12 * income;
      else if (income < 5000 && income >= 2000)
         taxTotal = 300.00 + 0.24 * (income - 1000);
      else
         taxTotal = 1500.00 + 0.36 * (income - 5000);

      for (int i = 0; i <= nFamilyMembers; i++){
           taxTotal = taxTotal - 100;
          
      }

      print_tax(taxTotal );
  
    }
    public static void print_tax(double taxTotal2 ) {
        if (taxTotal2 < 0) // In case of negative tax
        	
            taxTotal2=0;
        
         System.out.println ("Your total tax is " + taxTotal2 + " NIS");
         System.exit(-1);
       
         }	

    
    
}