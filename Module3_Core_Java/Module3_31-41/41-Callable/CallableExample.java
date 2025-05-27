import java.util.concurrent.*;
import java.util.*;
public class CallableExample{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numberOfTasks = 5;
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 1; i <= numberOfTasks; i++) {
            int taskId = i;
            Callable<Integer> task = () -> {
                System.out.println("Task " + taskId + " is running on thread: " + Thread.currentThread().getName());
                Thread.sleep(1000);
                return taskId * taskId;
            };
            futures.add(executor.submit(task));
        }
        for (int i = 0; i < futures.size(); i++) {
            Future<Integer> future = futures.get(i);
            Integer result = future.get();
            System.out.println("Result of Task " + (i + 1) + ": " + result);
        }
        executor.shutdown();
    }
}
