package Final.DesignPatterns.Builder;

import java.util.ArrayList;
import java.util.List;

public class MealPreparing {

    public static class Meal {
        public String burger;
        public String Drink;
        public List<String> SideItems;

        public void setBurger(String burger) {
            this.burger = burger;
        }
        public void setDrink(String Drink) {
            this.Drink = Drink;
        }
        public void setSideItems(List<String> SideItems) {
            this.SideItems = SideItems;
        }

        @Override
        public String toString() {
            return "Burger: " + burger + ", Drink: " + Drink + ", SideItems: " + SideItems;
        }
    }
    public static interface MealBuilder {
        Meal buildMeal();
        MealBuilder buildBurger(String burger);
        MealBuilder buildDrink(String Drink);
        MealBuilder buildSideItems(List<String> SideItems);
    }
    public static class VegBurger implements MealBuilder {
        Meal meal;
        VegBurger() {
            this.meal = new Meal();
        }

        @Override
        public Meal buildMeal() {
            return meal;
        }

        @Override
        public MealBuilder buildBurger(String burger) {
            meal.setBurger(burger);
            return this;
        }

        @Override
        public MealBuilder buildDrink(String Drink) {
            meal.setDrink(Drink);
            return this;
        }

        @Override
        public MealBuilder buildSideItems(List<String> SideItems) {
            meal.setSideItems(SideItems);
            return this;
        }
    }

    public static class MealDirector {
        MealBuilder builder;
        MealDirector(MealBuilder builder) {
            this.builder = builder;
        }
        public Meal PrepareMeal() {
            List<String> sideItems = new ArrayList<>();
            sideItems.add("Fries");
            sideItems.add("Salad");
            sideItems.add("Onion Rings");

            return builder
                    .buildBurger("Veggie Burger")
                    .buildDrink("Coke")
                    .buildSideItems(sideItems)
                    .buildMeal();
        }
    }
    public static void main(String[] args) {
        VegBurger vegBurger = new VegBurger();
        MealDirector mealDirector = new MealDirector(vegBurger);
        Meal meal = mealDirector.PrepareMeal();
        System.out.println(meal);
    }
}
