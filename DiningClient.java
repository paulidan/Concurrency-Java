
public class DiningClient extends Thread{
    
    private final DiningHall diningHall;

    public DiningClient(DiningHall diningHall) {
        this.diningHall = diningHall;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " going to take a seat");
        diningHall.getSeat();
        System.out.println(Thread.currentThread().getName() + " finished! ");
    } 
}
