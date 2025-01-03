package ATM;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class ATMActions {

    public static void start() throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);
        AdminActions adminActions = new AdminActions();

        ATM.getAdminList().add(new Admin("admin", 1234));
        ATM.getAdminList().add(new Admin("admin2", 5678));
//        System.out.println(ATM.getAdminList());

        while (true) {
            System.out.println("\nSystem Menu:");
            System.out.println("1. Admin Login \n2.User Login \n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1)
            {
                Admin a = AdminActions.adminLogin(sc,ATM.getAdminList());
                if (a !=null) {
                    adminMenu(sc, adminActions,a);
                }

            } else if (choice == 2)
            {
               User user = UserActions.userLogin(sc,ATM.getUserAcc());
                if (user != null) {
                    userMenu(sc,user);
                }
            } else if (choice == 3)
            {
                System.out.println("Exiting the ATM system...");
                break;
            } else
            {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void adminMenu(Scanner sc, AdminActions adminActions,Admin admin) {
        boolean exitAdmin = false;
        while (!exitAdmin) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add user \n2. Delete user \n3. View transaction history \n4. View user list \n5. Admin Deposit \n6. View your balance \n 7.Admin Transaction \n8. Exit");
            int adminChoice = Integer.parseInt(sc.nextLine());

            switch (adminChoice) {
                case 1:
                    adminActions.addUserAccount(sc);
                    break;
                case 2:
                    System.out.print("Enter username to delete: ");
                    String usernameToDelete = sc.nextLine();
                    adminActions.deleteUserAccount(usernameToDelete);
                    break;
//                case 3:
//                    System.out.println("Enter Your Choice : \n USER / ADMIN");
//                    String name = sc.nextLine();
//                    if(name.equalsIgnoreCase("USER")){
//                        System.out.print("Enter username to view transaction history: ");
//                        String username = sc.nextLine();
//                        adminActions.viewTransactionHistory(username);
//                    }
//                    else{
//
//                        System.out.print("Transaction History :");
//                        adminActions.viewtrahis(transfer);
//                    }
//
//                    break;
                case 4:
                    adminActions.viewUserList();
                    break;
                case 5:
                    System.out.println("Enter the total amount to deposit:");
                    int deposit = Integer.parseInt(sc.nextLine());
                    adminActions.adminDeposit(deposit,sc,admin);
                    break;
                case 6:
                    System.out.println("ATM Balance:"+ ATM.getBalance());
                    break;
                case 7:
                    System.out.print("Transaction History :");
                    adminActions.viewtrahis(sc,admin);
                    break;

                case 8:
                    exitAdmin = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void userMenu(Scanner sc,User user) throws CloneNotSupportedException {
        UserActions userActions= new UserActions(user);
        boolean exitUserMenu = false;
        while (!exitUserMenu) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int userChoice = Integer.parseInt(sc.nextLine());

            switch (userChoice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = Double.parseDouble(sc.nextLine());
//                    System.out.print("Enter denomination (e.g., 100, 200, 500, 2000): ");
//                    int depositDenomination = Integer.parseInt(sc.nextLine());
                    userActions.deposit(depositAmount,sc,user);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = Double.parseDouble(sc.nextLine());
//                    System.out.print("Enter denomination (e.g., 100, 200, 500, 2000): ");
//                    int withdrawDenomination = Integer.parseInt(sc.nextLine());
                    userActions.withdraw(withdrawAmount,user);
                    break;
                case 3:
                    System.out.println("Your balance: " + userActions.viewBalance(user));
                    break;
                case 4:
                    userActions.viewTransactionHistory(user);
                    break;
                case 5:
                    System.out.print("Enter current password: ");
                    int currentPassword = Integer.parseInt(sc.nextLine());

                    userActions.changePassword(currentPassword,user,sc);
                    break;
                case 6:
                    System.out.println("User logged out.");
                    exitUserMenu = true;
                    break ;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


}
