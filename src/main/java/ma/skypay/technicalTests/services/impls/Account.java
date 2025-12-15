package ma.skypay.technicalTests.services.impls;

import ma.skypay.technicalTests.entities.Transaction;
import ma.skypay.technicalTests.services.interfaces.AccountService;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account implements AccountService {

    private ArrayList<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    @Override
    public void deposit(int amount){
        InputValidator.isAmountValid(amount);
        int newBalance = balance+amount;
        transactions.add(
                new Transaction(amount, LocalDate.now(),newBalance)
        );
        balance=newBalance;
    }

    @Override
    public void withdraw(int amount) {
        InputValidator.isAmountValid(amount);
        if(balance>=amount){
            int newBalance = balance-amount;
            transactions.add(
                    new Transaction(-amount, LocalDate.now(),newBalance)
            );
        }
    }

    @Override
    public void printStatement() {
        System.out.println("Date       ||Amount|| Balance");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            System.out.println(transactions.get(i));
        }
    }

}
