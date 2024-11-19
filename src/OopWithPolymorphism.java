public class OopWithPolymorphism {
    public static abstract class Shape
    {
//        public void CalcArea(int x)
//        {
//
//        }
        public abstract void CalcArea(int x);
    }

    public static class Square extends Shape
    {
        int x;
        public Square(int x) {
            this.x = x;
        }

        public void CalcArea(int x)
        {
            System.out.println("Square area of " + x + " is " + this.x * this.x);
        }
    }

    public static class Circle extends Shape
    {
        int x;
        public Circle(int x) {
            this.x = x;
        }

        @Override
        public void CalcArea(int x)
        {
            System.out.println("Circle area of " + x + " is " + this.x * this.x * Math.PI);
        }
    }

    public static class Calculator {
        // Method to add two integers
        public int add(int a, int b) {
            return a + b;
        }

        // Overloaded method to add three integers
        public int add(int a, int b, int c) {
            return a + b + c;
        }
    }
    public static void main(String[] args) {


        /*
            Runtime Polymorphism (Method Overriding):

            - Occurs when a subclass provides a specific implementation of a method that is already defined in its superclass.
            - The method to be executed is determined at runtime based on the object's actual type, not the reference type.
            - To achieve runtime polymorphism, the method in the subclass must have the same signature as the method in the
              superclass, and the subclass must use the @Override annotation (optional but recommended).
        */

        Square square = new Square(5);
        Circle circle = new Circle(5);

        square.CalcArea(5);
        circle.CalcArea(5);


        /*
            Compile-time Polymorphism (Method Overloading):

            Occurs when multiple methods have the same name but differ in parameters (either the number of parameters or
            the type of parameters).
            The method to be called is determined at compile time based on the method signature.
        */

        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10)); // Calls add(int, int)
        System.out.println(calc.add(5, 10, 15)); // Calls add(int, int, int)
    }
}
