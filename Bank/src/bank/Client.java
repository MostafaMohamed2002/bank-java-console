
package bank;


public class Client {
private final String frist_name_client;
private final String last_name_client;
private static int user_id = 1000;
private final String phone_number_client;
private final int id;
private double balance_client;
public static double maxAmount;
public static Client acountTransfer;
public static Client acountRecipient;

public Client(String frist_name_client, String last_name_client, String phone_number_client){
    this.frist_name_client = frist_name_client;
    this.last_name_client = last_name_client;
    this.phone_number_client = phone_number_client;
    this.balance_client = 0.0;
    user_id++;
    this.id = user_id;
}
//METHODS GETERS
        public String get_first_name(){
            return this.frist_name_client + "";
        }
        public String get_last_name(){
            return this.last_name_client + "";
        }
        public double get_balance_client(){
            return this.balance_client;
        }
        public void set_balance_client(double current_balance) {
            this.balance_client = current_balance;
        }
        public int get_user_id(){
            return this.id;
        }
        public String get_phone_number(){
            return this.phone_number_client + "";
        }
    //Method to deposit money (Client Service)
    public void deposit_money(double deposit_money){
        this.balance_client += deposit_money;
        System.out.println("Deposit money is =  " +deposit_money +" in your account." + "\n" +
                "Balance of your account after deposit is now: " +this.balance_client);
    }
    //Method to withdrawal money (Client service)
    public void withdrawal_money(double withdrawal_money){
        if(this.balance_client < withdrawal_money) {
            System.out.println("Dear customer you don't has enough money to withdrawal this money.");
        } else {
            this.balance_client -= withdrawal_money;
            System.out.println("Withdrawal amount is = " +withdrawal_money + " from yor account." + "\n" +
                        "Balance of your account after Withdrawal is : " +this.balance_client);
        }
    }
    //Method to transactions money transfer from client to client (Client Services)
    public void money_transaction(Client client_sender, Client client_rec, double money_cash){
        if(client_sender.get_balance_client() > 0) {
            client_rec.set_balance_client(client_rec.balance_client += money_cash);
            client_sender.set_balance_client(this.balance_client -= money_cash);
           
        } else {
            System.out.println("Dea customer you don't have enough balance to transfer field transaction.");
        }
    }
    public void setDataOfMaxTransaction(Client sender,Client recieve,double max_amount){
        if(max_amount>maxAmount){
    acountTransfer = sender;
    acountRecipient = recieve;
    maxAmount = max_amount;}
    }
    //Method to print all client details.......
    @Override
    public String toString(){
        return "Frist Name: " + get_first_name() + "\n" +
                "Last name: " +get_last_name() +"\n" +
                "Balance: " + get_balance_client() + "\n" +
                "ID: " + get_user_id();
    }
}
