
import java.util.Random;
import java.lang.Math;

public class MainIceRink {

    public static void main(String args[]) {

        Random rn = new Random();
        int visitors = 5;
        int seats = 20;

        StockControl SC = new StockControl(3, 3, 3, 3);
        Thread arrayIceSkating[] = new Thread[visitors];

        DiningHall diningHall = new DiningHall(seats);
        Thread arrayDiningHall[] = new Thread[visitors];

//
//        for (int i = 0; i < arrayIceSkating.length; i++) {
//            String VisitorName = Integer.toString(i);
//            arrayIceSkating[i] = new Thread(new Visitor(SC, VisitorName,
//                    (int) Math.round(Math.random()), (int) Math.round(Math.random()),
//                    (int) Math.round(Math.random()), 1));
//            arrayIceSkating[i].start();
//        }
        for (int i = 0; i < visitors; i++) {
            arrayDiningHall[i] = new Thread(new DiningClient(diningHall) + "Thread " + i);
        }

        for (int i = 0; i < visitors; i++) {
            arrayDiningHall[i].start();
        }
    }
}
