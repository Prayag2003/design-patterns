package ABS_FACTORY;

public class ArtStyleFactory implements Abs_Furniture_Factory {

    public Chairs createChair() {
        return new ArtChair();
    }

    public Table createTable() {
        return new ArtTable();

    }

    public Sofa createSofa() {
        return new ArtSofa();
    }

}
