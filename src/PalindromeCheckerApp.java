import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Text: ");
        String str = sc.nextLine();

        long startTime = System.nanoTime();

        // Palindrome check
        String reversed = new StringBuilder(str).reverse().toString();

        if(str.equals(reversed)){
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime + " ns");

        sc.close();
    }
}