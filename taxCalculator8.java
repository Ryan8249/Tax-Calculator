/* Author: Ryan Borland
Student Number: L00162964
Date: 20/05/2021
CA1
Tax Calculator to calculate the tax of three types of users. Student part-time, single full-time and married full-time. 
The program will ask the user what annual income they earn and what type of user they are. For married users the programe
will also ask if the users spouse is working or not working. Each type of user will pay different percentages in tax. The precentage 
in tax will be deducted from the users annual income and be dispayed on screen.  */

import java.util.*;
import java.text.DecimalFormat;// soucred from https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/

public class taxCalculator8

{
   private static DecimalFormat df = new DecimalFormat("0.00");//Rounding the decimal two places. Soucred from https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/
     
      public static void main(String []args)
      
   {
      Scanner keyboardIn = new Scanner(System.in);
      //Declare variables & initialize income and option to 0
      double income = 0,taxableIncome, totalTaxPayable, takeHomePay, percentage;
      int option = 0; 
      char category;
      
         //Input of income errors, entering letter insead of numbers.
         try //Sourced from Tuesdays drop in session & https://javahungry.blogspot.com/2020/06/inputmismatchexception.html & https://www.geeksforgeeks.org/decision-making-javaif-else-switch-break-continue-jump/#jump
         {
   
         //Welcome & ask user to enter annual income
         System.out.println("Welcome to the LYIT Tax Calculator.");
         System.out.print("Please enter your annual income: ");
         income = keyboardIn.nextDouble();
         
         }
         catch(InputMismatchException ex)      
         {
            System.out.print("Invalid - Please enter only numbers for income.");//Display error message
            return;
         }//End of try catch
         
           // If user earns less than 5000, there is no need to ask anymore questions as they will pay no tax
            if(income <5000)
            {
            System.out.println("Annual Income: " +df.format(income)); //Display annual income
            System.out.println("You have an annual income of less than 5000, no tax has to be paid."); //Display message
            return;// Sourced from https://www.geeksforgeeks.org/decision-making-javaif-else-switch-break-continue-jump/#jump
            }
            
               else if(income >= 5000) //Prompt user to choose a category
               {
               try
               {
               System.out.println("Tax categories:\n [1] Student part-time\n [2] Single full-time\n [3] Married full-time\n");//New line sourced from https://www.baeldung.com/java-string-newline#:~:text=In%20Windows%2C%20a%20new%20line,the%20end%20of%20our%20string.
               System.out.print("Please enter your Tax Category: ");
               option = keyboardIn.nextInt(); //Read and store keyboard input
               }
               catch(InputMismatchException ex)      
               {
                 System.out.print("Invalid option chosen, please choose options 1-3.");//Display error message
                   return;
               }//End of try catch
               }
             
               switch(option)//open switch
                  {
                  case 1:
                     //Student Part-Time pays 10% tax on all earnings
                    
                    {
                     System.out.println("Category 1 - Student part-time");//Informing user what category they choose
                     totalTaxPayable = income/100*10; //Total tax payable is calculated by dividing the total income by 100 and multiplying by 10
                     takeHomePay = income - totalTaxPayable; //Take home pay calculated by subtracting the total tax payable from the total income
                     System.out.println("Annual Income: " +df.format(income)); //Display annual income
                     System.out.println("Taxable Income: " + df.format(income)); //Display taxable income sourced from https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/
                     System.out.println("Total tax payable: " + df.format(totalTaxPayable)); //Display total taxpayable
                     System.out.println("Take home pay: " + df.format(takeHomePay)); //Display take home pay
                     System.out.println("Your actual tax paid percentage is 10%"); //Informing the user of the total percentage they have paid             
                     return;
                     }
                   
                  case 2:
                  
                  if (income <=10000)//Single Full-Time pays no tax because income <= 10000
                  {
                  System.out.println("Category 2 - Single full time"); //Informing user what category they choose
                  System.out.println("Because you are single and earn less than or equal to 10000 you pay no tax."); //Display message
                  return;
                  }
                  else if (income >10000)//Single Full-Time pays tax on amounts >10000
                  {
                  System.out.println("Category 2 - Single full time"); //Informing user what category they choose
                  totalTaxPayable = income/100*30; //Total tax payable is calculated by dividing the total income by 100 and multiplying by 30
                  takeHomePay = income - totalTaxPayable; //Take home pay calculated by subtracting the total tax payable from the total income
                  System.out.println("Annual Income: " +df.format(income)); //Display annual income
                  System.out.println("Taxable Income: " + df.format(income)); //Display taxable income sourced from https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/
                  System.out.println("Total tax payable: " + df.format(totalTaxPayable)); //Display total taxpayable
                  System.out.println("Take home pay: " + df.format(takeHomePay)); //Display take home pay
                  System.out.println("Your actual tax paid percentage is 30%"); //Informing the user of the total percentage they have paid
                  return;
                  }
                  
                  case 3:
                  
                  //Married Full-Time
                
                  
                  System.out.println("Category 3 - Married full-time");//Informing user what category they choose
                  System.out.println("Dose your spouse also work? [Y or N]: ");//Prompting the user to choose Y or N
                  category = keyboardIn.next().charAt(0); //Read and store keyboard input
                  
                  
                 
                     //Married Full-Time Spouse Working
                     switch (category) //:Nested switch sourced from https://www.geeksforgeeks.org/nested-switch-case/               
                     {
                        //Married and earning <=20000
                        case 'Y': case 'y':
                        if(income <=20000)
                        {
                        System.out.println("Category 3 - Married full-time");//Informing user what category they choose
                        System.out.println("Married with two incomes"); //Informing the user what martial status they choose
                        System.out.println("Because you are married, your spouse is working and you earn less than or equal to 20000 you pay no tax.");//Display message
                        break;
                        }
                     
                        else//Married and earning >20000
                        { 
                        System.out.println("Category 3 - Married full-time"); //Informing user what category they choose
                        System.out.println("Married with two incomes"); //Informing the user what martial status they choose
                        totalTaxPayable = income/100*25; //Total tax payable is calculated by dividing the total income by 100 and multiplying by 25
                        takeHomePay = income - totalTaxPayable; //Take home pay calculated by subtracting the total tax payable from the total income
                        System.out.println("Annual Income: " +df.format(income)); //Display annual income
                        System.out.println("Taxable Income: " + df.format(income)); //Display taxable income sourced from https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/
                        System.out.println("Total tax payable: " + df.format(totalTaxPayable)); //Display total taxpayable
                        System.out.println("Take home pay: " + df.format(takeHomePay));
                        System.out.println("Your actual tax paid percentage is 25%"); //Informing the user of the total percentage they have paid
                        break;
                        
                        }
                     
                        //Married Full-Time Spouse Not Working
                        case'N': case'n': //Not married and earning <=30000
                        if(income <=30000)
                        {
                        System.out.println("Category 3 - Married full-time"); //Informing user what category they choose
                        System.out.println("Married with one income"); //Informing the user what martial status they choose
                        System.out.println("Because you are married, your spouse is not working and you earn less than or equal to 30000 you pay no tax."); //Diplay message
                        break;
                        }
                       
                         else // Not married and earning >30000
                        { 
                        System.out.println("Category 3 - Married full-time"); //Informing user what category they choose
                        System.out.println("Married with one income"); //Informing the user what martial status they choose
                        totalTaxPayable = income/100*25; //Total tax payable is calculated by dividing the total income by 100 and multiplying by 25
                        takeHomePay = income - totalTaxPayable; //Take home pay calculated by subtracting the total tax payable from the total income
                        System.out.println("Annual Income: " +df.format(income)); //Display annual income
                        System.out.println("Taxable Income: " + df.format(income)); //Display taxable income sourced from https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/
                        System.out.println("Total tax payable: " + df.format(totalTaxPayable)); //Display total taxpayable
                        System.out.println("Take home pay: " + df.format(takeHomePay));
                        System.out.println("Your actual tax paid percentage is 25%"); //Display message
                        break;
                        }
                        
                        default:
                           System.out.print("Invaild option chosen, please choose Y or N.");
                     }//Close nested switch
                           break;
                           default:
                        System.out.print("Invalid option chosen, please choose options 1-3.");
                  }//Close switch
              
   }
}

      


 