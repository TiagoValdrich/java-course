package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.validateReservationDates(checkIn, checkOut);
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long diff = this.checkOut.getTime() - this.checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) {

        this.validateReservationDates(checkIn, checkOut);

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void validateReservationDates(Date checkIn, Date checkOut) {

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {

            throw new DomainException("Reservation dates for update must be future dates");

        }

        if (!checkOut.after(checkIn)) {

            throw new DomainException("Check-out date must be after check-in date");

        }

    }

    @Override
    public String toString() {
        return "Room: "
                + this.roomNumber
                + ", check-in: "
                + sdf.format(this.getCheckIn())
                + ", check-out: "
                + sdf.format(this.getCheckOut())
                + ", "
                + this.duration()
                + " nights.";
    }
}
