package api.conditions;

import org.hamcrest.Matcher;

public class Conditions {

    public static StatusCodeConditions statusCode(int code){
        return new StatusCodeConditions(code);
    }

    public static ResponseBodyCondition body(String path, Matcher matcher){
        return new ResponseBodyCondition(path, matcher);
    }

    /**
     * For Domashka 12
     */
    public static ContentTypeCondition contentType(String contType){
        return new ContentTypeCondition(contType);
    }

    public static StatusLineCondition statusLine(String statusLine){
        return new StatusLineCondition(statusLine);
    }
}
