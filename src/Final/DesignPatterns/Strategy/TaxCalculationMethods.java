package Final.DesignPatterns.Strategy;

public class TaxCalculationMethods {

    // strategy
    public static interface ICalculator {
        public double calculate(double tax);
    }

    // concrete strategy
    public static class SyriaTax implements ICalculator {
        public double calculate(double tax) {
            return tax * 0.05;
        }
    }

    // concrete strategy
    public static class TurkiyeTax implements ICalculator {
        public double calculate(double tax) {
            return tax * 0.1;
        }
    }

    // context
    public static class TaxCalculator {
        ICalculator calculator;
        public TaxCalculator(ICalculator calculator) {
            this.calculator = calculator;
        }
        public double calculate(double tax) {
            return calculator.calculate(tax);
        }
    }

    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator(new SyriaTax());
        System.out.println(calculator.calculate(1000));

        calculator = new TaxCalculator(new TurkiyeTax());
        System.out.println(calculator.calculate(1000));
    }
}
