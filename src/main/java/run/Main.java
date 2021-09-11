package run;

import entitys.Account;

public class Main {
    public static void main(String[] args) {
        Account cuenta = new Account();
        cuenta.deposit(1000, "10/01/2021");
        cuenta.deposit(2000, "13/01/2021");
        cuenta.printStatements();
    }
}
