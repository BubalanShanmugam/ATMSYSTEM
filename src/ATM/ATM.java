package ATM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class ATM {
    private static ArrayList<User> userAcc = new ArrayList<>();
    private static ArrayList<Admin> adminList = new ArrayList<Admin>();
    private static double balance;
//    private static ArrayList<Transfer> transactionHistory = new ArrayList<Transfer>();
    private static ArrayList<Notes> notesArrayList =new ArrayList<>(Arrays.asList( new Twoo(2000,0,0),  new Five(500,0,0), new Two(200,0,0),new One(100,0,0)));

    public static ArrayList<Transfer> getAlltransactions() {
        return alltransactions;
    }

    private static ArrayList<Transfer> alltransactions = new ArrayList<>() ;
    public static ArrayList<Notes> getNotesArrayList() {
        return notesArrayList;
    }

//    public static ArrayList<Admin> getAdminList() {
//        return adminList;
//    }

    public static void setNotesArrayList(ArrayList<Notes> notesArrayList) {
        ATM.notesArrayList = notesArrayList;
    }

    public static void setUserAcc(ArrayList<User> userAcc) {
        ATM.userAcc = userAcc;
    }

    public static ArrayList<User> getUserAcc() {
        return userAcc;
    }

    public static void setBalance(double balance) {
        ATM.balance = balance;
    }

    public static double getBalance() {
        return balance;
    }

    public static double getbalance() {
        return balance;
    }


//
//    public void setTransactionHistory(ArrayList<Transfer> transactionHistory) {
//        this.transactionHistory = transactionHistory;
    public static void addTransaction(Transfer transfer,ArrayList<Transfer> transactionHistory ){
        transactionHistory.add(transfer);
    }

    public static ArrayList<Admin> getAdminList() {
        return adminList;
    }
}
