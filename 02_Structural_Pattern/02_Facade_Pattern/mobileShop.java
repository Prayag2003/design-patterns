
interface mobile 
{
    public abstract void getDescription();
    public abstract int getPrice();
}

class ShopKeeper {
    private mobile Samsung;
    private mobile Apple;
    private mobile IPhone;

    public ShopKeeper() {
        this.Samsung = new Samsung();
        this.Apple = new Apple();
        this.IPhone = new IPhone();
    }

    public void getSamsung() {
        this.Samsung.getDescription();
        this.Samsung.getPrice();

    }

    public void getApple() {
        this.Apple.getDescription();
        this.Apple.getPrice();

    }

    public void getIPhone() {
        this.IPhone.getDescription();
        this.IPhone.getPrice();

    }

}

class Samsung implements mobile {
    public void getDescription() {
        System.out.println("Samsung has a really cool Camera and it's Long-Lasting !! ");
    }

    public int getPrice() {
        return 150000;
    }
}

class Apple implements mobile {
    public void getDescription() {
        System.out.println("Apple has a High Mexa-Pixel Camera and it's has high performance !! ");
    }

    public int getPrice() {
        return 200000;
    }
}

class IPhone implements mobile {
    public void getDescription() {
        System.out.println("IPhone has a really Camera and High Battery Performance and long lasting  !! ");
    }

    public int getPrice() {
        return 250000;
    }
}

public class mobileShop {
    public static void main(String[] args) {
        ShopKeeper skp = new ShopKeeper();
        skp.getApple();
        skp.getSamsung();
        skp.getIPhone();
    }
}
