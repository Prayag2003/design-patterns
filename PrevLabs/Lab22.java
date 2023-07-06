package PrevLabs;
import java.util.TreeSet;

class Shop 
{
    private String shopName;
    private Product product;
    TreeSet<Product> products = new TreeSet<>();

    public int generateBill(int qty) {
        return qty;
    }

    public void listProducts() {
        for (Product number : products) {
            System.out.println(number);
        }
    }

    public void addProducts(Product product) {
        products.add(product);
    }

    public String getShopName(String name) {
        return shopName;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopName='" + shopName + '\'' +
                ", product=" + product +
                ", products=" + products +
                '}';
    }
}

class Product implements Comparable {
    private static int count = 1;
    private String name;
    private int id;
    private int price;

    int discount = 10;

    {
        id = count;
        count++;
    }

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() 
    {
        return price;
    }

    public void setPrice(int price) 
    {
    }

    @Override
    public String toString() 
    {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id + ", price=" + getPrice() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Product p = (Product) o;
        return this.name.compareTo(p.name);
    }

}

class OldProduct extends Product {
    OldProduct(String name, int price) {
        super(name, price);

    }
}

class NewProduct extends Product {
    NewProduct(String name, int price) {
        super(name, price);
    }

}

public class Lab22 {
    public static void main(String[] args) {

        Shop s1 = new Shop();

        Product Waffer = new OldProduct("Waffer", 10);
        Product Biscuit = new OldProduct("Biscuit", 50);
        Product Shampoo = new OldProduct("Shampoo", 60);
        Product Gold = new NewProduct("Gold", 90);
        Product IceCream = new NewProduct("IceCream", 80);

        s1.addProducts(Waffer);
        s1.addProducts(Biscuit);
        s1.addProducts(Shampoo);
        s1.addProducts(Gold);
        s1.addProducts(IceCream);

        s1.listProducts();

    }
}