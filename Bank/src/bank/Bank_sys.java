
package bank;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Bank_sys {
    public final List<Client> bankAccounts;
    public final List<TransactionsData> TransactionOperationsList;

private final Scanner sc;

public Bank_sys() {
    bankAccounts = new ArrayList<>();
    TransactionOperationsList = new ArrayList<>();
    sc = new Scanner(System.in);
}

public Client search_accounts(int accountID, String phoneNumber) {
    for (Client account : bankAccounts) {
        if (account.get_user_id() == accountID && account.get_phone_number().equals(phoneNumber)) {
            return account;
        }
    }
    System.out.println("One of the data entered has something wrong");
    return null;
}

//overload method -
public Client search_accounts(String phoneNumber) {
    for (Client account : bankAccounts) {
        if (account.get_phone_number().equals(phoneNumber)) {
            return account;
        }
    }
    System.out.println("One of the details is incorrect");
    return null;
}

public void create_account() {
    System.out.println("Please enter your frist name : ");
    String firstName = sc.next();
    System.out.println("Please enter your last name :");
    String lastName = sc.next();
    System.out.println("Please enter your phone number :");
    String phoneNumber = sc.next();
    for(Client account : bankAccounts){
    if(account.get_phone_number().equals(phoneNumber)){
    System.out.println("Account is already found");
    System.out.println("Please enter another phone number to continue register");
     phoneNumber = sc.next();
    }
    }
    if (is_phone_number(phoneNumber)) {
        bankAccounts.add(new Client(firstName, lastName, phoneNumber));
        System.out.println("You have created account successfully!" + "\n" +
                "Your account ID is: " + bankAccounts.get(bankAccounts.size() - 1).get_user_id());

    }
}

public void get_acc() {
    System.out.println("Please enter your ID:");
    int accountID = sc.nextInt();
    System.out.println("Please enter your phone number:");
    String phoneNumber = sc.next();
    if (is_phone_number(phoneNumber)) {
        Client selectedAccount = search_accounts(accountID, phoneNumber);
        boolean exitRequested = false;
        while (!exitRequested) {
            account_display_tools();
            int choice = Integer.parseInt(sc.next());
            switch (choice) {
                case 1:
                    System.out.println(selectedAccount.toString());
                    break;
                case 2:
                    System.out.println("Please enter deposit amount:");
                    double depositAmount = sc.nextDouble();
                    selectedAccount.deposit_money(depositAmount);
                    Date DateOfDeopsit = new Date();
                 TransactionOperationsList.add(new TransactionsData(selectedAccount,null, DateOfDeopsit , "DEPOSIT OPERATION ", depositAmount, true));

                    break;
                case 3:
                    System.out.println("Please enter withdrawal amount:");
                    double withdrawalAmount = sc.nextDouble();
                    selectedAccount.withdrawal_money(withdrawalAmount);
                      Date DateOfWithdrawal = new Date();
                   TransactionOperationsList.add(new TransactionsData(selectedAccount,null, DateOfWithdrawal, "WithdrawalAmount ", withdrawalAmount, true));
                    break;
                case 4:
                    System.out.println("Please enter the phone number of the account you want to transfer to: ");
                    String accountPhoneNumber = sc.next();
                    if (is_phone_number(accountPhoneNumber)) {
                        Client accountToTransfer = search_accounts(accountPhoneNumber);
                        System.out.println("Enter the amount of money you would like to transfer:");
                        double moneyToTransfer = sc.nextDouble();
                        selectedAccount.money_transaction(selectedAccount, accountToTransfer, moneyToTransfer);
                        selectedAccount.setDataOfMaxTransaction(selectedAccount, accountToTransfer, moneyToTransfer);
                                              Date DateOftransfer = new Date();

                        TransactionOperationsList.add(new TransactionsData(selectedAccount,accountToTransfer, DateOftransfer, "Transfer money ", moneyToTransfer, true));
                        break;
                    }
                        case 5:
                            exitRequested = true;
                            break;
                        default:
                            System.out.println("Wrong input");
                            break;
                    }
            }
        }
    }

public static boolean is_phone_number(String phoneNumber){
    if(phoneNumber.length() != 11){
        System.out.println("Phone number must be 11 digits.");
        return false;

} else {
        return true;
    }
}
public void display_max_transaction(){
    if(Client.maxAmount==0.0){
        System.out.println("Don't found any transactions because transactions not occurs");
    } else{
    System.out.println("this client"+Client.acountTransfer+"\n" 
                +"send max amount " + Client.maxAmount + "\n"+ 
                   " to this client " + Client.acountRecipient + "\n" + Client.acountRecipient);
    }
    }
public static void bank_display_tools() {
    System.out.println("Customer,please press: ");
    System.out.println("----------------------------");

    System.out.println("1.Create Account. ");
    System.out.println("----------------------------");

    System.out.println( "2.sign in. ");
    System.out.println("----------------------------");

    System.out.println("3.Display biggest money transfer between 2 clients. ");
    System.out.println("----------------------------");
    System.out.println(  "4.Exit.");          
    System.out.println("----------------------------");
}

public static void account_display_tools(){
    System.out.println("What would you like to do dear coustomer?" );
    System.out.println("----------------------------");
    System.out.println("----------------------------");

    System.out.println("1.Display INFORMATION." );
    System.out.println("----------------------------");

    System.out.println("2.Select to Deposit money." );
    System.out.println("----------------------------");

    System.out.println( "3.Select to Withdrawal money."  );
    System.out.println("----------------------------");

    System.out.println("4.Select to transfer money to another account."  );
    System.out.println("----------------------------");
    System.out.println("5.Select to Exit");
    
                  
                
                
                 
                
}
public void createFile(String fileName,List Accounts,List TransOperations){
            try{
                PrintWriter w = new PrintWriter(fileName);
               w.println("--------------Data of All accounts-----------");
               Accounts.forEach(s -> {
                    w.println("------------");
                    w.println(s);
                    w.println("------------");
               });
                w.println("-----------All Transactions occurs-----------------");

               TransOperations.forEach(s -> {
               w.println("------------");
                w.println(s);
               w.println("------------");
                });
               
                
                w.close();
            }catch(FileNotFoundException e){
            System.out.print(e);
            }
        
        }
}
