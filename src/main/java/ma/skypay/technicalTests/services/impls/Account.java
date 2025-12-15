package ma.skypay.technicalTests.services.impls;

import ma.skypay.technicalTests.entities.Transaction;
import ma.skypay.technicalTests.enums.Opertaion;
import ma.skypay.technicalTests.services.interfaces.AccountService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Account implements AccountService {

    private ArrayList<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    @Override
    public void deposit(int amount){
        InputValidator.isAmountValid(amount);
        String dateStr = promptForDate(Opertaion.DEPOSIT.toString(), amount);
        LocalDate date = InputValidator.isDateValide(dateStr);

        int newBalance = balance + amount;

        transactions.add(
                new Transaction(amount, date, newBalance)
        );

        balance=newBalance;
    }

    @Override
    public void withdraw(int amount) {
        InputValidator.isAmountValid(amount);
        String dateStr = promptForDate(Opertaion.WITHDRAW.toString(), amount);
        LocalDate date = InputValidator.isDateValide(dateStr);

        if(balance>=amount){
            int newBalance = balance-amount;
            transactions.add(
                    new Transaction(-amount, date, newBalance)
            );
            balance=newBalance;
        }
    }

    @Override
    public void printStatement() {
        System.out.println("Date       ||Amount|| Balance");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            System.out.println(transactions.get(i));
        }
    }

    private String promptForDate(String operation,int amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter "+amount+" "+operation+" date (DD/MM/YYYY): ");
        return scanner.nextLine();
    }

}
