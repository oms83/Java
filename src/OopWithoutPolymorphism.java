public class OopWithoutPolymorphism {

    public static class Shape
    {
        private int x;

        public Shape(int x)
        {
            this.x = x;
        }

        public void SquareArea(int x)
        {
            System.out.println("Square area of " + x + " is " + this.x * this.x);
        }

        public void CircleArea(int x)
        {
            System.out.println("Circle area of " + x + " is " + this.x * this.x * Math.PI);
        }
    }

    public static void main(String[] args) {

        Shape s = new Shape(5);
        s.SquareArea(5);
        s.CircleArea(5);

    }
}
