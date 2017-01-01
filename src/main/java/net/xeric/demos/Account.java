package net.xeric.demos;

/**
 * Created by markshead on 12/31/16.
 */
public class Account {
    private int balance;
    private String type;
    private String owner;

    public Account(int balance, String type, String owner) {
        setBalance(balance);
        setType(type);
        setOwner(owner);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
