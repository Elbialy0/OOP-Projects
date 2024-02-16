package ATM;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank CIB = new Bank();

        User user=CIB.addUser("Mahmoud","Reda","1234");
        CIB.addAccount(user,"saving");
       User u= CIB.userLogin(user.getUUID(),"123");

    }
}
