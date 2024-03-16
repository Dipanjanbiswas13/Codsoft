import java.util.Scanner;
class Bankaccount{
    private double balance;
    public Bankaccount(double i_balance){
        this.balance=i_balance;
    }
    public double getBal(){
        return balance;
    }
    public void deposit(double amnt){
        if(amnt>0){
            balance+=amnt;
            System.out.println("Rs. "+amnt+" has been deposited successfully."+"\nYour Current account balance is : Rs. "+balance);
        }
        else{
            System.out.println("Deposit Amount is invalid !!");
        }
    }
    public void withdrawl(double amnt){
        if(amnt>0 && amnt<=balance){
            balance-=amnt;
            System.out.println("Rs. "+amnt+" has been withdrawn successfully."+"\nYour Current account balance is : Rs."+balance);
        }
        else{
            System.out.println("Invalid Withdrawl Amount or Insufficient Balance!");
        } 
    }
}
class ATM {
    private Bankaccount bankaccount;
    public ATM(Bankaccount bankaccount) {
        this.bankaccount = bankaccount;
    }
    public void displayMenu(){
        System.out.print("\nATM MENU:"+"\n1. CHECK BALANCE"+"\n2. DEPOSIT"+"\n3. WITHDRAW"+"\n4. EXIT");
    }
    public void transaction(int ch, Scanner sc){
        switch (ch) {
            case 1:
                System.out.print("Your Current account Balance: Rs."+bankaccount.getBal());
                break;
            case 2:
                System.out.print("Enter Deposit Ammount:Rs.");
                double deposit_amnt=sc.nextDouble();
                bankaccount.deposit(deposit_amnt);
                break;
            case 3:
                System.out.print("Enter Withdrawl Ammount: Rs.");
                double withdrawl_amnt=sc.nextDouble();
                bankaccount.withdrawl(withdrawl_amnt);
                break; 
            case 4:
                System.out.println("Exiting ATM"+"\n THANK YOU for using it !!!");
                sc.close();
                System.exit(0);
                break;          
            default:
               System.out.println("Invalid Choice. Please Select a Valid Option.");
        }
    }
}
public class atm_interface {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Your  initial account balance: Rs. ");
        double i_balance=sc.nextDouble();
        Bankaccount bankaccount=new Bankaccount(i_balance);
        ATM atm=new ATM(bankaccount);
        while(true){
            atm.displayMenu();
            System.out.print("\nSelect the following Options ");
            int ch=sc.nextInt();
            atm.transaction(ch,sc);
        }
    }
    
} 