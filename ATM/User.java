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
        theBank.addUser(this);


    }

    /**
     *
     * @param account add to the user accounts list
     */
    public void addAccount(Account account){
        this.accounts.add(account);
    }

    /**
     *
     * @return the UUID of the user
     */
     public String getUUID(){
        return this.UUID;
     }

}
