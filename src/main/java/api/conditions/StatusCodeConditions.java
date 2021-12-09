package api.conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StatusCodeConditions implements Condition{

    private int statusCode;

    @Override
    public void check(ValidatableResponse response){
        response.assertThat().statusCode(statusCode);
    }

    @Override
    public String toString(){
        return "status code is: " + statusCode;
    }
}
