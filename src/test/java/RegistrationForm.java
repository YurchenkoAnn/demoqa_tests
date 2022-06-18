import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        String firstName = "Иван";
        String lastName = "Иванов";
        String number = "8924238782";
        String email = "ivanov@egorov.com";
        String address = "Иванова 1б";
        open("/automation-practice-form/");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //Name, Email, Gender, Mobile
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $("#userNumber").setValue(number);

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2006");
        $(byText("15")).click();

        //Subjects
        $("#subjectsInput").sendKeys("ry");
        $(byText("Chemistry")).click();
        $("#subjectsInput").sendKeys("ry");
        $(byText("History")).click();

        //Hobbies
        $(byText("Sports")).click();

        //Current Address
        $("#currentAddress").setValue(address);

        //State and City
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        //Picture
        $("#uploadPicture").uploadFile(new File("src\\test\\resources\\a.jpg"));
        //$("#uploadPicture").uploadFromClasspath("a.jpeg");
        $("#submit").click();

        //Checks
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text("Male"),
                text(number),
                text("15 August,2006"),
                text("Chemistry, History"),
                text("Sports"),
                text("a.jpg"),
                text(address),
                text("Haryana Panipat"));
    }
}
