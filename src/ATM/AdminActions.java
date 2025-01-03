package ATM;

import java.util.ArrayList;
import java.util.Scanner;


    public class AdminActions {

            public static Admin adminLogin(Scanner sc, ArrayList<Admin> adminList) {
            int attempts = 0;
            while (attempts < 3) {
                System.out.print("Enter Admin Username: ");
                String adminUsername = sc.nextLine();

                boolean usernameExists = false;
                for (Admin admin : adminList) {
                    if (admin.getAdminName().equals(adminUsername)) {
                        usernameExists = true;
                        break;
                    }
                }
                if (!usernameExists) {
                    System.out.println("Invalid username, username not found");
                    return null;
                }

                System.out.print("Enter Admin Password: ");
                int password = Integer.parseInt(sc.nextLine());

                for (Admin admin : adminList) {
                    if (admin.getAdminName().equals(adminUsername) && admin.getAdminPin() == password) {
                        System.out.println("Login successful!");
                        return admin;
                    }
                }
                attempts++;
                System.out.println("Invalid credentials. Try again.");
            }
            System.out.println("attempt finished");
            return null;
            }



            public void addUserAccount (Scanner sc){
                System.out.print("Enter new username: ");
                String username = sc.nextLine();
                for (User user : ATM.getUserAcc()) {
                    if (user.getUsername().equals(username)) {
                        System.out.println("User is already Exist.....Enter the newusername");
                        return;
                    }
                }
                System.out.print("Enter new password: ");
                int password = Integer.parseInt(sc.nextLine());
                User newUser = new User(username, password);

                ATM.getUserAcc().add(newUser);
                System.out.println("User account added.");
            }

            public void deleteUserAccount (String usernameToDelete){
                User userToDelete = null;
                for (User user : ATM.getUserAcc()) {
                    if (user.getUsername().equals(usernameToDelete)) {
                        userToDelete = user;
                        break;
                    }
                }
                if (userToDelete != null) {
                    ATM.getUserAcc().remove(userToDelete);
                    System.out.println("User account deleted.");
                } else {
                    System.out.println("User not found.");
                }
            }

            public void viewUserList () {
                if (ATM.getUserAcc().isEmpty()) {
                    System.out.println("No users available.");
                } else {
                    for (User user : ATM.getUserAcc()) {
                        System.out.println("User Name :" + user.getUsername() + " | Balance :" + user.getBalance());
                    }
                }
            }

            public void viewTransactionHistory (Admin admin){
             if (admin.getAdminTransactionHistory().isEmpty()) {
                            System.out.println("No Admin transactions found.");
                        } else {
                            System.out.println("Admin Transaction History:");
                            for (Transfer transfer : admin.getAdminTransactionHistory()) {
                                System.out.println(transfer);
                            }
                        }
            }

            public void viewTransactions(Scanner sc) {
                System.out.print("Enter the username of the user: ");
                String username = sc.nextLine();

                ArrayList<User> userList = ATM.getUserAcc();
                User user = null;

                for (User u : userList) {
                    if (u.getUsername().equals(username)) {
                        user = u;
                        break;
                    }
                }

                if (user == null) {
                    System.out.println("User not found!");
                } else {
                    ArrayList<Transfer> userTransactions = user.getTransactions();
                    if (userTransactions.isEmpty()) {
                        System.out.println("No transactions found for user: " + username);
                    } else {
                        System.out.println("Transaction History for user: " + username);
                        for (Transfer transfer : userTransactions) {
                            System.out.println(transfer);
                        }
                    }
                }
            }

            public void adminDeposit ( int deposit, Scanner sc, Admin admin){

                System.out.print("2000=");
                int tk = Integer.parseInt(sc.nextLine());
                System.out.print("500=");
                int f = Integer.parseInt(sc.nextLine());
                System.out.print("200=");
                int t = Integer.parseInt(sc.nextLine());
                System.out.print("100=");
                int o = Integer.parseInt(sc.nextLine());

                int t2000 = 2000 * tk;
                int f500 = 500 * f;
                int t200 = 200 * t;
                int o100 = 100 * o;

                int total = t2000 + f500 + t200 + o100;
                if (deposit == total) {
//            ArrayList<Notes> notesArrayList = ATM.getNotesArrayList();
                    for (Notes note : ATM.getNotesArrayList()) {
                        int notetype = note.getDenomination();
                        switch (notetype) {
                            case 2000:
                                note.setNote(note.getNote() + tk);
                            case 500:
                                note.setNote(note.getNote() + f);
                            case 200:
                                note.setNote(note.getNote() + t);
                            case 100:
                                note.setNote(note.getNote() + o);
                        }
                    }

                    ATM.setBalance(ATM.getbalance() + deposit);
//                    Transfer depositTransfer = new Transfer(admin.getAdminName(), "Admin Deposit", deposit);
//                    addTransaction(depositTransfer, admin);
                    admin.getAdminTransactionHistory().add(new Transfer(admin.getAdminName(), "Deposit", deposit));
                    ATM.getAlltransactions().add(new Transfer(admin.getAdminName(), "Deposit", deposit));
                    System.out.println("Deposit successful. New balance: " + ATM.getBalance());
                } else {
                    System.out.println("Denominations doesn't matching...!\n Please enter the real value");
                }
            }

            public void viewtrahis (Scanner sc, Admin admin)
            {

                System.out.println("\nSelect an option:");
                System.out.println("1.  Admin transaction history");
                System.out.println("2.  User transaction history");
                System.out.println("3. All transaction history");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        viewTransactionHistory(admin);
                        break;

                    case 2:

                        viewTransactions(sc);
                        break;

                    case 3:
                        if (ATM.getAlltransactions().isEmpty()) {
                            System.out.println("Not found all the transaction history.");
                        } else {
                            System.out.println("Global Transaction History:");
                            for (Transfer transfer : ATM.getAlltransactions()) {
                                System.out.println(transfer);
                            }
                        }break;

                    default:
                        System.out.println("Invalid choice, please enter the valid choice.");
                }
            }


//        public void addTransaction(Transfer withdrawTransfer, Admin admin) {
//            admin.getTransactionHistory().add(withdrawTransfer);
//
//        }

    }