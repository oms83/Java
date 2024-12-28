package Factory;

public class AnimalEx {
    public static class AnimalFactory {
        enum enType{dog, cat, duck}
        public static IAnimal getAnimals(enType en)
        {
            switch(en)
            {
                case dog:
                    return new Dog();
                case cat:
                    return new Cat();
                case duck:
                    return new Duck();
                default:
                    return null;
            }
        }
    }

    public static  interface IAnimal  {
        public void Speak();
    }

    public static class Dog implements IAnimal {
        @Override
        public void Speak() {
            System.out.println("Havv");
        }
    }

    public static class Cat implements IAnimal {
        @Override
        public void Speak() {
            System.out.println("Meyo");
        }
    }

    public static class Duck implements IAnimal {
        @Override
        public void Speak() {
            System.out.println("kak");
        }
    }

    public static void main(String[] args) {
        IAnimal animal = AnimalFactory.getAnimals(AnimalFactory.enType.cat);
        animal.Speak();
        animal = AnimalFactory.getAnimals(AnimalFactory.enType.duck);
        animal.Speak();
        animal = AnimalFactory.getAnimals(AnimalFactory.enType.dog);
        animal.Speak();
    }
}
