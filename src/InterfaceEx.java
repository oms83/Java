public class InterfaceEx {

    public static interface IFlyable
    {
        public void fly();
    }

    public static class Bird implements IFlyable
    {
        @Override
        public void fly() {
            System.out.println("Bird fly");
        }
    }

    public static class Airplane implements IFlyable
    {
        @Override
        public void fly() {
            System.out.println("Airplane fly");
        }
    }

    public static class Rocket implements IFlyable
    {
        @Override
        public void fly() {
            System.out.println("Rocket fly");
        }
    }

    public static void main(String[] args) {
        IFlyable bird = new Bird();
        IFlyable airplane = new Airplane();
        IFlyable rocket = new Rocket();

        bird.fly();
        airplane.fly();
        rocket.fly();
    }
}
