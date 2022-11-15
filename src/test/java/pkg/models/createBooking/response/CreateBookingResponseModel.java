package pkg.models.createBooking.response;

public class CreateBookingResponseModel {
    private Booking booking;

    private Integer bookingid;

    public Booking getBooking ()
    {
        return booking;
    }

    public void setBooking (Booking booking)
    {
        this.booking = booking;
    }

    public Integer getBookingid ()
    {
        return bookingid;
    }

    public void setBookingid (Integer bookingid)
    {
        this.bookingid = bookingid;
    }
}
