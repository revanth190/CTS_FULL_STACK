import java.util.Scanner;
public class EvenOdd{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n=sc.nextInt();
        if(n%2==0){
            System.out.println(n+" is Even");
        }else{
            System.out.println(n+" is Odd");
        }
        sc.close();
    }
}
