package ma.skypay.technicalTests.services.impls;

public class InputValidator {
    public static void isAmountValid(int amount){
        if (amount<=0){
            throw new IllegalArgumentException(amount+" Is Not A Valid Amount");
        }
    }
}
