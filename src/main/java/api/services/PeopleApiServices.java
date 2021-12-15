package api.services;

import api.assertions.AssertableResponse;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.basePath;

@Slf4j
public class PeopleApiServices {

    private Logger logger = Logger.getLogger(getClass());

    RequestSpecification requestSpec;
    private static PeopleApiServices apiUtilsInstance = null;
    public final String defaultContentType = "application/json";

    public PeopleApiServices(String basePath){
        this.requestSpec = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(defaultContentType)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .basePath(basePath);
    }

    public static PeopleApiServices getInstance(){
        if(apiUtilsInstance == null)
            apiUtilsInstance = new PeopleApiServices(basePath);
        return apiUtilsInstance;
    }

    public RequestSpecification getRequestSpec(){
        return requestSpec;
    }

    public void resetRestAssured(){
        apiUtilsInstance = null;
    }

    @Step("Get people")
    public AssertableResponse getPeople(){
        log.info("Get people - /people/1");
        return new AssertableResponse(
                requestSpec.when()
                        .get("/people/1")
                        .then());
    }

    @Step("Get Vader")
    public AssertableResponse getVader(){
        log.info("Get people - /people/4");
        return new AssertableResponse(
                requestSpec.when()
                        .get("/people/4")
                        .then());
    }
}
