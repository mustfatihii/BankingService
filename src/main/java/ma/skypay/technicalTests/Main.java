package ma.skypay.technicalTests;

import ma.skypay.technicalTests.services.impls.Account;

public class Main {
    public static void main(String[] args) {

        Account account = new Account();

        try{
            account.deposit(1000);
            account.deposit(-2000);
            account.withdraw(500);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        account.printStatement();
    }
}