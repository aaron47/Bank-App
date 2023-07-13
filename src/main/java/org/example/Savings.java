package org.example;

public class Savings extends Account {
    // List properties specific to a Savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize Savings account properties
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox() {
        this.safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        this.safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    //  List any methods specific to Savings account
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Savings");
        super.showInfo();
        System.out.println("SAFETY DEPOSIT BOX ID: " + safetyDepositBoxID + "\nSAFETY DEPOSIT BOX KEY: " + safetyDepositBoxKey + "\nRATE: " + rate + "%");
    }
}
