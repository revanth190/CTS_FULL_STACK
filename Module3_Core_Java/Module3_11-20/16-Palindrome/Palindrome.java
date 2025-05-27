import java.util.Scanner;
public class Palindrome{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input=sc.nextLine();
        String clean=input.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        String reversed=new StringBuilder(clean).reverse().toString();
        if (clean.equals(reversed)) {
            System.out.println("It's a palindrome.");
        } else {
            System.out.println("Not a palindrome.");
        }
    }
}
