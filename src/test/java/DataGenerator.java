import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {
    @UtilityClass
    public static class Registration {
        public static RegistrationData generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationData(faker.name().fullName(), faker.phoneNumber().phoneNumber(), faker.address().city());
        }
    }

    public static String getBankVisitDate(int daysAfterCurrentDate) {
        String formattedBankVisitDate;
        java.time.LocalDate date = java.time.LocalDate.now();
        java.time.LocalDate bankVisitDate = date.plusDays(daysAfterCurrentDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        formattedBankVisitDate = bankVisitDate.format(formatter);
        return formattedBankVisitDate;
    }
}