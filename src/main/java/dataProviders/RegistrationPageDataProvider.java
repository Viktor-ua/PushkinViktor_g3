package dataProviders;

import com.github.javafaker.Faker;
import model.AccountBuilder;
import org.testng.annotations.DataProvider;

public class RegistrationPageDataProvider {

    public Faker faker = new Faker();

    @DataProvider
    public Object[][] registrationNewUser() {
        return new Object[][]{
                {
                        new AccountBuilder()
                                .withGender("Mr.")
                                .withFirstCustomerName("Vitya")
                                .withLastCustomerName("Pushkin")
                                .withEmail(faker.internet().emailAddress())
                                .withPassword("qwerty321")
                                .withBirthDay("1")
                                .withBirthMonth("12")
                                .withBirthYear("1989")
                                .withFirstName("Vitya")
                                .withLastName("Pushkin")
                                .withCompany("Google")
                                .withAddress1("street New York 21")
                                .withAddress2("street New York 22")
                                .withCity("New York")
                                .withState("New York")
                                .withPostalCode("12345")
                                .withCountry("United States")
                                .withPhoneMobile("1234567890")
                                .withAliasAddress("Hello!")
                                .build()

                }
        };
    }
}
