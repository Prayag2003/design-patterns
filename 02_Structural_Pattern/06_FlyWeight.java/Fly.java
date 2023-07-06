import java.util.*;

// Some app may or may not work 
// Reduce number of objects
// Applcable when we have bery large number of objects 
// in gaming type of applications ,GUI Based
// Graphical space , eg : tree

// tree{
//     string type;
//     string colour;
//     int height;
//     int x ,y;
// }

// issues many be there when RAM is unable to store that much objects

// divide the weight of the objects into two parts
// some portion of the tree is used repeatedly ( sharable )
// Intrinsic Property ---> which is sharable ( colour , height )
// Extrinsic Property ---> which is specific ( location ) , coming the client side at the time of execution/fly.

// Keeps memory consumption low
// immutable
// UML 

class TreeFlyWeight {

    String type; // sharable
    String color;

    public TreeFlyWeight(String type, String color) {
        this.type = type;
        this.color = color;
    }
}

class Tree {

    // referring the treeflyweight
    TreeFlyWeight tf;
    int x, y;

    public Tree(TreeFlyWeight t) {
        System.out.println("Tree Object Created !!! ");
        tf = t;
    }

    public void plantTree(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Tree Type ---> " + tf.type + " ---> Planted at X : " + x + " and Y : " + y);
    }
}

class TreeFactory {

    Map<String, TreeFlyWeight> mp = new HashMap<String, TreeFlyWeight>();
    TreeFlyWeight tf = null;

    public TreeFlyWeight createTree(String type) {

        if (mp.containsKey(type)) {
            tf = mp.get(type);
        } else {
            if (type.equalsIgnoreCase("Neem-Tree")) {
                tf = new TreeFlyWeight("Neem-Tree", "Green");
            } else if (type.equalsIgnoreCase("Oak-Tree")) {
                tf = new TreeFlyWeight("Oak-Tree", "Orange");
            }
            else {
                System.out.println("Tree-Type not available ! ");
            }
            mp.put(type, tf);
        }
        return tf;
    }
}

class Fly {
    public static void main(String[] args) {
        // For Loop for N Times
        // as N is increasing , Issues may occur , hence we divide the object

        int n = 10;
        // Creating an array
        String arr[] = new String[2];
        arr[0] = "Neem-Tree";
        arr[1] = "Oak-Tree";

        for (int i = 0; i < n; i++) {
            TreeFactory TreeF = new TreeFactory();
            int rand = (int) ((Math.random() * 10) % 2);
            int X = (int) (Math.random() * 10);
            int Y = (int) (Math.random() * 10);

            Tree t = new Tree(TreeF.createTree(arr[rand]));
            t.plantTree(X, Y);
        }
    }
}
