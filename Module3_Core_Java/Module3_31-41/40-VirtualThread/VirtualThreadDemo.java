import java.time.Duration;
import java.time.Instant;

public class VirtualThreadDemo {
    public static void main(String[] args) {
        int threadCount = 100_000;

        System.out.println("Starting " + threadCount + " virtual threads...");

        Instant start = Instant.now();

        for (int i = 0; i < threadCount; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread: " + Thread.currentThread());
            });
        }

        Instant end = Instant.now();
        System.out.println("All virtual threads started.");
        System.out.println("Time taken: " + Duration.between(start, end).toMillis() + " ms");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
