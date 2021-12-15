package ApiTests;

import api.assertions.AssertableResponse;
import api.services.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api.conditions.Conditions.body;
import static api.conditions.Conditions.statusCode;
import static org.hamcrest.core.Is.is;

public class HumanTests extends BaseTest {

    @Test
    void testGetUserName(){
        peopleApiServices
                .getPeople()
                .shouldHave(statusCode(200))
                .shouldHave(body("name", is("Luke Skywalker")));
        Utils.resetSession();
    }

    @Test
    void testGetUser(){
        AssertableResponse r = peopleApiServices.getPeople();
        Assert.assertEquals(200, r.response.extract().statusCode());
        Assert.assertEquals("application/json", r.response.extract().contentType());
    }
}