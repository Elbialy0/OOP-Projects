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

    /**
     * Show the transaction history for an account
     * @param theUser the logged-in User object
     * @param sc Scanner object
     */
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

    /**
     * make transfer operation from account to another for the same user
     * @param theUser the user who do the transaction
     * @param sc Scanner object
     */
    public static void transferFunds(User theUser,Scanner sc){
        // inits
        int fromAccount;
        int toAccount;
        double amount;
        double acctBalance;
        //get account to transfer from
        do {
            System.out.println("Enter the number of account to transfer from");
            fromAccount = sc.nextInt();
            if (fromAccount<=0||fromAccount>theUser.getAccountsNumber()){
                System.out.println("Invalid number, please try again!");
            }

        }while(fromAccount<= 0 || fromAccount>theUser.getAccountsNumber() );
        // get account to transfer to
        do {
            System.out.println("Enter the number of account to transfer to");
            toAccount = sc.nextInt();
            if (toAccount<=0||toAccount>theUser.getAccountsNumber()){
                System.out.println("Invalid number, please try again!");
            }
        }while(toAccount<= 0 || toAccount>theUser.getAccountsNumber() );
        // get the amount of the transaction
        do {
            System.out.println("Enter the amount to transfer");
            amount = sc.nextDouble();
            acctBalance =  theUser.getAccountBalance(fromAccount);
            if (amount<=0||amount>acctBalance) System.out.println("You can't complete this transaction ");
        } while (amount>acctBalance||amount<=0);
        // finally, do the transfer
        theUser.addAccountTransaction(fromAccount,-1*amount,String.format(
                "Transfer to Account %s",theUser.getAccountUUID(toAccount)
        ));
    }

    /**
     * Withdraw from an account
     * @param theUser the owner of the account
     * @param sc scanner object
     */
    public static void withdrawalFunds(User theUser, Scanner sc){
        //inits
        int acctNum;
        double amount;
        double balance;
        // get account number
        do {
            System.out.println("Enter account number");
           acctNum = sc.nextInt();
            if (acctNum<=0||acctNum>theUser.getAccountsNumber()){
                System.out.println("Invalid number, please try again!");
            }

        }while(acctNum<= 0 || acctNum>theUser.getAccountsNumber() );
        balance = theUser.getAccountBalance(acctNum);
        // get amount of withdraw
        do {
            System.out.println("Enter the amount you want to withdraw");
            amount = sc.nextDouble();
            if (amount<=0){
                System.out.println("Amount must be more than 0");
            }
            else if (amount>balance){
                System.out.println("Amount must be less than or equal balance");
            }

        }while (amount>balance||amount<=0);
        theUser.addAccountTransaction(acctNum,-1*amount,"Withdraw");
    }
    public static void depositFunds(User theUser, Scanner sc){
        
    }
}
