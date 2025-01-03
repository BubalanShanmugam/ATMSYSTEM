package ATM;

public class Transfer {
    private String username;
    private String type;
    private double amount;

    public Transfer(String username, String type, double amount) {
        this.username = username;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Name: " + username + " | Transaction: " + type + " | Amount: " + amount+"\n\t\t";
    }
}
