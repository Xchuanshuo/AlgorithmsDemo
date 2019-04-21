package lintcode;

/**
 * @author Legend
 * @data by on 19-4-21.
 * @description shape-factory
 */
public class Test497 {

    interface Shape {
        void draw();
    }

    class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("----");
            System.out.println("|    |");
            System.out.println(" ----");
        }
    }

    class Square implements Shape {
        @Override
        public void draw(){
            System.out.println(" ----");
            System.out.println("|    |");
            System.out.println("|    |");
            System.out.println(" ----");
        }
    }

    class Triangle implements Shape {
        @Override
        public void draw(){
            System.out.println("  /\\");
            System.out.println(" /  \\");
            System.out.println("/____\\");
        }
    }

    public class ShapeFactory {

        public Shape getShape(String shapeType) {
            // Write your code here
            switch (shapeType) {
                case "Square": return new Square();
                case "Triangle": return new Triangle();
                case "Rectangle": return new Rectangle();
            }
            return null;
        }
    }
}
