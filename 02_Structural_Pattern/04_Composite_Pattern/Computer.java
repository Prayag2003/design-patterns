
// package COMPOSITE_METHOD;
import java.util.List;
import java.util.ArrayList;

// Complex order since it consists many of the things ,,, mant things are inside the Big Box

// Relational Objects are kept under same box , also bill is generated after the end

// Box contains Box
// Tree Data Structure
// Composite lets client treat individual objects and compositions of objects uniformly ( eg : GetPrice() at either leaf node or anywhere )

// This is know as a "Has-A " relationship between objects

//  Component ( can be interface or abstract class , single or complex obj)

//  Leaf ()

//  Composite ( container , maintains the leafs , Children is arraylist of Component )

//  Client

abstract class Component {

    protected String name;

    public Component(String n) {
        name = n;
    }

    public abstract void describeComponent();

    public abstract int getPrice();

}

class Leaf extends Component {

    protected int price;

    public Leaf(String n, int p) {
        super(n);
        price = p;
    }

    // implementation of describeComponent
    public void describeComponent() {
        System.out.println(name);
    }

    public int getPrice() {
        return price;
    }

}

// composite contains other components
class Composite extends Component {
    List<Component> list = new ArrayList<Component>();

    public Composite(String n) {
        super(n);
    }

    /* add a new Component */
    public void addComponent(Component typeComponent) {
        list.add(typeComponent);
    }

    /* remove an existing Component */
    public void removeComponent(Component typeComponent) {
        list.remove(typeComponent);
    }

    /* similar to vector<int> */
    public List<Component> componentList() {
        return list;
    }

    public void describeComponent() {
        System.out.println(name);

        /* Traversing the list to get the names of the leaf and get their price */

        /* deligating the work */
        for (Component c : list) {
            c.describeComponent();
        }
    }

    public int getPrice() {
        int price = 0;
        for (Component c : list) {
            price += c.getPrice();
        }
        return price;
    }

}

public class Computer {
    public static void main(String[] args) {

        Component l1 = new Leaf("HDD", 1000);
        Component l2 = new Leaf("RAM", 2000);
        Component l3 = new Leaf("CPU", 3000);
        Component l4 = new Leaf("Mouse", 4000);
        Component l5 = new Leaf("Keyboard", 5000);

        Composite c1 = new Composite("Computer");
        Composite c2 = new Composite("Cabinet");
        Composite c3 = new Composite("Peripheral");
        Composite c4 = new Composite("MotherBoard");

        c1.addComponent(c2);
        c1.addComponent(c3);

        c2.addComponent(l1);
        c2.addComponent(c4);

        c3.addComponent(l4);
        c3.addComponent(l5);

        c4.addComponent(l3);
        c4.addComponent(l2);

        System.out.println("The HDD Leaf consists of : ");
        l1.describeComponent();
        System.out.println();
        System.out.println("The MotherBoard Leaf consists of : ");
        c4.describeComponent();
        System.out.println();

        System.out.println("Cost of Cabinet and HDD along with MotherBoard is : " + c2.getPrice());
        System.out.println("Cost of Peripheral devices in addition to Mouse and KeyBoard is : " + c3.getPrice());
        System.out.println("Cost of Computer alongside Cabinet and Peripheral is : " + c1.getPrice());
        System.out.println();
    }
}
