package entitys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {
    private long credit;
    private long debit;
    private long balance;
    private LocalDate date;

    ArrayList<Account> dataBase = new ArrayList<>();

    public void Account(){
        this.credit = 0;
        this.debit = 0;
        this.balance = 0;
    }

    private void depositCredit(long credit) {
        this.credit += credit;
    }

    private void withdrawalDebit(long debit) {
        this.debit += debit;
    }

    private void calculateBalance(ArrayList<Account> dataBase) {
        int size = dataBase.size();
        if (size > 0) {
            Account lastData = dataBase.get(size - 1);
            balance += lastData.getBalance();
        }
        balance += this.credit;
        balance -= this.debit;
    }

    private void setDate(LocalDate date) {
        this.date = date;
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

    public void deposit(long amount, String date){
        Account account = new Account();
        account.depositCredit(amount);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date,dateFormat);
        account.setDate(localDate);
        account.calculateBalance(dataBase);
        dataBase.add(account);
    }

    public void withdrawal(long amount, String date){
        Account account = new Account();
        account.withdrawalDebit(amount);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date,dateFormat);
        account.setDate(localDate);
        account.calculateBalance(dataBase);
        dataBase.add(account);
    }

    public void printStatements(){
        System.out.println("     Date    Credit    Debit    Balance");
        for (Account account : dataBase) {
            System.out.println(account.getDate() + "    " +
                    account.getCredit() + "       " +
                    account.getDebit() + "      " +
                    account.getBalance());
        }
    }


}
