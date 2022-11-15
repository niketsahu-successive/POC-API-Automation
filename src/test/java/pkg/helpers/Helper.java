package pkg.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Helper {
    public static Logger log = LoggerFactory.getLogger("logger");
    public static RequestSpecification httpRequest = RestAssured.given();

    public static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson;
    }
}
