package PracticesOnDesignPatterns;

// Strategy design pattern
// strategy kodun devranisini ve yaptigi isi calisma zamaninda degistirmesini sagliyor
// ve var olan ozelliklere yeni bir ozellik ekleyecegimiz zaman kodun yapisini degistirmeden
// yeni ozellikler eklememizi saglar
// polymorphism, open close solid principle, ve single responsibility solid principle onemli bir rol oynar
// bu desenin tasariminda
public class TaxCalculationByRegion_Strategy {

    // strategy
    public static interface TaxCalculator {
        public double calculateTax(double amount);
    }

    // concrete strategy
    public static class TurkeyTaxCalculator implements TaxCalculator {
        @Override
        public double calculateTax(double amount) {
            return amount * 0.05;
        }
    }

    // concrete strategy
    public static class SyriaTaxCalculator implements TaxCalculator {
        @Override
        public double calculateTax(double amount) {
            return amount * 0.04;
        }
    }

    // concrete strategy
    public static class EgyptTaxCalculator implements TaxCalculator {
        @Override
        public double calculateTax(double amount) {
            return amount * 0.09;
        }
    }

    // context
    public static class CalculatorContext
    {
        TaxCalculator taxCalculator;
        public CalculatorContext(TaxCalculator taxCalculator) {
            this.taxCalculator = taxCalculator;
        }

        public double calculate(double amount) {
            return taxCalculator.calculateTax(amount);
        }
    }

    public static void main(String[] args) {
        CalculatorContext context = new CalculatorContext(new TurkeyTaxCalculator());
        System.out.println(context.calculate(100));

        context = new CalculatorContext(new SyriaTaxCalculator());
        System.out.println(context.calculate(100));

        context = new CalculatorContext(new EgyptTaxCalculator());
        System.out.println(context.calculate(100));
    }

}

