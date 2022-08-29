
package bank;

import java.util.Date;


public class TransactionsData {
    private final Client sender;
    private final Client reciver;
    private final Date dateOfTransactions;
    private final String typeOfTransactions;
    private final double amount;
    private final boolean StatusOfOperation;

    public TransactionsData(Client sender, Client reciver, Date dateOfTransactions, String typeOfTransactions, double amount, boolean StatusOfOperation) {
        this.sender = sender;
        this.reciver = reciver;
        this.dateOfTransactions = dateOfTransactions;
        this.typeOfTransactions = typeOfTransactions;
        this.amount = amount;
        this.StatusOfOperation = StatusOfOperation;
    }

    public Client getSender() {
        return sender;
    }

    public Client getReciver() {
        return reciver;
    }

    public Date getDateOfTransactions() {
        return dateOfTransactions;
    }

    public String getTypeOfTransactions() {
        return typeOfTransactions;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isStatusOfOperation() {
        return StatusOfOperation;
    }

    @Override
    public String toString() {
        return "TransactionsData{" + "sender=" + sender + ", reciver=" + reciver + ", dateOfTransactions=" + dateOfTransactions + ", typeOfTransactions=" + typeOfTransactions + ", amount=" + amount + ", StatusOfOperation=" + StatusOfOperation + '}';
    }
    
}
