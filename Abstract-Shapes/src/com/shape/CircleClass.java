package com.shape;

public class CircleClass extends Shape {


    double radius;

    public CircleClass(int radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of circle : " + area);

        return area;

    }

    @Override
    public double calculatePerimeter() {
        double peri = 2 * Math.PI * radius;
        System.out.println("Area of perimeter : " + peri);
        return peri;
    }


}
