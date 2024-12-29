package PracticesOnDesignPatterns;

// builder design pattern
// online restaurant

// builder tasarim deseni karmasik nenelerin olusturmasni soyutlar ozellikle karmasik ozelliklere sahip
// olan siniflarda mudahele eder

// (cls) product -
// (interface create product) builder -
// (implement builder) concrete product -
// (create product and dependent to builder) director kavralmarindan olusuyor

public class OnlineRestaurant_Builder {

    // product
    public static class Meal
    {
        enum enSize {SMALL, MEDIUM, LARGE}
        enum enType {VEGGIE, NON_VEGGIE}
        enSize size;
        enType type;
        String sideItems;

        public void setSize(enSize size)
        {
            this.size = size;
        }

        public void setType(enType type)
        {
            this.type = type;
        }
        public void setSideItems(String sideItems)
        {
            this.sideItems = sideItems;
        }

        @Override
        public String toString() {
            return "Meal [size=" + size + ", type=" + type + ", sideItems=" + sideItems +"]";
        }
    }

    // builder
    public static interface MealBuilder
    {
        Meal getMeal();
        void buildType();
        void buildSideItems();
        void buildSize();
    }

    // product director
    public static class MealDirector
    {
        MealBuilder builder;
        public MealDirector(MealBuilder builder)
        {
            this.builder = builder;
        }

        public Meal constructMeal()
        {
            builder.buildSideItems();
            builder.buildSize();
            builder.buildType();
            return builder.getMeal();
        }
    }

    // concrete product
    public static class VegMealOne implements MealBuilder
    {
        Meal meal;
        public VegMealOne()
        {
            meal = new Meal();
        }

        @Override
        public void buildSideItems() {
            meal.setSideItems("Orange Juice");
        }
        public void buildType() {
            meal.setType(Meal.enType.VEGGIE); // we can set the parameter as string
        }
        public void buildSize() {
            meal.setSize(Meal.enSize.MEDIUM);
        }
        public Meal getMeal() {
            return meal;
        }
    }

    // concrete product
    public static class NonVegMealOne implements MealBuilder
    {
        Meal meal;
        public NonVegMealOne()
        {
            meal = new Meal();
        }

        @Override
        public void buildSideItems() {
            meal.setSideItems("coke");
        }
        public void buildType() {
            meal.setType(Meal.enType.NON_VEGGIE); // we can set the parameter as string
        }
        public void buildSize() {
            meal.setSize(Meal.enSize.MEDIUM);
        }
        public Meal getMeal() {
            return meal;
        }
    }

    public static void main(String[] args) {
        MealBuilder builder = new VegMealOne();
        MealDirector director = new MealDirector(builder);
        Meal meal = director.constructMeal();
        System.out.println(meal);

        builder = new NonVegMealOne();
        director = new MealDirector(builder);
        meal = director.constructMeal();
        System.out.println(meal);
    }

}

