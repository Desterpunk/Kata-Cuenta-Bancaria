package entitys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {
    private long credit;
    private long debit;
    private long balance;
    private LocalDate date;

    ArrayList<Account> db = new ArrayList<>();

    public void Account(){
        this.credit = 0;
        this.debit = 0;
        this.balance = this.credit - this.debit;
    }

    private long getCredit() {
        return credit;
    }

    private long getDebit() {
        return debit;
    }

    private long getBalance() {
        return balance;
    }

    private LocalDate getDate() {
        return date;
    }


    public void printStatements(){
        System.out.println("    Date    Credit    Debit    Balance");
        for(int i = 0; i< db.size(); i++) {
            System.out.println(db.get(i).getDate() + "    " + db.get(i).getCredit()+ "    " +
                                db.get(i).getDebit()+ "    " + db.get(i).getBalance());
        }
    }


}
