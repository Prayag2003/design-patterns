
public class Abs_Office_Fac implements Abs_Furniture_Factory {

    public Chairs createChair() {
        return new OfficeChair();
    }

    public Table createTable() {
        return new OfficeTable();

    }

    public Sofa createSofa() {
        return new OfficeSofa();
    }

}
