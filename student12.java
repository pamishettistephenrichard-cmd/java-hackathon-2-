import java.util.Scanner;

class Student12 {
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized Constructor
    Student(String studentName, int rollNumber, double marks,
            String courseName, int courseCredits) {

        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate Course Fee
    public double calculateFee() {
        return courseCredits * 1500;
    }

    // Check Eligibility
    public boolean checkEligibility() {
        return marks >= 50;
    }

    // Calculate Scholarship Amount
    public double calculateScholarship() {
        double fee = calculateFee();

        if (marks >= 85) {
            return fee * 0.20;
        } else if (marks >= 70) {
            return fee * 0.10;
        } else {
            return 0;
        }
    }

    // Calculate Final Fee
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Display Details
    public void displayDetails() {
        System.out.println("\n----- Student Course Registration Details -----");
        System.out.println("Student Name : " + studentName);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Marks        : " + marks);
        System.out.println("Course Name  : " + courseName);
        System.out.println("Credits      : " + courseCredits);
        System.out.println("Eligibility  : Eligible");

        System.out.println("Total Fee    : Rs. " + calculateFee());
        System.out.println("Scholarship  : Rs. " + calculateScholarship());
        System.out.println("Final Fee    : Rs. " + calculateFinalFee());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = sc.nextInt();

        Student student = new Student(
                studentName,
                rollNumber,
                marks,
                courseName,
                courseCredits
        );

        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("Student is not eligible for course registration. Minimum marks required are 50.");
        }

        sc.close();
    }
}