package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String address1 = faker.address().fullAddress();
        String address2 = faker.address().fullAddress();

        textBoxPage.openPage()
                   .setUserName(name)
                   .setUserEmail(email)
                   .setCurrentAddress(address1)
                   .setPermanentAddress(address2)
                   .submitForm()

                   .checkResult("Name:", name)
                   .checkResult("Email:", email)
                   .checkResult("Current Address :", address1)
                   .checkResult("Permananet Address :", address2);
    }
}