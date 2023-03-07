
public class StockControl {

    private int skates;
    private int helmet;
    private int penguin;
    private int gloves;

    StockControl(int s, int h, int p, int g) {
        skates = s;
        helmet = h;
        penguin = p;
        gloves = g;
    }

    synchronized void VisitorArrive(String VisitorName, int vSkates, int vHelmet, int vPenguin, int vGloves) throws InterruptedException {
        System.out.println("Visotor " + VisitorName + " requested: "+ " skates: " + vSkates + ", helmet: " + vHelmet
                + ", gloves: " + vGloves + ", penguin: " + vPenguin);

        while ((vSkates == 1 && skates == 0)
                || (vGloves == 1 && gloves == 0)
                || (vHelmet == 1 && helmet == 0)
                || (vPenguin == 1 && penguin == 0)) {
            System.out.println("Visotor " + VisitorName + " decided to wait when things are returned");
//            if () nie ma lyzew to idz do queue
            wait();
        }

        if (vSkates == 1) {
            --skates;
        }
        if (vGloves == 1) {
            --gloves;
        }
        if (vHelmet == 1) {
            --helmet;
        }
        if (vPenguin == 1) {
            --penguin;
        };
        System.out.println("Visotor " + VisitorName + " borrowed: " + " skates: " + vSkates + ", helmet: " + vHelmet
                + ", gloves: " + vGloves + ", penguin: " + vPenguin);
        System.out.println("            Available now: skates " + getSkates()
                + ", helmets: " + getHelmet()
                + ", gloves: " + getGloves()
                + ", penguins: " + getPenguin());

        notifyAll();
    }

    synchronized void VisitorDepart(String VisitorName, int vSkates, int vHelmet, int vPenguin, int vGloves) throws InterruptedException {
        while ((vSkates > 0 && skates == 0)
                && (vGloves > 0 && gloves == 0)
                && (vHelmet > 0 && helmet == 0)
                && (vPenguin > 0 && penguin == 0)) {
            wait();
        }
        if (vSkates == 1) {
            ++skates;
        }
        if (vGloves == 1) {
            ++gloves;
        }
        if (vHelmet == 1) {
            ++helmet;
        }
        if (vPenguin == 1) {
            ++penguin;
        };
        notifyAll();
        System.out.println("Visotor " + VisitorName + " returned: " + " skates: " + vSkates + ", helmet: " + vHelmet
                + ", gloves: " + vGloves + ", penguin: " + vPenguin);

    }

    public int getSkates() {
        return skates;
    }

    public int getGloves() {
        return gloves;
    }

    public int getHelmet() {
        return helmet;
    }

    public int getPenguin() {
        return penguin;
    }
}
