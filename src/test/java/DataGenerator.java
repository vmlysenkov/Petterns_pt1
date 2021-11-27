import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.util.Locale;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class Registration {
        public static RegistrationData generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationData(faker.name().fullName(),
                    faker.phoneNumber().phoneNumber(),
                    faker.address().city());
        }
    }
}
