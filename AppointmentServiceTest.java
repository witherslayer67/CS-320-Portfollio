package Appointment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class AppointmentServiceTest {

    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("A1", futureDate, "Dentist appointment.");

        service.addAppointment(appointment);
        Assertions.assertEquals(appointment, service.getAppointment("A1"));
    }

    @Test
    public void testAddDuplicateAppointmentId() {
        AppointmentService service = new AppointmentService();
        Date futureDate = getFutureDate();
        Appointment appointment1 = new Appointment("A1", futureDate, "Dentist appointment.");
        Appointment appointment2 = new Appointment("A1", futureDate, "Different appointment.");

        service.addAppointment(appointment1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("A1", futureDate, "Dentist appointment.");

        service.addAppointment(appointment);
        service.deleteAppointment("A1");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.getAppointment("A1");
        });
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        AppointmentService service = new AppointmentService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("NonExistent");
        });
    }
}
