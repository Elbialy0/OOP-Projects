package ATM;

import java.util.Date;

public class Transaction {
    // amount of the transaction
    private double amount;
    // date of transaction
    private Date timestamp;
    // a memo for this transaction
    private String memo;
    // the account in which the transaction was performed
    private Account inAccount;

    /**
     * initialize the transaction
     * @param amount of the money
     * @param timestamp data of transaction
     * @param memo of this transaction
     * @param inAccount destination  account
     */
    public Transaction(double amount, Date timestamp, String memo, Account inAccount) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.memo = memo;
        this.inAccount = inAccount;
    }

    /**
     * Get the amount of the transaction
     * @return the amount
     */
    public double getAmount(){
        return this.amount;
    }

    /**
     * get a string summarizing the transaction
     *
     * @return the summary string
     */
    public String getSummaryLine(){
        if (this.amount>=0){
            return String.format("%s : $%.02f : %s", this.timestamp.toString(),this.amount,
                    this.memo);
        }
        return String.format("%s : $(%.02f) : %s", this.timestamp.toString(),this.amount,
                this.memo);
    }
}
