import java.util.*;

public class AttendanceManager {

    private HashMap<Integer, Student> students;
    private Queue<Integer> dailyAttendanceQueue;

    public AttendanceManager() {
        students = new HashMap<>();
        dailyAttendanceQueue = new LinkedList<>();
    }

    // Add new student
    public void addStudent(int rollNumber, String name) {
        if (students.containsKey(rollNumber)) {
            System.out.println("Student with this roll number already exists.");
            return;
        }

        Student student = new Student(rollNumber, name);
        students.put(rollNumber, student);
        System.out.println("Student added successfully.");
    }

    // Mark attendance
    public void markAttendance(int rollNumber, boolean present) {
        Student student = students.get(rollNumber);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.markAttendance(present);
        dailyAttendanceQueue.add(rollNumber);

        System.out.println("Attendance marked for " + student.getName());
    }

    // View student by roll number
    public void viewStudent(int rollNumber) {
        Student student = students.get(rollNumber);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println(student);
        }
    }

    // View daily attendance order
    public void viewDailyAttendance() {
        if (dailyAttendanceQueue.isEmpty()) {
            System.out.println("No attendance marked today.");
            return;
        }

        System.out.println("Daily Attendance Order:");
        for (int roll : dailyAttendanceQueue) {
            System.out.println(students.get(roll).getName());
        }
    }

    // Generate sorted attendance report
    public void generateReport() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        List<Student> studentList = new ArrayList<>(students.values());

        studentList.sort((s1, s2) ->
                Double.compare(s2.getAttendancePercentage(), s1.getAttendancePercentage())
        );

        System.out.println("Attendance Report (Highest to Lowest):");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    // Start new day (clear daily queue)
    public void startNewDay() {
        dailyAttendanceQueue.clear();
        System.out.println("New day started. Daily attendance cleared.");
    }
}