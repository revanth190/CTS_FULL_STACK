public class HelloWorld{
    private String message = "Hello, Java bytecode!";

    public void printMessage(){
        System.out.println(message);
    }

    public static void main(String[] args){
        new HelloWorld().printMessage();
    }
}
