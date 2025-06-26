package Abstract;

 class Circle extends Shape{


    double radius;

     Circle(int radius) {
         this.radius = radius;
     }

     @Override
     double calculateArea() {
         double area = Math.PI*radius*radius;
         System.out.println("Area of circle : "+area);

         return area;

     }

     @Override
     double calculatePerimeter() { double peri = 2*Math.PI*radius;
         System.out.println("Area of perimeter : "+peri);
         return peri;
     }


}
