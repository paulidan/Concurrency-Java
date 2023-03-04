class Reservation
{

    static int availablePenguin = 10;
    static int availableHelmet = 10;
    static int availableSkates = 10;
    static int availableGloves = 10;

    
    synchronized void reserveSkates(int requestedSkates)
    {
        System.out.println(Thread.currentThread().getName() + " entered.");
        System.out.println("Available Skates : " + availableSkates + " Requested Skates : " + requestedSkates);
        if (availableSkates >= requestedSkates)
        {
            System.out.println("Skates Available. ");
            try
            {
                Thread.sleep(100);    
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted");
            }
            System.out.println(requestedSkates + " skates reserved.");
            availableSkates = availableSkates - requestedSkates;
        }
        else
        {
            System.out.println("Requested skates not available :-(");
        }
        System.out.println(Thread.currentThread().getName() + " leaving.");
    }
    
 synchronized void reserveGloves(int requestedGloves)
    {
        System.out.println(Thread.currentThread().getName() + " entered.");
        System.out.println("Available Gloves : " + availableGloves + " Requested Gloves : " + requestedGloves);
        if (availableGloves >= requestedGloves)
        {
            System.out.println("Gloves Available.");
            try
            {
                Thread.sleep(100);    
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted");
            }
            System.out.println(requestedGloves + " gloves reserved.");
            availableGloves = availableGloves - requestedGloves;
        }
        else
        {
            System.out.println("Requested gloves not available :-(");
        }
        System.out.println(Thread.currentThread().getName() + " leaving.");
    }
 synchronized void reserveHelmet(int requestedHelmet)
    {
        System.out.println(Thread.currentThread().getName() + " entered.");
        System.out.println("Available Gloves : " + availableHelmet + " Requested Gloves : " + requestedHelmet);
        if (availableHelmet >= requestedHelmet)
        {
            System.out.println("Gloves Available. ");
            try
            {
                Thread.sleep(100);    
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted");
            }
            System.out.println(requestedHelmet + " helmets reserved.");
            availableHelmet = availableHelmet - requestedHelmet;
        }
        else
        {
            System.out.println("Requested gloves not available :-(");
        }
        System.out.println(Thread.currentThread().getName() + " leaving.");
    }
synchronized void reservePenguin(int requestedPenguin)
    {
        System.out.println(Thread.currentThread().getName() + " entered.");
        System.out.println("Available Penguin : " + availablePenguin  + " Requested Penguin : " + requestedPenguin);
        if (availablePenguin  >= requestedPenguin)
        {
            System.out.println("Penguin Available. ");
            try
            {
                Thread.sleep(100);    
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted");
            }
            System.out.println(requestedPenguin + " penguin reserved.");
            availablePenguin = availablePenguin  - requestedPenguin;
        }
        else
        {
            System.out.println("Requested penguins not available :-(");
        }
        System.out.println(Thread.currentThread().getName() + " leaving.");
    }

}