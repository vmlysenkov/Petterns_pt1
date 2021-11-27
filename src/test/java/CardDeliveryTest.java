import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @Test
    void shouldTestCardDelivery() {
        RegistrationData data = DataGenerator
                .Registration
                .generateInfo("ru");
        System.out.println(data);


        EstablishedDate firstDate = new EstablishedDate();
        EstablishedDate secondDate = new EstablishedDate();
        firstDate.setBankVisitDate(4);
        secondDate.setBankVisitDate(7);
        String firstFormattedBankVisitDate = firstDate.getBankVisitDate();
        String secondFormattedBankVisitDate = secondDate.getBankVisitDate();
        open("http://0.0.0.0:9999/");
        $("[class='input__control'][type='text']").setValue(data.getCity());
        $("[class='input__control'][type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[class='input__control'][type='tel']").setValue(String.valueOf(firstFormattedBankVisitDate));
        $("[class='input__control'][name='name']").setValue(data.getName());
        $("[class='input__control'][name='phone']").setValue(data.getPhone());
        $("[class='checkbox__box']").click();
        $(withText("Запланировать")).click();
        $(withText("Встреча успешно")).shouldBe(appear, Duration.ofSeconds(15)).shouldHave(text(firstFormattedBankVisitDate));
        $("[class='input__control'][type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[class='input__control'][type='tel']").setValue(String.valueOf(secondFormattedBankVisitDate));
        $(withText("Запланировать")).click();
        $(withText("Перепланировать")).click();
        $(withText("Встреча успешно")).shouldBe(appear, Duration.ofSeconds(15)).shouldHave(text(secondFormattedBankVisitDate));
    }

}


