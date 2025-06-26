package Abstract;

public class RectangleClass extends Shape {
    double len;
    double width;
/*
    public Rectangle(double len, double width) {
        this.len = len;
        this.width = width;
    }*/

    public void setDimensions(double a, double b) {

        this.len = a;
        this.width = b;
    }

    public void setDimensions(double a) {
        this.len = a;
        this.width = a;
    }

    @Override
    double calculateArea() {
        double area = len * width;
        if (len == width) {
            System.out.println("Area of the Sqaure is :" + area);
        } else {
            System.out.println("Area of the Rectangle is :" + area);
        }

        return area;
    }

    @Override
    double calculatePerimeter() {
        double peri = 2 * (len + width);
        if (len == width) {
            System.out.println("Perimeter of the Sqaure is: " + peri);
        } else {
            System.out.println("Perimeter of the Rectangle is: " + peri);
        }
        return peri;
    }
}
