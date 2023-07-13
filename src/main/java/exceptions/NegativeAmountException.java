package exceptions;

public class NegativeAmountException extends Exception {
    public NegativeAmountException() {
        super("Amount deposited/withdrawn should positive");
    }
}
