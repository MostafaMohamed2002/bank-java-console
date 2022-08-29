
package bank;


import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
    Bank_sys bank = new Bank_sys();
    boolean exitRequested = false;
    while(!exitRequested) {
        Bank_sys.bank_display_tools();
        int choice = Integer.parseInt(sc.next());
        switch (choice) {
            case 1:
                bank.create_account();
                break;
            case 2:
                bank.get_acc();
                break;
            case 3: bank.display_max_transaction();
            break;
            case 4:
                exitRequested = true;
                break;
            default:
                System.out.println("invailed input. ");
                break;
        }
        bank.createFile("accountsANDtransactions.txt", bank.bankAccounts, bank.TransactionOperationsList);
    }
    }
    
}
