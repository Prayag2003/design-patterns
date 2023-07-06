
interface Shape {
    public abstract void draw();
}


class ShapeMaker {
    private Shape Rectangle;
    private Shape Circle;
    private Shape Sqaure;

    public ShapeMaker() {
        this.Rectangle = new Rectangle();
        this.Circle = new Circle();
        this.Sqaure = new Square();
    }

    public void drawRectangle() {
        this.Rectangle.draw();
    }

    public void drawCircle() {
        this.Circle.draw();
    }

    public void drawSquare() {
        this.Sqaure.draw();
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("A Circle is Drawn !! ");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("A Square is Drawn !! ");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("A Rectangle is Drawn !! ");
    }
}

public class Facade {
    public static void main(String[] args) {

        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
