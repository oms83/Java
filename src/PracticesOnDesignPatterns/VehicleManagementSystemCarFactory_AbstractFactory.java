package PracticesOnDesignPatterns;

public class VehicleManagementSystemCarFactory_AbstractFactory {

    // abstract factory
    public static interface Vehicle
    {
        Engine getEngine();
        Tire getTire();
    }
    // product
    public static interface Engine
    {
        void ShowEngine();
    }
    // product
    public static interface Tire
    {
        void ShowTire();
    }
    // concrete product
    public static class CarTire implements Tire
    {
        @Override
        public void ShowTire() {
            System.out.println("Car Tire");
        }
    }
    // concrete product
    public static class CarEngine implements Engine
    {
        @Override
        public void ShowEngine() {
            System.out.println("Car Engine");
        }
    }
    // concrete product
    public static class MotorcycleTire implements Tire
    {
        @Override
        public void ShowTire() {
            System.out.println("Motorcycle Tire");
        }
    }
    // concrete product
    public static class MotorcycleEngine implements Engine
    {
        @Override
        public void ShowEngine() {
            System.out.println("Motorcycle Engine");
        }
    }
    // concrete factories
    public static class CarFactory implements Vehicle
    {
        @Override
        public Engine getEngine() {
            return new CarEngine();
        }

        @Override
        public Tire getTire() {
            return new CarTire();
        }
    }
    // concrete factories
    public static class MotorcycleFactory implements Vehicle
    {
        @Override
        public Engine getEngine() {
            return new MotorcycleEngine();
        }

        @Override
        public Tire getTire() {
            return new MotorcycleTire();
        }
    }

    public static void main(String[] args) {
        Vehicle carFactory = new CarFactory();
        Engine carEngine = carFactory.getEngine();
        Tire carTire = carFactory.getTire();
        carTire.ShowTire();
        carEngine.ShowEngine();

    }
}
