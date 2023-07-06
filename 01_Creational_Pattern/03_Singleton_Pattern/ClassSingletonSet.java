// SingleTon Design

// Solution Architect
// restriction on creation of the objects
// Private Constructor
// One Single Object
// private static variable of the same class that is the only instance of the class

// examples is logging softwares 

class singletonInstance {

    // Eager Initialization of SingleTon
    // Method - 1
    private static singletonInstance st = new singletonInstance();
    // private static singletonInstance st = null;

    // Method - 2
    // // can be also done by Static Block ( singleTon implementation)
    // static
    // {
    // st = new singletonInstance();
    // }

    // Method - 3

    private singletonInstance() {
        System.out.println(" Creating Single Instance ... ");
    }

    public static singletonInstance getInstance() {

        if (st == null) {
            st = new singletonInstance();
        }
        return st;
    }

    public void printing(String string) {

    }

}

public class ClassSingletonSet {

    public static void main(String[] args) {
        singletonInstance s1 = singletonInstance.getInstance();
        singletonInstance s2 = singletonInstance.getInstance();

        s1.printing("Welcome !!!");
        System.out.println(s1);
        System.out.println(s2);
    }
}
