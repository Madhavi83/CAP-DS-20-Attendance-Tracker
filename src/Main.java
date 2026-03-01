import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();

        while (true) {
            System.out.println("\n===== Classroom Attendance Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Student");
            System.out.println("4. View Daily Attendance");
            System.out.println("5. Generate Attendance Report");
            System.out.println("6. Start New Day");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll Number: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid roll number.");
                        scanner.next();
                        break;
                    }
                    int roll = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    manager.addStudent(roll, name);
                    break;

                case 2:
                    System.out.print("Enter Roll Number: ");
                    int rollNo = scanner.nextInt();
                    System.out.print("Present? (true/false): ");
                    boolean present = scanner.nextBoolean();
                    manager.markAttendance(rollNo, present);
                    break;

                case 3:
                    System.out.print("Enter Roll Number: ");
                    int viewRoll = scanner.nextInt();
                    manager.viewStudent(viewRoll);
                    break;

                case 4:
                    manager.viewDailyAttendance();
                    break;

                case 5:
                    manager.generateReport();
                    break;

                case 6:
                    manager.startNewDay();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}