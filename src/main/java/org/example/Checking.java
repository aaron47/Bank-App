package org.example;

public class Checking extends Account {
    // List properties specific to a Checking account
    private int debitCardNum;
    private int debitCardPin;

    // Constructor to initialize Checking account properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    private void setDebitCard() {
        this.debitCardNum = (int) (Math.random() * Math.pow(10, 12));
        this.debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }

    //  List any methods specific to Checking account
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Checking");
        super.showInfo();
        System.out.println("DEBIT CARD NUMBER: " + debitCardNum + "\nDEBIT CARD PIN: " + debitCardPin + "\nRATE: " + rate + "%");
    }
}
