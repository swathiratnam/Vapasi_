package com.shape;

public class TriangleClass extends Shape {

    double side1;
    double side2;
    double side3;

    public TriangleClass(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        double a = s * (s - side1) * (s - side2) * (s - side3);
        double area = Math.sqrt(a);

        System.out.println("Area of the triangle is " + area);
        //√[s(s-a)(s-b)(s-c)]

        return area;
    }

    @Override
    public double calculatePerimeter() {

        double peri = side1 + side2 + side3;
        System.out.println("Perimeter of Triangle is :" + peri);
        return peri;
    }
}
