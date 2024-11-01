package simulatedBank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimulateBank{
    public static void main(String[] args){
        SimulateBank simulador = new SimulateBank();
        simulador.menu();
    }

Map<String, AccountBank> cuentas;
   private Scanner scanner;

   public SimulateBank(){
       cuentas= new HashMap<>();
       scanner= new Scanner(System.in);
   }

   public void createAccount(){

    System.out.println("enter the account number:");
    String numberAccount = scanner.next();

    System.out.println("enter the name of the owner:");
    String titular  = scanner.next();

    System.out.println("enter the opening balance:");
        double saldo = scanner.nextDouble();
        AccountBank cuenta = new AccountBank(numberAccount, titular, saldo );
        cuentas.put(numberAccount, cuenta);
        System.out.println("cuentaa:"+cuentas.get(numberAccount));
     System.out.println("account created successfully:");

   }

   public void deposit(){
     System.out.println("enter the account number:");
    String numberAccount = scanner.next();

    if(cuentas.containsKey(numberAccount)){
        System.out.println("Enter of Amount:");
        double quantity = scanner.nextDouble();

        AccountBank cuenta = cuentas.get(numberAccount);
             cuenta.depositSaldo(quantity);
       System.out.println("Deposit made successfully:");
    }else{
        System.out.println("Invalid Account...");
    }
   }

   public void withdraw(){
    System.out.println("Enter of Number of Account");
    String numberAccount = scanner.next();
    if(cuentas.containsKey(numberAccount)){
       System.out.println("Enter of Amount");
    double quantity = scanner.nextDouble();

        AccountBank cuenta = cuentas.get(numberAccount);
        cuenta.withdrawSaldo(quantity);

        System.out.println("withdrawal made...");
    }else{
        System.out.println("Invalid Account");
    }

   } 
   public void querySaldo(){
         System.out.println("Enter of number od Account");
         String numberAccount = scanner.next();

         if(cuentas.containsKey(numberAccount)){
            AccountBank cuenta = cuentas.get(numberAccount);
            System.out.println("your saldo is:"+cuenta.getSaldo());
         }else{
            System.out.println("Invalid account");
         }
   }

   public void menu(){
    while(true){
    System.out.println("1.- Create Account");
    System.out.println("2.- Deposit");
    System.out.println("3.- withdraw");
    System.out.println("4.- Saldo");

    System.out.println("choose an option...");
     String option = scanner.next();
      
      switch(option){
        case "1":
            this.createAccount();
            break;
        case "2":
            this.deposit();
            break;
        case "3":
            this.withdraw();
            break;
        case "4":
            this.querySaldo();
            break;
        default:
            System.out.println("Invalid option");
       }      
     }
   }
}

public class AccountBank{
    private String numberAccount;
    private String titular;
    private double saldo;
 
 public AccountBank(String numberAccount, String titular, double saldo){
 this.numberAccount = numberAccount;
 this.titular = titular;
 this.saldo = saldo;
 }
 
 @Override
 public String toString() {
     return "AccountBank{" +
             "numberAccount='" + numberAccount + '\'' +
             ", titular='" + titular + '\'' +
             ", saldo=" + saldo +
             '}';
 }
 
 public String getnumberAccount(){
    return numberAccount;
 }
 
 public String gettitular(){
    return titular;
 }
 public double getSaldo(){
    return saldo;
 }
 
 public void depositSaldo(double quantity){
     saldo += quantity;
 }
 public void withdrawSaldo(double quantity){
    if(quantity <= saldo){
        saldo -= quantity;
    }else{
       System.out.println("invalid withdraw");
    }
 }
 }