class SeatReservation
{
    public static void main(String[] args)
    {
        Reservation reserve = new Reservation(); 
        Person thread1 = new Person(reserve, 5, 3 , 3, 1); 
        thread1.start();
        Person thread2 = new Person(reserve, 4 , 2 , 1 , 0);
        thread2.start();
        Person thread3 = new Person(reserve, 2 , 1 , 1, 3);
        thread3.start();
    }
}


class Person extends Thread
{

    Reservation reserve;
    int requestedSkates;
    int requestedGloves;
    int requestedHelmet;
    int requestedPenguin;

    public Person(Reservation reserve, int requestedSkates, int requestedGloves, int requestedHelmet, int requestedPenguin)
    {
        this.reserve = reserve;
        this.requestedSkates = requestedSkates;
        this.requestedGloves = requestedGloves;
        this.requestedHelmet = requestedHelmet;
        this.requestedPenguin = requestedPenguin;
    }

    @Override
    public void run() 
    {
        reserve.reserveSkates(requestedSkates);
        reserve.reserveGloves(requestedGloves);
        reserve.reserveHelmet(requestedHelmet);
        reserve.reservePenguin(requestedPenguin);
    }
}
