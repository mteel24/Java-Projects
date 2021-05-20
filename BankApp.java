import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class BankApp {
   private String firstName;
   private String lastName;
   private double currentBalance;
   public BankApp(){
      this.currentBalance = 0.00;
      Scanner s = new Scanner(System.in);
      String userchoice = "y";
      while(!userchoice.equals("n")){
         String userinput = "";
         bankAppInstructions();
         int choice = userChoice(s);
         switch(choice){
            case 1:
               System.out.print("Your current balance is: ");
               System.out.println("$"+this.currentBalance);
               break;
            case 2:
               System.out.print("How much money would you like to deposit: ");
               double dep = s.nextDouble();
               this.currentBalance+=dep;
               break;
            case 3:
               System.out.print("How much money would you like to withdraw: ");
               double wit = s.nextDouble();
               if(this.currentBalance == 0.0){
                  System.out.println("Current Balance is $0.00!\nCan not withdraw money!");
               }else{
                  this.currentBalance-=wit;
               }
               break;              
         }
         System.out.print("Enter y to continue or n to stop and get a final print out: ");
         userchoice = s.next();  
      }
      System.out.print("Enter first name: ");
      String fname = s.next();
      System.out.print("Enter last name: ");
      String lname = s.next();
      this.firstName = fname;
      this.lastName = lname;
      System.out.println("Printing receipt...");
      bankReceipt(this.firstName, this.lastName, this.currentBalance);
   }
   public void bankAppInstructions(){
      System.out.println("===================================================");
      System.out.println("Please make a selection below:");
      System.out.println("1.Check current balance.");
      System.out.println("2.Deposit Money.");
      System.out.println("3.Withdraw Money.");
      System.out.println("===================================================");
      System.out.print("Pick your choice: ");
   }
   public void bankReceipt(String fn, String ln, double fb){
      try {
         FileWriter myWriter = new FileWriter(ln+".txt");
         myWriter.write("Your final receipt is:\n");
         myWriter.write("\n======================\n");
         myWriter.write("\nfinal balace: $"+fb+"\n");
         myWriter.write("\n"+ln + ", " + fn+"\n");
         myWriter.write("\n======================\n");
         myWriter.write("\nThank you for using the banking app!\n");
         myWriter.write("\n======================\n");
         myWriter.close();
         System.out.println("Successfully printed to the receipt!");
      }catch (IOException e) {
         System.out.println("An error occurred!");
         e.printStackTrace();
      }
   }
   public int userChoice(Scanner x){
      int c = x.nextInt();
      while((c != 1) && (c!= 2) && (c!= 3)){
         System.out.println("Improper input!");
         System.out.print("Input choice from the list: ");
         c = x.nextInt();
      }
      return c;
   }
}