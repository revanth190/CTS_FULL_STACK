import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Person");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("Method: " + method.getName() + "(");
                Parameter[] params = method.getParameters();
                for (int i = 0; i < params.length; i++) {
                    System.out.print(params[i].getType().getSimpleName());
                    if (i < params.length - 1) System.out.print(", ");
                }
                System.out.println(")");
            }
            Object personInstance = clazz.getDeclaredConstructor().newInstance();
            for (Method method : methods) {
                if (method.getName().equals("sayHello")) {
                    method.invoke(personInstance);
                }
                if (method.getName().equals("greet")) {
                    method.invoke(personInstance, "Alice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
