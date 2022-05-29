import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {
        String firstname = "Иван";
        String lastName = "Иванов";
        String number = "2-342-223";
        String email = "ivanov@egorov.com";
        String address = "Иванова 1б";

        open("/automation-practice-form/");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("[id=firstName]").setValue(firstname);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $("[id=userNumber]").setValue(number);
        $("[id=currentAddress]").setValue(address);

        $("[id=submit]").click();


    }
}
