import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//INTRINSIC ITEMS
class SquareObjectFlyweight {
    String color;
    int length;

    SquareObjectFlyweight(String color, int length) {
        this.color = color;
        this.length = length;
    }
}

class SquareObjectFactory {
    Map<String, SquareObjectFlyweight> smap = new HashMap<>();

    SquareObjectFlyweight sfl = null;

    public SquareObjectFlyweight createObject(String type) {
        if (smap.containsKey(type)) {
            sfl = smap.get(type);
        } else if (type.equalsIgnoreCase("Blue")) {
            sfl = new SquareObjectFlyweight("Blue", 5);
        } else if (type.equalsIgnoreCase("Red")) {
            sfl = new SquareObjectFlyweight("Red", 3);
        } else if (type.equalsIgnoreCase("Green")) {
            sfl = new SquareObjectFlyweight("Green", 10);
        } else {
            System.out.println("Invalid Shape object...");
        }
        smap.put(type, sfl);
        return sfl;
    }
}

// INTRINSIC PROPERTY
class SquareDesign {
    int x;
    int y;
    String patternChoice;

    SquareObjectFlyweight sf;

    // PASSING THE FLYWEIGHT OBJECT TO IT
    SquareDesign(SquareObjectFlyweight sf) {
        this.sf = sf;
    }

    public void drawSquareShape(int x, int y, String patternChoice) {
        this.x = x;
        this.y = y;
        this.patternChoice = patternChoice;
        System.out.println("THe Square shape is drawn at : " + this.x + " , " + this.y + " with color " + sf.color +
                " with length : " + sf.length + " With pattern: " + this.patternChoice);
    }
}

class Fly2 {
    public static void main(String[] args) {
        // DEFINING THE OBJECT FOR THE FACTORY
        SquareObjectFactory sof = new SquareObjectFactory();

        for (int i = 0; i < 12; i++) {

            // GENERATING RANDOM NUMBERS
            Random rn = new Random();
            int ch = rn.nextInt(3) + 1;

            if (ch == 1) {
                SquareObjectFlyweight sfw = sof.createObject("Red");

                SquareDesign s1 = new SquareDesign(sfw);

                s1.drawSquareShape(i + 1, i, "Linear");
            } else if (ch == 2) {
                SquareObjectFlyweight sfw = sof.createObject("Blue");
                SquareDesign s1 = new SquareDesign(sfw);
                s1.drawSquareShape(i, i + 2, "Dotted");

            } else {
                SquareObjectFlyweight sfw = sof.createObject("Green");
                SquareDesign s1 = new SquareDesign(sfw);
                s1.drawSquareShape(i + 1, i + 1, "Cross");
            }
        }
    }
}