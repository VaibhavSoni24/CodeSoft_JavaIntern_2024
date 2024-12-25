import java.util.Scanner;

public class StudentGradeCalculator
{
    public static void main(String[] args)
    {
        try (Scanner scan = new Scanner(System.in))
        {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scan.nextInt();
            
            int[] marks = new int[numSubjects];
            int totalMarks = 0;
            
            for (int i = 0; i < numSubjects; i++)
            {
                int mark = -1;
                while (mark < 0 || mark > 100)
                {
                    System.out.print("Enter marks for subject " + (i + 1) + " (0 to 100): ");
                    mark = scan.nextInt();
    
                    if (mark < 0 || mark > 100)
                    {
                        System.out.println("Invalid input! Marks should be between 0 and 100. Please try again.");
                    }
                }
    
                marks[i] = mark;
                totalMarks += marks[i];
            }
            
            double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;
            
            String grade;
            if (averagePercentage >= 90)
            {
                grade = "A+";
            }
            else if (averagePercentage >= 80)
            {
                grade = "A";
            }
            else if (averagePercentage >= 70)
            {
                grade = "B+";
            }
            else if (averagePercentage >= 60)
            {
                grade = "B";
            }
            else if (averagePercentage >= 50)
            {
                grade = "C";
            }
            else if (averagePercentage >= 40)
            {
                grade = "D";
            }
            else
            {
                grade = "F";
            }
            
            System.out.println("\n--- Results ---");
            System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);
        }
    }
}