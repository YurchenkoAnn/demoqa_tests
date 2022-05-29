import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {
    @Test
    void successfulTest() {
        String firstname = "Иван";
        String lastName = "Иванов";
        String number = "2-342-223";
        String email = "ivanov@egorov.com";
        String address = "Иванова 1б";

        open("https://demoqa.com/automation-practice-form/");

        $("[id=firstName]").setValue(firstname);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $("[id=userNumber]").setValue(number);
        $("[id=currentAddress]").setValue(address);

        //$("[id=submit]").click();


    }
}
