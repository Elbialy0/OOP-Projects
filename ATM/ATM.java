package ATM;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        // initialize sc
        Scanner sc = new Scanner(System.in);
        // initialize the bank
        Bank cib = new Bank("CIB");
        // add new user
        User mahmoud = cib.addUser("Mahmoud","Reda","1234");
        // create account for the user
        cib.addAccount(mahmoud,"saving");



    }

    /**
     *
     * @param theBank the bank that user belong to
     * @param sc scanner object
     * @return the authorized user
     */
    public static User mainMenuPrompt (Bank theBank , Scanner sc ){
        String userID;
        String pin ;
        User authUser ;
        // take the id and pin  from user  then validate them
        do {
            System.out.println("Welcome to "+theBank.getName());
            System.out.println("Enter your ID : ");
            userID = sc.nextLine();
            System.out.println("Enter pin : ");
            pin = sc.nextLine();
            //search for the user then check pin is true or not
            authUser = theBank.userLogin(userID,pin);
            if(authUser==null){
                System.out.println("Incorrect user ID/pin , please try again");
            }
        } while (authUser==null);
        return authUser;
    }
    public static void printUserMenu(User aUser,Scanner sc){
        aUser.printAccountsSummary();
        int choice;
        // menu of the operations
        do {
            System.out.println("Welcome " + aUser.getFirstName());
            System.out.println("1) Show account transaction history");
            System.out.println("2) Withdrawal");
            System.out.println("3) Deposit");
            System.out.println("4) Transfer");
            System.out.println("5) Show balance");
            System.out.println("6) Quit");
            choice = sc.nextInt();
            if(choice<1||choice>6){
                System.out.println("Invalid choice . please choose 1-6");
            }
        }while (choice<1||choice>6);
        // process the choice
        switch (choice){
            case 1:
                ATM.showTransactionHistory(aUser,sc);
                break;
            case 2:
                ATM.withdrawalFunds(aUser,sc);
                break;
            case 3:
                ATM.depositFunds(aUser,sc);
                break;
            case 4:
                ATM.transferFunds(aUser,sc);
                break;
            case 5:
                ATM.showBalance(aUser,sc);
                break;
        }
        // redisplay the list unless the user wants to quit
        if(choice!=6){
            ATM.printUserMenu(aUser,sc);
        }


    }

    /**
     * show the balance of the account
     * @param aUser the user that own the account
     * @param sc Scanner object
     */
    public static void showBalance(User aUser,Scanner sc){
        System.out.println("Enter account UUID");
        String uuid = sc.nextLine();
        System.out.println(aUser.getBalance(uuid));
    }
    // get transaction history of the account
    public static void showTransactionHistory(User theUser,Scanner sc){
        int accountNum;
        do {
            System.out.println("Choose the account");
            //choose the number of the account
            accountNum = sc.nextInt();
            //validate the input
            if (accountNum<=0||accountNum>theUser.getAccountsNumber()){
                System.out.println("Invalid number, please try again!");
            }

        }while(accountNum <= 0 || accountNum>theUser.getAccountsNumber() );
        theUser.printAcctTransHistory(accountNum);

    }
}
