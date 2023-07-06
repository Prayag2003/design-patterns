import java.util.ArrayList;
import java.util.List;

// Mediator Pattern reduces the chaotic dependencies between objects.
// THe pattern restricts the direct communication between the objecgts and
// forces them to communicate only via
// restricts the direct communication between the objects and forces them to
// communicate only via Mediator Object

// collegaue performs same responsisbility

// try to get for abstraction instead of implementation

interface MediatorEntity {
    public void registerBidder(CollegueEntity_Bidder bd);

    // search for the highest Bid Amount
    public void searchHighestBidAmount();

}

abstract class CollegueEntity_Bidder {
    MediatorEntity mde;
    String bName;
    int bPrice;

    public CollegueEntity_Bidder(MediatorEntity m, String name) {
        mde = m;
        bName = name;
    }

    public int getPrice() {
        return bPrice;
    }

    public String toString() {
        return "Bidder Name :  " + bName + "  is Bidding  : " + bPrice + "\n\n";
    }

    abstract public void bidAmount(int amount);
}

class Bidder1 extends CollegueEntity_Bidder {

    public Bidder1(MediatorEntity m, String name) {
        super(m, name);
    }

    public void bidAmount(int amount) {
        bPrice = amount;
    }
}

class AuctionerMediator implements MediatorEntity {
    List<CollegueEntity_Bidder> ls = new ArrayList<CollegueEntity_Bidder>();

    public void registerBidder(CollegueEntity_Bidder bd) {
        ls.add(bd);
    }

    public void searchHighestBidAmount() {
        int maxBid = 0;
        CollegueEntity_Bidder b = null;

        for (CollegueEntity_Bidder cb : ls) {
            if (cb.getPrice() > maxBid) {
                maxBid = cb.getPrice();
                b = cb;
            }
        }
        System.out.println("Winner of the auction :- \n " + b);
    }
}

public class Mediator {
    public static void main(String[] args) {
        MediatorEntity mediator = new AuctionerMediator();
        CollegueEntity_Bidder b1 = new Bidder1(mediator, "Bidder 1");
        CollegueEntity_Bidder b2 = new Bidder1(mediator, "Bidder 2");
        CollegueEntity_Bidder b3 = new Bidder1(mediator, "Bidder 3");

        System.out.println(" \n\n------------- Hello Everyone , welcome to Prayag's Auction ------------- ");

        mediator.registerBidder(b1);
        mediator.registerBidder(b2);
        mediator.registerBidder(b3);

        System.out.println("------------------- Everyone has registered--------------------\n");

        b1.bidAmount(5000);
        b2.bidAmount(2000);
        b3.bidAmount(6000);

        System.out.println(
                "------------------- The Bids are registered ------------- \n\n-------- Now it's time to Find the Winner ---------\n");
        mediator.searchHighestBidAmount();

    }
}

// ArmyUnits
// Commander -->
//