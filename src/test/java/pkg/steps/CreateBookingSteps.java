package pkg.steps;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pkg.helpers.Helper;
import pkg.models.createBooking.request.Bookingdates;
import pkg.models.createBooking.request.CreateBookingRequestModel;
import pkg.models.createBooking.response.CreateBookingResponseModel;
import pkg.services.CreateBookingService;

import java.util.List;

public class CreateBookingSteps extends Helper {
    public static Integer bookingId = null;
    private CreateBookingRequestModel createBookingRequestModel = new CreateBookingRequestModel();
    private CreateBookingResponseModel createBookingResponseModel = new CreateBookingResponseModel();
    private Bookingdates bookingdates = new Bookingdates();
    private Response jsonResponse;

    @When("^User enters valid details to create a booking$")
    public void userEntersValidDetailsToCreateABooking(List<CreateBookingRequestModel> createBookingRequestModelList) {
        createBookingRequestModel.setAdditionalneeds(createBookingRequestModelList.get(0).getAdditionalneeds());
        createBookingRequestModel.setDepositpaid(createBookingRequestModelList.get(0).getDepositpaid());
        createBookingRequestModel.setFirstname(createBookingRequestModelList.get(0).getFirstname());
        createBookingRequestModel.setTotalprice(createBookingRequestModelList.get(0).getTotalprice());
        createBookingRequestModel.setLastname(createBookingRequestModelList.get(0).getLastname());
    }

    @When("^User enters booking date details to create a booking$")
    public void userEntersBookingDateDetailsToCreateABooking(List<Bookingdates> bookingdatesList) {
        bookingdates.setCheckin(bookingdatesList.get(0).getCheckin());
        bookingdates.setCheckout(bookingdatesList.get(0).getCheckout());
        createBookingRequestModel.setBookingdates(bookingdates);
    }

    @And("^User makes a request to create a booking$")
    public void userMakesARequestToCreateABooking() {
        jsonResponse = CreateBookingService.createBookingServiceRequest(createBookingRequestModel);
    }

    @Then("^User should be able to create a booking successfully$")
    public void userShouldBeAbleToCreateABookingSuccessfully() {
        try {
            Assert.assertEquals(200, jsonResponse.getStatusCode());
            createBookingResponseModel = Helper.gson().fromJson(jsonResponse.body().prettyPrint(), CreateBookingResponseModel.class);
            bookingId = createBookingResponseModel.getBookingid();
            Assert.assertEquals(createBookingRequestModel.getFirstname(), createBookingResponseModel.getBooking().getFirstname());
            Assert.assertEquals(createBookingRequestModel.getLastname(), createBookingResponseModel.getBooking().getLastname());
            Assert.assertEquals(createBookingRequestModel.getAdditionalneeds(), createBookingResponseModel.getBooking().getAdditionalneeds());
            Assert.assertEquals(createBookingRequestModel.getDepositpaid(), createBookingResponseModel.getBooking().getDepositpaid());
            Assert.assertEquals(createBookingRequestModel.getTotalprice(), createBookingResponseModel.getBooking().getTotalprice());
            log.info("Assertion Passed Successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jsonResponse = null;
        }
    }
}
