import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {

        Stack<Character> stack = new Stack<>();

        for(char c : text.toCharArray()){
            stack.push(c);
        }

        for(char c : text.toCharArray()){
            if(c != stack.pop()){
                return false;
            }
        }

        return true;
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {

        Deque<Character> deque = new ArrayDeque<>();

        for(char c : text.toCharArray()){
            deque.addLast(c);
        }

        while(deque.size() > 1){

            if(deque.removeFirst() != deque.removeLast()){
                return false;
            }
        }

        return true;
    }
}

// Context Class
class PalindromeChecker {

    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy){
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String text){
        return strategy.isPalindrome(text);
    }
}

// Main Class
public class PalindromeCheckerApp {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("input: ");
        String input = sc.nextLine();

        System.out.println("Choose Algorithm");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if(choice == 1){
            strategy = new StackStrategy();
        }else{
            strategy = new DequeStrategy();
        }

        PalindromeChecker checker = new PalindromeChecker(strategy);

        if(checker.checkPalindrome(input)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }

        sc.close();
    }
}