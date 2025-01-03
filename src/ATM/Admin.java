package ATM;

import java.util.ArrayList;

public class Admin {
    private  String adminName;
    private  int adminPin;
    private ArrayList<Transfer> admintransactionHistory = new ArrayList<Transfer>();
    public ArrayList<Transfer> getAdminTransactionHistory() {
        return admintransactionHistory;
    }


//    public  void setAdminPin(int adminPin) {
//        this.adminPin = adminPin;
//    }
//
//    public  void setAdminName(String adminName) {
//        this.adminName = adminName;
//    }



    public Admin(String adminName, int adminPin) {
        this.adminName = adminName;
        this.adminPin = adminPin;
    }

    public  String getAdminName() {
        return adminName;
    }

    public  int getAdminPin() {
        return adminPin;
    }

}
