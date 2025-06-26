package Abstract;

import java.util.ArrayList;
import java.util.List;

public class ShapeCalculator {

    public static void main(String[] args) {

        Shape circle = new Circle(3);
        Shape rect = new RectangleClass();
        RectangleClass r1 = new RectangleClass();
        r1.setDimensions(4);
        RectangleClass r2 = new RectangleClass();
        r2.setDimensions(4,6);
        Shape tri = new TriangleClass(3, 5, 6);
        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rect);
        shapes.add(tri);
        shapes.add(r1);
        shapes.add(r2);

        for (Shape s : shapes) {
            s.calculatePerimeter();
            s.calculateArea();

        }


    }
}
