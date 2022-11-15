package pkg.services;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import pkg.helpers.Helper;
import pkg.models.createBooking.request.CreateBookingRequestModel;

public class CreateBookingService extends Helper {

    public static Response createBookingServiceRequest(CreateBookingRequestModel createBookingRequestModel) {
        Response response;
        httpRequest.header("Content-Type", "application/json").header("Accept", "application/json");
        log.info("JSON Data Before Hitting API: {}", gson().toJson(createBookingRequestModel));
        response = httpRequest.body(gson().toJson(createBookingRequestModel)).post("https://restful-booker.herokuapp.com/booking");
        log.info("JSON Data After Hitting API: {}", response.body().prettyPrint());
        return response;
    }
}
