package ATM;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;

public class User {
    // First name of the user
    private  String firstName;
    // Second name of the user
    private String lastName;
    // Unique universal id
    private String UUID;
    // pin of the account
    private byte[] pinHash;
    // accounts that user have
    private ArrayList<Account> accounts;

    /**
     * create a new user
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param theBank the bank that the user is a customer of
     * @param pin the password of user account
     */

    public User(String firstName, String lastName,Bank theBank,String pin){
        // set the first name
        this.firstName=firstName;
        // set the second name
        this.lastName=lastName;
        // store pin's MD5 hash rather than the original value for security reasons
        try {
            MessageDigest md =MessageDigest.getInstance("MD5");
            this.pinHash=md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
           System.err.println("error , caught NoSuchAlgorithmException");
           System.exit(0);
        }
        // create empty list of accounts
        this.accounts = new ArrayList<>();
        // git a new unique universal ID for the user
        this.UUID = theBank.getNewUserUUID();
        // successful registration massage
        System.out.printf("New user %s %s with ID %s created .\n",firstName ,lastName,UUID);


    }

    /**
     *
     * @param account added for user accounts
     */
    public  void addAccount(Account account){
        this.accounts.add(account);
    }

    /**
     *
     * @return UUID for the user
     */

     public String getUUID(){
        return this.UUID;
     }

    /**
     *
     * @return full name of the user
     */
     public String getName(){
         return this.firstName+" "+this.lastName;
     }

    /**
     * Validate login
     * @param pin password of the user
     * @return true if the pin is true and otherwise
     */
     public boolean validateUser(String pin){
         try {
             MessageDigest md = MessageDigest.getInstance("MD5");
             return MessageDigest.isEqual(md.digest(pin.getBytes()),this.pinHash);

         } catch (NoSuchAlgorithmException e) {
             System.err.println("error , caught NoSuchAlgorithmException");
             System.exit(0);

         }
         return false;
     }

    /**
     * print summary of user's accounts
     */
    public void printAccountsSummary(){
        for (int i=0 ; i<this.accounts.size();i++){
            System.out.print((i+1)+")");
            this.accounts.get(i).getSummary();
        }

     }

    /**
     * get first name of the user
     * @return first name
     */
     public String getFirstName(){
        return this.firstName;
     }

    /**
     * get the balance of account
     * @param uuid the uuid of the account
     * @return balance if uuid is true and -1 if the uuid is false
     */
     public int getBalance(String uuid){
         for (Account account : accounts){
             if (account.getUUID().compareTo(uuid)==0)return account.getBalance();
         }
         System.out.println("Invalid ID , Please try again");
         return -1;
     }

    /**
     * get the number of total account that user own
     * @return the number of accounts
     */
     public int getAccountsNumber(){
         return this.accounts.size();
     }

    /**
     * print the account transaction history
     * @param acctNum index of the account
     */
     public void printAcctTransHistory(int acctNum){
         this.accounts.get(acctNum-1).printTransHistory();
     }

    /**
     * get the balance of an account
     * @param accountNum the number of the account
     * @return the balance
     */
     public double getAccountBalance(int accountNum){
         return accounts.get(accountNum-1).getBalance();
     }

    /**
     * get the UUID of an account
     * @param acctNum the index of the account
     * @return the UUID
     */
     public String getAccountUUID(int acctNum){
         return this.accounts.get(acctNum).getUUID();
     }

    /**
     * add new transaction to the account
     * @param accountNum index of the account
     * @param amount the amount of money
     * @param memo details of transaction
     */
     public void addAccountTransaction(int accountNum, double amount , String memo){
         this.accounts.get(accountNum-1).addTransaction(amount,memo);
     }


}
