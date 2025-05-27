public class Hello{
    public void greet(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) {
        new Hello().greet("Java");
    }
}
