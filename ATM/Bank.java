package ATM;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    // the name of the bank
    private String name;
    // users of this bank
    private ArrayList<User> users;
    // accounts in this bank
    private ArrayList<Account> accounts ;

    /**
     * create the bank
     * @param name the name of the bank
     */
    public Bank(String name){
        this.name=name;
        this.users=new ArrayList<>();
        this.accounts=new ArrayList<>();

    }
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
    public void addAccount(Account account){
        this.accounts.add(account);
    }

    /**
     * add user
     * @param firstName the first name of the user
     * @param lastName  the second name of the user
     * @param pin  password of the user
     * @return new user
     */
    public User addUser(String firstName, String lastName, String pin){
        // create a new user
        User newUser = new User(firstName, lastName,this,pin);
        // add this user to the list of the users
        this.users.add(newUser);
        return  newUser;
    }

    /**
     * Create new account
     * @param user owner of the account
     * @param typeOfTheAccount type of the account
     */
    public void addAccount(User user , String typeOfTheAccount){
        Account account = new Account(typeOfTheAccount , user , this);
    }

    /**
     * log in
     * @param userID uuid of the user
     * @param pin password of the user
     * @return the user that match this information or return null
     */
    public User userLogin(String userID,String pin){

        for (User user : this.users){
            if(user.getUUID().compareTo(userID)==0){
               if ( user.validateUser(pin)){
                   System.out.println("Successful attempt");return user;}
               else break;

            }
        }
        return null;
    }



}
