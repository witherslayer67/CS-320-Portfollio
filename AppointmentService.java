package Appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointmentMap = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null || appointmentMap.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment already exists or is invalid");
        }
        appointmentMap.put(appointment.getAppointmentId(), appointment);
    }

    public Appointment getAppointment(String appointmentId) {
        if (appointmentId == null || !appointmentMap.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment not found");
        }
        return appointmentMap.get(appointmentId);
    }

    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null || !appointmentMap.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment not found");
        }
        appointmentMap.remove(appointmentId);
    }
}
