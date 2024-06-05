package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultsComponent;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement birthDateInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement fileInput = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateAndCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement closeModalButton = $("#closeLargeModal");
    private final SelenideElement formHeader = $(".practice-form-wrapper");
    private final SelenideElement citiesDropdown = $(".css-26l3qy-menu");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formHeader.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String[] subjects) {
        //String[] subjectsArray = (String[]) subjects.toArray();
        for (String subject : subjects) {
            subjectsInput.setValue(subject).pressEnter();
        }
        //subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String[] hobbies) {
        for (String hobbie : hobbies) {
            hobbiesWrapper.$(byText(hobbie)).click();
        }
        //hobbiesWrapper.$(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage uploadFile(String value) {
        fileInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateAndCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateAndCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkTableResult(String key, String value) {
        new TableResultsComponent().checkResult(key, value);
        return this;
    }

    public RegistrationPage closeResultsTable() {
        closeModalButton.click();
        return this;
    }

    public RegistrationPage checkFormHeader() {
        formHeader.shouldBe(visible);
        return this;
    }

    public RegistrationPage checkField(String[] cities) {
        cityInput.click();
        for (String city : cities) {
            citiesDropdown.shouldHave(text(city));
        }
        return this;
    }
}