public class Student {
    private int rollNumber;
    private String name;
    private int totalClasses;
    private int attendedClasses;

    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.totalClasses = 0;
        this.attendedClasses = 0;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void markAttendance(boolean present) {
        totalClasses++;
        if (present) {
            attendedClasses++;
        }
    }

    public double getAttendancePercentage() {
        if (totalClasses == 0) return 0;
        return (attendedClasses * 100.0) / totalClasses;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber +
                ", Name: " + name +
                ", Attendance: " + String.format("%.2f", getAttendancePercentage()) + "%";
    }
}