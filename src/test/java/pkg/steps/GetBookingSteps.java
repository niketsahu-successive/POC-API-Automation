package pkg.steps;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pkg.models.getBooking.GetBookingResponseModel;
import pkg.services.GetBookingService;

import static pkg.helpers.Helper.gson;

public class GetBookingSteps {
    private static Integer bookingID = null;
    private GetBookingResponseModel getBookingResponseModel = new GetBookingResponseModel();
    private Response jsonResponse;

    @When("^User stores the booking id to fetch the created bookings$")
    public void userStoresTheBookingIdToFetchTheCreatedBookings() {
        bookingID = CreateBookingSteps.bookingId;
    }

    @When("^User makes a request to fetch the created bookings$")
    public void userMakesARequestToFetchTheCreatedBookings() {
        jsonResponse = GetBookingService.getBookingServiceRequest(bookingID);
    }

    @Then("^User should be able to fetch the created bookings$")
    public void userShouldBeAbleToFetchTheCreatedBookings() {
        Assert.assertEquals(200, jsonResponse.getStatusCode());
        getBookingResponseModel = gson().fromJson(jsonResponse.body().prettyPrint(), GetBookingResponseModel.class);
    }
}
