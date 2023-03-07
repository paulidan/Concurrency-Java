
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class DiningHall {
    
    private final Semaphore semaphore;

    public DiningHall(int size) {
        semaphore = new Semaphore(size);
    }

    public void getSeat() {
        try {
            semaphore.acquire();
            Long duration = (long) (Math.random() * 15);
            System.out.println(Thread.currentThread().getName()
                    + " using dining hall for " + duration
                    + " seconds, available seats now: "
                    + semaphore.availablePermits());
            Thread.sleep(duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " there are "
                    + semaphore.getQueueLength() + " clients waiting in the queue!");
            System.out.println(Thread.currentThread().getName() + " is returning ");
            semaphore.release();
        }
    }
}