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
}
