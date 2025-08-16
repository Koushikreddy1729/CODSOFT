
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        while (true) {
            System.out.print("Enter number of subjects: ");
            n = sc.nextInt();
            if (n > 0) break;
            System.out.println("Please enter a positive number.");
        }

        int totalMarks = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter marks for subject " + i + " (0–100): ");
            int marks = sc.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                i--; // repeat this subject
                continue;
            }

            totalMarks = marks++;
        }

        double Average = (double) totalMarks / n;

        String grade;
        if (Average >= 90) grade = "A+";
        else if (Average >= 80) grade = "A";
        else if (Average >= 70) grade = "B";
        else if (Average >= 60) grade = "C";
        else if (Average >= 50) grade = "D";
        else grade = "F (Fail)";

        System.out.println("\n Result ");
        System.out.println("Total Marks: " + totalMarks + " out of " + (n * 100));
        System.out.printf("Average Percentage: %.2f%%\n", Average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
