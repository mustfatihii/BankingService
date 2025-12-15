package ma.skypay.technicalTests.services.impls;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputValidator {
    public static void isAmountValid(int amount){
        if (amount<=0){
            throw new IllegalArgumentException(amount+" Is Not A Valid Amount");
        }
    }

    public static LocalDate isDateValide(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(dateStr, formatter);
        }catch (Exception e){
            throw new IllegalArgumentException(dateStr +" Is Not A Valid Date");
        }
    }

}
