package ABS_FACTORY;


// INTERFACES OF CHAIR, TABLE and SOFA
interface Sofa {
    int Price();

    String design();

    int seat();
}

interface Table {
    int Price();

    String design();

    int Num_Table();
}

interface Chairs {
    int Price();

    String design();

    int Num_Chairs();
}

// Concrete Classes of Sofa ,Table , Chairs respectively

class OfficeChair implements Chairs {
    @Override
    public int Price() {
        return 2000;
    }

    public String design() {
        return "Office Chair";
    }

    public int Num_Chairs() {
        return 10;
    }

}

class ArtChair implements Chairs {
    @Override
    public int Price() {
        return 3000;
    }

    public String design() {
        return "Art Chair";
    }

    public int Num_Chairs() {
        return 2;
    }

}

class OfficeSofa implements Sofa {
    @Override
    public int Price() {
        return 2000;
    }

    public String design() {
        return "Office Sofa";
    }

    public int seat() {
        return 10;
    }

}

class ArtSofa implements Sofa {
    @Override
    public int Price() {
        return 20000;
    }

    public String design() {
        return "Artistic Sofa";
    }

    public int seat() {
        return 1;
    }
}

class OfficeTable implements Table {
    @Override
    public int Price() {
        return 2000;
    }

    public String design() {
        return "Office Chair";
    }

    public int Num_Table() {
        return 10;
    }

}

class ArtTable implements Table {
    @Override
    public int Price() {
        return 4000;
    }

    public String design() {
        return "Art Chair";
    }

    public int Num_Table() {
        return 5;
    }
}

interface Abs_Furniture_Factory {
    Chairs createChair();

    Table createTable();

    Sofa createSofa();
}

// Concrete Classes of Factory
class Abs_Office_Fac implements Abs_Furniture_Factory {

    public OfficeChair createChair() {
        return new OfficeChair();
    }

    public OfficeTable createTable() {
        return new OfficeTable();

    }

    public OfficeSofa createSofa() {
        return new OfficeSofa();
    }
}

class ArtStyleFactory implements Abs_Furniture_Factory {

    public ArtChair createChair() {
        return new ArtChair();
    }

    public ArtTable createTable() {
        return new ArtTable();

    }

    public ArtSofa createSofa() {
        return new ArtSofa();
    }

}