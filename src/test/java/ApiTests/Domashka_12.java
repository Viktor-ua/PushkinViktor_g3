package ApiTests;

import api.assertions.AssertableResponse;
import api.services.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api.conditions.Conditions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class Domashka_12 extends BaseTest {

    @Test
    void checkContentType(){
        peopleApiServices
                .getPeople()
                .shouldHave(contentType("application/json"));
        Utils.resetSession();
    }

    @Test
    void checkStatusLine(){
        peopleApiServices
                .getPeople()
                .shouldHave(statusLine("HTTP/1.1 200 OK"));
        Utils.resetSession();
    }

    @Test
    void testGetVader(){
        peopleApiServices
                .getVader()
                .shouldHave(statusLine("HTTP/1.1 200 OK"))
                .shouldHave(statusCode(200))
                .shouldHave(contentType("application/json"))
                .shouldHave(body("name", is("Darth Vader")))
                .shouldHave(body("height", greaterThanOrEqualTo("201")))
                .shouldHave(body("vehicles", empty()));
        Utils.resetSession();
    }

    @Test
    void testQuantityFilmsWithVader(){
        AssertableResponse r = peopleApiServices.getVader();
        Assert.assertEquals(200, r.response.extract().statusCode());
        Assert.assertEquals("application/json", r.response.extract().contentType());
        Assert.assertEquals(r.response.extract().path("films[1]"),
                equalTo("https://swapi.dev/api/films/1/"));
    }
}
