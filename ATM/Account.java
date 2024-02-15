package ATM;

import java.util.ArrayList;

public class Account {
    // account name
    private String name;
    // account balance
    private int balance;
    // account ID
    private String uuid;
    // the user that own this account
    private User holder;
    // the list of transaction for this account
    private ArrayList<Transaction> transactions;
    public Account(String name, User holder, Bank theBank){
        this.name=name;
        this.balance=0;
        this.holder=holder;
        this.uuid=theBank.getNewAccountUUID();
        holder.addAccount(this);
        theBank.addAccount(this);
    }

    /**
     *
     * @return the uuid of the user
     */
    public String getUUID(){
        return this.uuid;
    }
}
