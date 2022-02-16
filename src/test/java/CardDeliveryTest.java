import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @Test
    void shouldTestCardDelivery() {
        RegistrationData data = DataGenerator
                .Registration
                .generateInfo("ru");
        System.out.println(data);

        String firstFormattedBankVisitDate = DataGenerator.getBankVisitDate(4);
        String secondFormattedBankVisitDate = DataGenerator.getBankVisitDate(7);
        open("http://0.0.0.0:9999/");
        $("[class='input__control'][type='text']").setValue(data.getCity());
        $("[class='input__control'][type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[class='input__control'][type='tel']").setValue(String.valueOf(firstFormattedBankVisitDate));
        $("[class='input__control'][name='name']").setValue(data.getName());
        $("[class='input__control'][name='phone']").setValue(data.getPhone());
        $("[class='checkbox__box']").click();
        $("[class='button__text']").click();
        $("[class='notification__content']").shouldBe(appear, Duration.ofSeconds(15)).shouldHave(text(firstFormattedBankVisitDate));
        $("[class='input__control'][type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[class='input__control'][type='tel']").setValue(String.valueOf(secondFormattedBankVisitDate));
        $("[class='button__text']").click();
        $("[class='button button_view_extra button_size_s button_theme_alfa-on-white']").click();
        $("[class='notification__content']").shouldBe(appear, Duration.ofSeconds(15)).shouldHave(text(secondFormattedBankVisitDate));
    }
}


