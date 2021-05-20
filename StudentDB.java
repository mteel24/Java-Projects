import java.util.Scanner;
import java.util.Random;
public class StudentDB {
   private String firstName;
   private String lastName;
   private String email;
   private String studentPassword;
   private String degree;
   private String phoneNumber;
   private String address; 
   public StudentDB(){
      Scanner s = new Scanner(System.in);
      System.out.print("Enter students first name: ");
      this.firstName = s.nextLine();
      System.out.print("Enter students last name: ");
      this.lastName = s.nextLine(); 
      this.email = createEmail();
      System.out.print("Enter student year of entry: ");
      String pw = createPassword();
      this.studentPassword = s.nextLine()+pw;
      System.out.print("Enter students degree: ");
      this.degree = s.nextLine();
      System.out.print("Enter students phoneNumber (ex.123-456-7890): ");
      this.phoneNumber = s.nextLine();
      System.out.print("Enter students address (ex.homeaddress city, state zipcode): ");
      this.address = s.nextLine();    
   }
   public String getFirstName(){
      return this.firstName;
   }
   public void setFirstName(String fn){
      this.firstName = fn;
   }
   public String getLastName(){
      return this.lastName;
   }
   public void setLastName(String ln){
      this.lastName = ln;
   }
   private String createEmail(){
      return this.lastName.toLowerCase()+this.firstName.toLowerCase()+"@domain.edu";
   }
   private String createPassword(){ 
    Random rand = new Random();
      String password = "";
      String[] alph = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
      for(int i = 0; i <= 7; i++){
         int int_random = rand.nextInt(alph.length);
         String k = alph[int_random]; 
         password = password + k;
      }      
      return password;
   }
   public String getDegree(){
      return this.degree;
   }
   public void setDegree(String de){
      this.degree = de;
   }
   public String getPhoneNumber(){
      return this.phoneNumber;
   }
   public void setPhoneNumber(String pn){
      this.phoneNumber = pn;
   }
   public String getAddress(){
      return this.address;
   }
   public void setAddress(String ad){
      this.address = ad;
   }
   public String toString(){
      return email+"\t\t"+this.firstName+" "+this.lastName+"\t\t"+this.studentPassword+"\t\t"+this.degree+"\t\t"+this.phoneNumber+"\t\t"+this.address;
   }
}