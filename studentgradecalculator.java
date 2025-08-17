import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        while (true) {
            System.out.print("Enter total number of subjects: ");
            n = sc.nextInt();
            if (n > 0) break;
            System.out.println("Please enter a positive number.");
        }

        int TotalMarks = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter marks for subject " + i + " (0–100): ");
            int Marks = sc.nextInt();

            if (Marks < 0 || Marks > 100) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                i--; 
                continue;
            }

            TotalMarks += Marks;  
        }

        double Average = (double) TotalMarks / n;

        String Grade;
        if (Average >= 90) Grade = "A+";
        else if (Average >= 80) Grade = "A";
        else if (Average >= 70) Grade = "B";
        else if (Average >= 60) Grade = "C";
        else if (Average >= 50) Grade = "D";
        else Grade = "F (Fail)";

        System.out.println("\n Result ");
        System.out.println("Total Marks: " + TotalMarks + " out of " + (n * 100));
        System.out.printf("Average Percentage: %.2f%%\n", Average);
        System.out.println("Grade: " + Grade);

        sc.close();
    }
}
