import service.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        AppointmentService appointmentService = new AppointmentService();
        IssueService issueService = new IssueService();
        ActionHistoryService actionService = new ActionHistoryService();

        studentService.initializeStudents();
        studentService.removeLowGPA();
        studentService.insertAtIndex();

        appointmentService.initializeAppointments();
        appointmentService.cancelLast();

        issueService.initializeIssues();
        issueService.resolveIssues();

        actionService.initializeActions();
        actionService.undoLastAction();
        actionService.addRequestedTranscript();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Smart University Service System =====");
            System.out.println("1. Show Students");
            System.out.println("2. Show Appointments");
            System.out.println("3. Show Emergency Issues");
            System.out.println("4. Show Action History");
            System.out.println("5. Add New Issue");
            System.out.println("6. Undo Action");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentService.findHighestGPA();
                    System.out.println("Student List:");
                    studentService.printStudents();
                    break;
                case 2:
                    appointmentService.showFirstAndLast();
                    System.out.println("Appointments:");
                    appointmentService.printAppointments();
                    break;
                case 3:
                    issueService.showMostUrgent();
                    System.out.println("Remaining Issues:");
                    issueService.printRemainingIssues();
                    break;
                case 4:
                    actionService.showFirstAndLast();
                    System.out.println("Action History:");
                    actionService.printHistory();
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("Enter issue description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter urgency level (1-5): ");
                    int urgency = scanner.nextInt();
                    issueService.addNewIssue(description, urgency);
                    break;
                case 6:
                    actionService.undoLastAction();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 7);

        scanner.close();
    }
}
