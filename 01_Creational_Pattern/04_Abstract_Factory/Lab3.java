
public class Lab3 {
    public static void main(String[] args) {
        ArtStyleFactory art1 = new ArtStyleFactory();
        Chairs ch1 = art1.createChair();
        Table tb1 = art1.createTable();
        Sofa sf1 = art1.createSofa();

        System.out.println("\nChair Design is " + ch1.design());
        System.out.println("Table Design is " + tb1.design());
        System.out.println("Sofa Design is  " + sf1.design() + "\n");

        System.out.println("Chair Price is " + ch1.Price());
        System.out.println("Table Price is " + tb1.Price());
        System.out.println("Sofa Price is " + sf1.Price() + "\n");

    }
}