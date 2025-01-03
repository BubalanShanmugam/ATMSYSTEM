package ATM;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

    public class UserActions {


        public UserActions(User user) {
            super();
        }


        public static User userLogin(Scanner sc,ArrayList<User>users) throws CloneNotSupportedException {

            int attempts = 0;
            while (attempts < 3) {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();
            System.out.print("Enter Admin Password: ");
            int password = Integer.parseInt(sc.nextLine());

                for (User user : users) {
                    if (user.getUsername().equals(username) && user.getPassword() == password) {
                        System.out.println("Login successful!");
                        return user;
                    }
                }
                attempts++;
                System.out.println("Invalid credentials. Try again.");
            }
            System.out.println("ATTEMPT FINISHED!.. User not found.");
            return null;
        }



        public void deposit(double amount, Scanner sc,User user) {
            System.out.print("2000=");
            int tk=Integer.parseInt(sc.nextLine());
            System.out.print("500=");
            int f=Integer.parseInt(sc.nextLine());
            System.out.print("200=");
            int t=Integer.parseInt(sc.nextLine());
            System.out.print("100=");
            int o=Integer.parseInt(sc.nextLine());

            int t2000= 2000*tk;
            int f500= 500*f;
            int t200=200*t;
            int o100=100*o;

            int total = t2000+f500+t200+o100;
            if(amount==total){
                ArrayList<Notes> notesArrayList= ATM.getNotesArrayList();
                for( Notes note: ATM.getNotesArrayList()){
                    int notetype = note.getDenomination();
                    switch (notetype) {
                        case 2000:
                            note.setNote(note.getNote() + tk);
                           // System.out.println("hgchd");
                        case 500:
                            note.setNote(note.getNote() + f);
                        case 200:
                            note.setNote(note.getNote() + t);
                        case 100:
                            note.setNote(note.getNote() + o);
                    }
                }
                user.setBalance(user.getbalance()+ amount);
                System.out.println("Deposit successful. New balance: " + user.getBalance());

                user.getTransactions().add(new Transfer(user.getUsername(), "Deposit", amount));
                ATM.getAlltransactions().add(new Transfer(user.getUsername(), "Deposit", amount));
            }
            else{
                System.out.println("Denominations are mismatching...!PLease enter the valid Denominations");
            }
        }

        public static double performwithdraw(double amount, Notes notes, ArrayList<String> statement) {
            int count = (int)amount / notes.getDenomination();
            if (notes.getDenomination() <= amount && count <= notes.getNote())
            {
                amount -= (count * notes.getDenomination());

                statement.add("Note :"+notes.getDenomination() +" | Count: " + String.valueOf(count));
                notes.setNote((notes.getNote() - count));
                return amount;
            }
            return amount;
        }
        public void withdraw(double amount,User user) throws CloneNotSupportedException {
            if (user.getBalance() >= amount) {
                double amount1 = amount;
                ArrayList<String> statement = new ArrayList<String>();
                ArrayList<Notes> duplicatenotes = new ArrayList<Notes>();
                for (Notes notes : ATM.getNotesArrayList()) {
                    duplicatenotes.add(notes.clone());
                }
                x:
                while (amount != 0) {
                    for (Notes notesinduplicate : duplicatenotes) {
                        int type = notesinduplicate.getDenomination();
                        switch (type) {
                            case 2000, 500, 200, 100:
                                amount = (int) UserActions.performwithdraw(amount, notesinduplicate, statement);
                                break;
                        }
                    }
                    if (amount == 0) {
                        ATM.setNotesArrayList(duplicatenotes);
                        user.setBalance(user.getBalance() - amount1);
                        user.getTransactions().add(new Transfer(user.getUsername(), "Withdraw", amount1));
                        ATM.getAlltransactions().add(new Transfer(user.getUsername(), "Withdraw", amount1));
//                        Transfer withdrawTransfer = new Transfer(user.getUsername(), "Withdraw", amount1);
//                        addTransaction(withdrawTransfer,ATM.getTransactionHistory());
                        System.out.println("Withdrawal successful. Current Balance: " + user.getBalance());
                        for (String s : statement) {
                            System.out.println("Withdrawl Denominations :" + s);
                        }
                        break;
                    } else {
                        System.out.println("Denominations are not available,Enter another amount...");
                        break;
                    }

                }
            }


            else
            {
                System.out.println("Insufficient balance.");
            }
        }

        public double viewBalance(User user) {
            return user.getBalance();
        }

        public void viewTransactionHistory(User user) {
            ArrayList<Transfer> transactions = user.getTransactions();
            if (transactions.isEmpty()) {
                System.out.println("No transaction history available.");
            } else {
                System.out.println("\nTransaction History:");
                for (Transfer transfer : transactions) {
                    System.out.println(transfer);
                }
            }
        }

        public void changePassword(int currentPassword, User user,Scanner sc) {
            if(currentPassword != user.getPassword()){
                System.out.println(" password was mismatching...!Please try later with valid current PIN");

            }else {
                System.out.print("Enter new password: ");
                int newPassword = Integer.parseInt(sc.nextLine());

                    user.setPassword(newPassword);
                    System.out.println("Password changed successfully.");
            }

        }
        public void addTransaction(Transfer transfer,ArrayList<Transfer> transactions ){
            transactions.add(transfer);
        }

    }




