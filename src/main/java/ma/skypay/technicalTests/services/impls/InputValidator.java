package ma.skypay.technicalTests.services.impls;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class InputValidator {
    public static void isAmountValid(int amount){
        if (amount<=0){
            throw new IllegalArgumentException(amount+" Is Not A Valid Amount");
        }
    }

    public static LocalDate isDateValid(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT);
        try {
            return LocalDate.parse(dateStr, formatter);
        }catch (DateTimeParseException e){
            throw new IllegalArgumentException(dateStr +" Is Not A Valid Date");
        }
    }

}
