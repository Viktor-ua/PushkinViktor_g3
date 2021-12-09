package api.conditions;

import org.hamcrest.Matcher;

public class Conditions {

    public static StatusCodeConditions statusCode(int code){
        return new StatusCodeConditions(code);
    }

    public static ResponseBodyCondition body(String path, Matcher matcher){
        return new ResponseBodyCondition(path, matcher);
    }
}
