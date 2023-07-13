package org.example;

import utilities.CSV;

import java.util.LinkedList;
import java.util.List;

public class Main {

    private static List<Account> accounts = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // Read a CSV file then create new accounts based on that data
        String file = "C:\\Users\\Aaron\\eclipse-workspace\\bank\\src\\main\\resources\\NewBankAccounts.csv";
        List<String[]> newAccountHolders = CSV.read(file);

        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);

            if (accountType.equals("Savings")) {
                System.out.println("OPEN A SAVINGS ACCOUNT");
                System.out.println("NAME: " + name + "\nSSN: " + sSN + "\nINITIAL DEPOSIT: $" + initDeposit);
                Savings savingsAccount = new Savings(name, sSN, initDeposit);
                savingsAccount.showInfo();
                accounts.add(savingsAccount);
            } else if (accountType.equals("Checking")) {
                System.out.println("OPEN A CHECKING ACCOUNT");
                System.out.println("NAME: " + name + "\nSSN: " + sSN + "\nINITIAL DEPOSIT: $" + initDeposit);
                Checking checkingAccount = new Checking(name, sSN, initDeposit);
                checkingAccount.showInfo();
                accounts.add(checkingAccount);
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        accounts.get((int) (Math.random() * accounts.size())).deposit(1000);
    }
}