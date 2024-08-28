import java.util.Scanner;

public class GradeCalculator {
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C";
        } else if (averagePercentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        if (numSubjects <= 0) {
            System.out.println("Number of subjects must be greater than zero.");
            return;
        }
        
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            
            
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Marks must be between 0 and 100. Please enter again.");
                i--; 
                continue;
            }
            
            totalMarks += marks[i];
        }
        

        double averagePercentage = (double) totalMarks / numSubjects;
        
       
        String grade = calculateGrade(averagePercentage);
        
        
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
