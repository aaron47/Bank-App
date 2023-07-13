package org.example;

import exceptions.NegativeAmountException;

public abstract class Account implements IBaseRate {
    // List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;
    private String accountNumber;
    protected double rate;
    private static int index = 10000;

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;
        // set account number
        index++;
        this.accountNumber = setAccountNumber();
        this.rate = getBaseRate();
        setRate();
    }

    public abstract void setRate();


    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length() - 2);
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        int checkingOrSavingsId = this instanceof Savings ? 1 : 2;
        return checkingOrSavingsId + lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        this.printBalance();
    }

    // List common methods
    public void deposit(double amount) throws Exception {
        if (amount > 0) {
            balance += amount;
            System.out.println("Depositing $" + amount);
            this.printBalance();
        } else {
            throw new NegativeAmountException();
        }
    }

    public void withdraw(double amount) throws Exception {
        if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrawing $" + amount);
            this.printBalance();
        } else {
            throw new NegativeAmountException();
        }
    }

    public void transfer(String toWhere, double amount) {
        System.out.println("Transferring $" + amount + " to " + toWhere);
        try {
            this.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Transfer failed" + e.getMessage());
        }
    }

    private void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo() {
        System.out.println("NAME: " + name + "\nACCOUNT NUMBER: " + accountNumber + "\nBALANCE: " + balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsSN() {
        return sSN;
    }

    public void setsSN(String sSN) {
        this.sSN = sSN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
