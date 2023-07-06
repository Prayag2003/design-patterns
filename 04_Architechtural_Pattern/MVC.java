
// divide the application into 3 units

// Models --> Business Logic , Data Processing Logic
// Views --> user Interface COmponenets
// Controllers -->tries the Communication btw models and views 

// helps designer to Parallellise the develiopment of the model

// JSP / View
// Controller --> Servlets ( handle req and provide responses)

class ProductModel {

    private int id;
    private int price;
    private String name;

    public ProductModel(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price - 10;
    }

    public void setId(int id) {
        this.id = id;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}

class ProductView {
    public void printProductDetails(int id, String name, int price) {
        System.out.println("\nProduct Details : \n  " + "\n[ \nPID :  " + id + " ,\n  Name : " + name +
                ",\n  Price : " + price + " \n]");
    }
}

class ProductController {

    ProductModel pm;
    ProductView pv;

    public ProductController(ProductModel pm, ProductView pv) {
        this.pm = pm;
        this.pv = pv;
    }

    public void setName(String name) {
        pm.setName(name);
    }

    public void setPrice(int price) {
        pm.setPrice(price);
    }

    public void updateProductView() {
        pv.printProductDetails(pm.getId(), pm.getName(), pm.getPrice());
    }
}

public class MVC {
    public static void main(String[] args) {
        ProductModel pm1 = new ProductModel(100, 300, "PR1");
        ProductView pv1 = new ProductView();

        pv1.printProductDetails(pm1.getId(), pm1.getName(), pm1.getPrice());
        ProductController pc = new ProductController(pm1, pv1);
        pc.setName("Product-New");
        pc.setPrice(500);

        pc.updateProductView();
    }
}
