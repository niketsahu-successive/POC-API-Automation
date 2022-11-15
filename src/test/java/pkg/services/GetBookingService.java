package pkg.services;

import com.jayway.restassured.response.Response;
import pkg.helpers.Helper;

public class GetBookingService extends Helper {
    public static Response getBookingServiceRequest(Integer bookingID) {
        Response response;
        httpRequest.header("Content-Type", "application/json").header("Accept", "application/json");
        log.info("BookingID Before Hitting API: {}", bookingID);
        response = httpRequest.pathParam("id", bookingID).get("https://restful-booker.herokuapp.com/booking/{id}");
        log.info("Response After Hitting API: {}", response.body().prettyPrint());
        return response;
    }
}
