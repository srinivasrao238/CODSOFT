import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem{

    // Function to save student data to a CSV file
    static void saveStudentDataToCSV(List<String> studentNames, List<Integer> studentGrades) {
        try (FileWriter outputFile = new FileWriter("student_data.csv")) {
            outputFile.write("Name,Grade\n"); // CSV header

            for (int i = 0; i < studentNames.size(); ++i) {
                outputFile.write(studentNames.get(i) + "," + studentGrades.get(i) + "\n");
            }

            System.out.println("Student data has been saved to student_data.csv.");
        } catch (IOException e) {
            System.err.println("Failed to open the CSV file for writing.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===============================================================");
        System.out.println("\t\t\t\tStudent Grading System");
        System.out.println("===============================================================\n");

        List<String> studentNames = new ArrayList<>();
        List<Integer> studentGrades = new ArrayList<>();

        while (true) {
            System.out.println("------------------------");
            System.out.println("\tMenu");
            System.out.println("1. Add Student Grade");
            System.out.println("2. Display Highest, Average, and Lowest Grades");
            System.out.println("3. Edit Student Grades");
            System.out.println("4. Delete Student Grades");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Student Grade
                    System.out.print("Enter the number of students: ");
                    int numStudents = scanner.nextInt();

                    for (int i = 0; i < numStudents; ++i) {
                        scanner.nextLine();
                        System.out.print("Enter the name of student " + (i + 1) + ": ");
                        String name = scanner.nextLine();
                        System.out.print("Enter the grade for " + name + ": ");
                        int grade = scanner.nextInt();

                        studentNames.add(name);
                        studentGrades.add(grade);
                    }
                    saveStudentDataToCSV(studentNames, studentGrades); // Save data to CSV after adding students
                    break;
                case 2: // Display Highest, Average, and Lowest Grades
                    if (studentNames.isEmpty()) {
                        System.out.println("No student data available.");
                    } else {
                        int highestGrade = studentGrades.stream().mapToInt(Integer::intValue).max().getAsInt();
                        int lowestGrade = studentGrades.stream().mapToInt(Integer::intValue).min().getAsInt();
                        double averageGrade = studentGrades.stream().mapToInt(Integer::intValue).average().getAsDouble();

                        System.out.println("Highest Grade: " + highestGrade);
                        System.out.println("Average Grade: " + String.format("%.2f", averageGrade));
                        System.out.println("Lowest Grade: " + lowestGrade);
                    }
                    break;
                case 3: // Edit Student Grades
                    if (studentNames.isEmpty()) {
                        System.out.println("No student data available.");
                    } else {
                        System.out.print("Enter the name of the student to edit grades: ");
                        scanner.nextLine();
                        String searchName = scanner.nextLine();

                        boolean found = false;
                        for (int i = 0; i < studentNames.size(); ++i) {
                            if (studentNames.get(i).equals(searchName)) {
                                System.out.print("Enter the new grade for " + searchName + ": ");
                                int newGrade = scanner.nextInt();
                                studentGrades.set(i, newGrade);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Student not found.");
                        }
                        saveStudentDataToCSV(studentNames, studentGrades); // Save data to CSV after editing grades
                    }
                    break;
                case 4: // Delete Student Grades
                    if (studentNames.isEmpty()) {
                        System.out.println("No student data available.");
                    } else {
                        System.out.print("Enter the name of the student to delete: ");
                        scanner.nextLine();
                        String deleteName = scanner.nextLine();

                        for (int i = 0; i < studentNames.size(); ++i) {
                            if (studentNames.get(i).equals(deleteName)) {
                                studentNames.remove(i);
                                studentGrades.remove(i);
                                System.out.println("Student " + deleteName + " has been deleted.");
                                saveStudentDataToCSV(studentNames, studentGrades); // Save data to CSV after deleting a student
                                break;
                            }
                        }
                    }
                    break;
                case 5: // Exit
                    saveStudentDataToCSV(studentNames, studentGrades); // Save data to CSV before exiting
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
