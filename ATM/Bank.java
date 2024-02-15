package ATM;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    // the name of the bank
    private String name;
    // users of this bank
    private ArrayList<User> users;
    // accounts in this bank
    private ArrayList<Account> accounts;
    // generate new UUID for the user
    public String getNewUserUUID(){
        // initialize
        String uuid;
        Random rng = new Random();
        // length of the uuid
        int len = 6 ;
        // flag to generate uniq uuid
        boolean nonUnique;
        do {
            uuid = "";
            for (int i=0;i<len;i++){
                /**
                 * generate random number between 0 and 9 and then convert it to
                 * string to concat it with the uuid
                 */
                uuid+=((Integer)rng.nextInt(10)).toString();
            }
            nonUnique=false;
            // check if it uniq or not
            for (User user : users){
                if (user.getUUID().compareTo(uuid)==0)nonUnique=true;
                else break;
            }

        } while (nonUnique);
        return uuid;


    }

    /**
     *
     * @return new uuid for the account
     */
    public  String getNewAccountUUID(){
        // initialize
        String uuid;
        Random rng = new Random();
        // length of the uuid
        int len = 10 ;
        // flag to generate uniq uuid
        boolean nonUnique;
        do {
            uuid = "";
            for (int i=0;i<len;i++){
                /**
                 * generate random number between 0 and 9 and then convert it to
                 * string to concat it with the uuid
                 */
                uuid+=((Integer)rng.nextInt(10)).toString();
            }
            nonUnique=false;
            // check if it uniq or not
            for (Account account : accounts){
                if (account.getUUID().compareTo(uuid)==0)nonUnique=true;
                else break;
            }

        } while (nonUnique);
        return uuid;


    }

    /**
     * add new account to the bank
     * @param account add to accounts list
     */
    public void addAccount(Account account){
        this.accounts.add(account);
    }

    /**
     * add new user to the bank
     * @param user add to the users list
     */
    public void addUser(User user){
        this.users.add(user);
    }
}
