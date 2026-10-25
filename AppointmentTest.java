package Appointment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class AppointmentTest {

    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    @Test
    public void testAppointmentClass() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("12345", futureDate, "Meeting with client.");
        Assertions.assertEquals("12345", appointment.getAppointmentId());
        Assertions.assertEquals(futureDate, appointment.getAppointmentDate());
        Assertions.assertEquals("Meeting with client.", appointment.getDescription());
    }

    @Test
    public void testAppointmentIdTooLong() {
        Date futureDate = getFutureDate();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Description");
        });
    }

    @Test
    public void testAppointmentIdNull() {
        Date futureDate = getFutureDate();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Description");
        });
    }

    @Test
    public void testAppointmentDateNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Description");
        });
    }

    @Test
    public void testAppointmentDateInPast() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date pastDate = calendar.getTime();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Description");
        });
    }

    @Test
    public code void testDescriptionNull() {
        Date futureDate = getFutureDate();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
    }

    @Test
    public void testDescriptionTooLong() {
        Date futureDate = getFutureDate();
        String longDesc = "This description is definitely way longer than fifty characters allowed by the system rules.";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, longDesc);
        });
    }
}