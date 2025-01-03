package ATM;

import java.util.ArrayList;

public class User {
    protected User user;
    private String username;
    private int password;
    private double balance;
    private ArrayList<Transfer> transactions;

    public User(String username, int password) {
        this.username = username;
        this.password = password;
        this.balance = 0;
        this.transactions=new ArrayList<Transfer>();
    }

    public User(User user) {
        this.user = user;
    }


    public String getUsername() {
        return username;
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public int setBalance(double balance) {
        this.balance = balance;
        return 0;
    }

    public ArrayList<Transfer> getTransactions() {
        return transactions ;
    }

//    public void setTransactionHistory(ArrayList<ATM.Transfer> transactionHistory) {
//        this.transactionHistory = transactionHistory;
//    }

    public double getbalance() {
        return balance;
    }



}
