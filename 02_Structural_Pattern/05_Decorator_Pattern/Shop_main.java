
interface Ecom {
    public int price();
}

class Mobile implements Ecom {
    @Override
    public int price() {
        return 10000;
    }
}

class Headphones implements Ecom {
    @Override
    public int price() {
        return 2000;
    }
}

class Shoes implements Ecom {
    @Override
    public int price() {
        return 3000;
    }
}

class EDecorator implements Ecom {

    protected Ecom em;

    public EDecorator(Ecom em) {
        this.em = em;
    }

    @Override
    public int price() {
        return em.price();
    }

}

class GiftWrap extends EDecorator {

    public GiftWrap(Ecom em) {
        super(em);
    }

    @Override
    public int price() {
        return (int) (1.1 * super.price());
    }
}

class Discount extends EDecorator {

    public Discount(Ecom em) {
        super(em);
    }

    @Override
    public int price() {
        return (int) (0.9 * super.price());
    }
}

public class Shop_main {

    public static void main(String[] args) {

        // E - COMMERCE
        // MOBILE
        System.out.println();
        Ecom mobile = new Mobile();
        System.out.println("The Price of Mobile is = " + mobile.price());

        Ecom mobileOnDiscount = new Discount(mobile);
        System.out.println("Mobile On 10% Discount is = " + mobileOnDiscount.price());

        Ecom mobileWithGiftWrap = new GiftWrap(mobile);
        System.out.println("Mobile Price with Gift Wrap is = " + mobileWithGiftWrap.price());

        // HEADPHONES
        System.out.println();
        Ecom boatHeadPhones = new Headphones();
        System.out.println("The Price of Boat Headphones is = " + boatHeadPhones.price());

        Ecom boatHeadPhonesOnDiscount = new Discount(boatHeadPhones);
        System.out.println("Boat Headphones On 10% Discount is = " + boatHeadPhonesOnDiscount.price());

        Ecom boatHeadPhonesWithGiftWrap = new GiftWrap(boatHeadPhones);
        System.out.println("Boat Headphones Price with Gift Wrap is = " + boatHeadPhonesWithGiftWrap.price());

        // SHOES
        System.out.println();
        Ecom nike = new Shoes();
        System.out.println("The Price of Nike Shoes is = " + nike.price());

        Ecom nikeOnDiscount = new Discount(nike);
        System.out.println("Nike Shoes On 10% Discount is = " + nikeOnDiscount.price());

        Ecom nikeWithGiftWrap = new GiftWrap(nike);
        System.out.println("Nike Shoes Price with Gift Wrap is = " + nikeWithGiftWrap.price());
        System.out.println();

    }
}
