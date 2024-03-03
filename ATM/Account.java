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
        System.out.printf("Account %s for %s created\n",name,holder.getName());
    }

    /**
     *
     * @return the uuid of the user
     */
    public String getUUID(){
        return this.uuid;
    }

    /**
     * print the summary of the account
     * now print the type only in the feature may print more information
     */
    public void getSummary(){

        System.out.println("-"+ getName());
    }

    /**
     *
     * @return type of the account
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @return  the balance of the account
     */
    public int getBalance(){
       return this.balance;
    }

    /**
     * print transactions history of the account
     */
    public void printTransHistory(){
        for (int i=0;i<this.transactions.size();i++){
            System.out.println(this.transactions.get(i).getSummaryLine());
        }
    }

    /**
     * add new transaction  and update the total balance
     * @param amount the amount of money
     * @param memo the details of the transaction
     */
    public void addTransaction(double amount , String memo){
        Transaction newTransaction = new Transaction(amount,memo,this);
        this.transactions.add(newTransaction);
        this.balance+= (int) amount;
    }

}
