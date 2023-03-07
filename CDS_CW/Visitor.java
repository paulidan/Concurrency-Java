
public class Visitor extends Thread {

    StockControl SC;
    int gloves;
    int helmet;
    int penguin;
    int skates;
    String name;

    public Visitor(StockControl SC, String visitorName, int g, int h, int p, int s) {
        this.SC = SC;
        this.name = visitorName;
        this.skates = s;
        this.helmet = h;
        this.gloves = g;
        this.penguin = p;
        
    }
    

    @Override
    public void run() {

        Long Skatingtime = (long) (Math.random() * 30);
        try {
            SC.VisitorArrive(this.name, this.skates, this.helmet, this.gloves, this.penguin);
            System.out.println("Visitor " + this.name + " will be skating for: " + Skatingtime + " minutes...");
            this.sleep(Skatingtime);
            System.out.println("Visitor " + this.name + " returns.");
            SC.VisitorDepart(this.name, this.skates, this.helmet, this.gloves, this.penguin);
            System.out.println("            Available now: skates " + SC.getSkates()
                    + ", helmets:" + SC.getHelmet()
                    + ", gloves:" + SC.getGloves()
                    + ", penguins:" + SC.getPenguin());
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
        
    }

}
