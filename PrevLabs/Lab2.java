// going to a shop ,  buy products , generate bills
// Class SHOP 
// Class Generic Product --> Abstract --> old and new Product 
// Sort Products on Prices , Names
// Tell product having highest ,  lowest price ...
// Tree set  , Comparator and Comparable Interface
package PrevLabs;
import java.util.*;

class shop 
{
    private String shopName;
    private Product product;
    TreeSet<Product> product_Tree = new TreeSet<>();

    shop(String name) 
    {
        this.shopName = name;
    }

    String getName() 
    {
        return shopName;
    }

    void setName(String s) 
    {
        this.shopName = s;
    }

    public void listPrice() 
    {
        for (Product number : product_Tree) 
        {
            System.out.println(number);
        }
    }
    public void addProducts(Product product)
    {
        // Product.add(product);
    }

    public void generate_Bill(Product product) 
    {
        this.product = product;
    }

}

class Product implements Comparable 
{
    String name;
    int id;
    int price;

    Product(String name, int id, int price) 
    {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public int getPrice(Product product) 
    {
        return price;
    }

    public int compareTo(Object o) 
    {
        Product p = (Product) o;
        return this.price - p.price;
    }
}

class OldProduct extends Product {
    OldProduct(String name, int id, int price) {
        super(name, id, price);
    }

    int discountedPrice(Product product) {
        int discount = ((90) * getPrice(product)) / 100;
        return discount;
    }
}

class NewProduct extends Product {
    NewProduct(String name, int id, int price) {
        super(name, id, price);
    }
}

public class Lab2 {
    public static void main(String[] args) {

        shop Amul = new shop(" Amul ");

        Product milk = new Product("Milk", 10, 24);
        Product toast = new Product("Toast", 11, 60);
        Product cake = new Product("Cake", 12, 300);
        Product jam = new Product("Jam", 13, 50);
        Product cream = new Product("Cream", 14, 100);

        TreeSet<Product> tree = new TreeSet<>();

        tree.add(milk);
        tree.add(toast);
        tree.add(cake);
        tree.add(jam);
        tree.add(cream);

        Amul.listPrice();

    }
}