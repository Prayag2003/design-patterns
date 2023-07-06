interface basePizza {
    public int cost();
}

class onlyBase implements basePizza {
    public int cost() {
        return 200;
    }
}

class cheesePizza implements basePizza {
    public int cost() {
        return 300;
    }
}

class sevenCheese implements basePizza {
    public int cost() {
        return 600;
    }
}

abstract class Decorator implements basePizza {
    protected basePizza bp;

    public Decorator(basePizza bp) {
        this.bp = bp;
    }

    @Override
    public int cost() {
        return bp.cost();
    }
}

class Mushrooms extends Decorator {
    basePizza bp;

    public Mushrooms(basePizza bp) {
        super(bp);
    }

    @Override
    public int cost() {
        return bp.cost() + 50;
    }
}

public class Temp {
    public static void main(String[] args) {

        basePizza bp = new onlyBase();
        System.out.println(bp.cost());
        basePizza bpWithMushrooms = new Mushrooms(bp);
        System.out.println(bpWithMushrooms.cost());

    }

}
