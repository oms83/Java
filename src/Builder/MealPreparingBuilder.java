package Builder;

public class MealPreparingBuilder {

    public static class Meal
    {
        public String burger;
        public String drink;
        public String sideItem;

        public void setBurger(String burger) {
            this.burger = burger;
        }
        public void setDrink(String drink) {
            this.drink = drink;
        }
        public void setSideItem(String sideItem) {
            this.sideItem = sideItem;
        }
        @Override
        public String toString() {
            return "Meal [Burger=" + burger + ", Drink=" + drink + ", Side Item=" + sideItem + "]";
        }
    }


    public static interface MealBuilder
    {
        Meal buildMeal();
        void buildBurger();
        void buildDrink();
        void buildSideItem();
    }

    public static class VegBurgerMeal implements MealBuilder
    {
        private Meal meal;

        public VegBurgerMeal() {
            this.meal = new Meal();
        }

        @Override
        public Meal buildMeal() {
            return meal;
        }

        @Override
        public void buildBurger() {
            meal.setBurger("Veggie Burger");
        }

        @Override
        public void buildDrink() {
            meal.setDrink("Orange Juice");
        }

        @Override
        public void buildSideItem() {
            meal.setSideItem("Salad");
        }
    }

    public static class NonVegBurgerMeal implements MealBuilder
    {
        private Meal meal;
        public NonVegBurgerMeal() {
            meal = new Meal();
        }

        @Override
        public void buildSideItem() {
            meal.setSideItem("Fries");
        }

        @Override
        public void buildDrink() {
            meal.setDrink("Coke");
        }

        @Override
        public void buildBurger() {
            meal.setBurger("Chicken Burger");
        }

        @Override
        public Meal buildMeal() {
            return meal;
        }
    }
    public static class MealDirector
    {
        private MealBuilder mealBuilder;

        public MealDirector(MealBuilder mealBuilder) {
            this.mealBuilder = mealBuilder;
        }

        public Meal buildMeal() {
            mealBuilder.buildBurger();
            mealBuilder.buildDrink();
            mealBuilder.buildSideItem();
            return mealBuilder.buildMeal();
        }
    }

    public static void main(String[] args) {
        MealBuilder mealBuilder = new VegBurgerMeal();
        MealDirector mealDirector = new MealDirector(mealBuilder);
        Meal meal = mealDirector.buildMeal();
        System.out.println("Veg Meal: " + meal);

        System.out.println("----------------");

        mealBuilder = new NonVegBurgerMeal();
        mealDirector = new MealDirector(mealBuilder);
        meal = mealDirector.buildMeal();
        System.out.println("Non Veg Meal: " + meal);
    }

}
