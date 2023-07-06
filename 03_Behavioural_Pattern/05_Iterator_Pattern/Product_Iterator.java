import java.util.*;

// TODO:
// 1) Base class
// 2) Iterator Collection --> interface (type of iterators , like < 2000) ( hasNext() and getNext() ) 
// 3) Product Collection ( define the type of collection --> then add and remove methods in the collection )
// 4) Product/Channel Iterator --> Concrete Classes which implements Iterator 
// 5) Test Class
// TODO:

interface Store {
    public boolean hasNext();

    public Product getNext();
}

class Product {
    int id;
    int price;
    String type;

    public Product(int id, int price, String type) {
        this.id = id;
        this.price = price;
        this.type = type;
    }

    public String toString() {
        return "[ \n\nThe ID is " + id + "\nType is : " + type + "\nPrice is " + price + "\n] \n";
    }
}

class ProductCollection {
    List<Product> ls = new ArrayList<Product>();

    public List<Product> getList() {
        return ls;
    }

    public void addProduct(Product p) {
        ls.add(p);
    }

    public void removeProduct(Product p) {
        ls.remove(p);
    }

    public ProductIterator getIterator() {
        // returning the Object of the ProductIterator and having the reference of the
        // Current Class
        return new ProductIterator(this);
    }

}

class ProductIterator implements Store {
    // getting the reference of the Collection and List of Products
    ProductCollection pc;
    List<Product> ls;
    int index = 0;

    // passing the reference of the Collection and LIst of Products into the
    // Constructor of ProductIterator
    public ProductIterator(ProductCollection pc) {
        this.pc = pc;
        this.ls = pc.getList();
    }

    // getNext
    public Product getNext() {
        Product P = ls.get(index);
        index++;
        return P;
    }

    public boolean hasNext() {
        Product P = ls.get(index);
        // Customised Iterator
        boolean curr = (index < ls.size() && P.type.equalsIgnoreCase("Nuclear")) ? true : false;
        return curr;
    }
}

public class Product_Iterator {
    public static void main(String[] args) {
        Product p1 = new Product(1, 590000, "Nuclear");
        Product p2 = new Product(2, 2000000, "Chemical");
        Product p3 = new Product(3, 1000000000, "Zola Algorithm");
        Product p4 = new Product(4, 10000000, "Extremis");

        ProductCollection pc = new ProductCollection();
        pc.addProduct(p1);
        pc.addProduct(p2);
        pc.addProduct(p3);
        pc.addProduct(p4);

        // Standard Iterator
        ProductIterator currIterator = pc.getIterator();
        while (currIterator.hasNext()) {
            System.out.println(currIterator.getNext());
        }
    }
}
