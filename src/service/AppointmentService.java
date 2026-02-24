package service;

import java.util.LinkedList;
import java.util.Iterator;

public class AppointmentService {

    private LinkedList<String> appointments = new LinkedList<>();

    public void initializeAppointments() {
        appointments.add("Aliya - 10:00");
        appointments.add("Danon - 11:00");
        appointments.add("Maloy - 12:00");
        appointments.addFirst("URGENT: Aigerim - 09:30");
    }

    public void cancelLast() {
        if (!appointments.isEmpty()) {
            appointments.removeLast();
        }
    }

    public void showFirstAndLast() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments.");
            return;
        }
        System.out.println("First appointment: " + appointments.getFirst());
        System.out.println("Last appointment: " + appointments.getLast());
    }

    public void printAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments in queue.");
            return;
        }

        Iterator<String> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
