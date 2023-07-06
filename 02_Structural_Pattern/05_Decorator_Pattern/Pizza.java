interface basePizza {
    public int cost();
}

class onlyBase implements basePizza {

    @Override
    public int cost() {
            return 250;
    }
}

class sevenCheese implements basePizza {

    @Override
    public int cost() {
            return 599;
    }
}

 class margherita implements basePizza {

    @Override
    public int cost() {
            return 299;
    }
}

abstract class decorator implements basePizza {
    protected basePizza bp;

    public decorator(basePizza bp) {
            this.bp = bp;
    }

    @Override
    public int cost() {
            return bp.cost();
    }
}

class cheese extends decorator {
    basePizza bp;

    public cheese(basePizza bp) {
            super(bp);
    }

    @Override
    public int cost() {
            return super.cost() + 70;
    }
}

class mushroom extends decorator {

    public mushroom(basePizza bp) {
            super(bp);
    }

    @Override
    public int cost() {
            return super.cost() + 50;
    }
}

public class Pizza {
    public static void main(String[] args) {

            basePizza pizza = new onlyBase();
            basePizza pizzaWithCheese = new cheese(pizza);
            basePizza pizzaWithMushroomAndExtraCheese = new cheese(new mushroom(pizza));
            basePizza pizzaWithMushroomAndExtraLargeCheese = new cheese(pizzaWithMushroomAndExtraCheese);

            System.out.println("Cost of Normal Pizza (Only Base and Simple Toppings ) = " + pizza.cost());

            System.out.println("Cost of Pizza Base with only Cheese as extra topping = " + pizzaWithCheese.cost());

            System.out.println(
                            "Cost of Pizza Base + Added Mushrooms + Extra Cheese  = "
                                            + pizzaWithMushroomAndExtraCheese.cost());

            System.out.println(
                            "Cost of Pizza Base + Added Mushrooms + Cheese Burst  = "
                                            + pizzaWithMushroomAndExtraLargeCheese.cost());

    }
}
