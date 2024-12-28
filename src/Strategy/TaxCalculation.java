package Strategy;

public class TaxCalculation {

    public static interface ITaxStrategy {
        double calculate(double tax);
    }

    public static class TurkeyTaxStrategy implements ITaxStrategy {
        @Override
        public double calculate(double tax) {
            return tax * 0.05;
        }
    }
    public static class SyriaTaxStrategy implements ITaxStrategy {
        @Override
        public double calculate(double tax) {
            return tax * 0.01;
        }
    }
    public static class EgyptTaxStrategy implements ITaxStrategy {
        @Override
        public double calculate(double tax) {
            return tax * 0.02;
        }
    }

    public static class TaxContext {
        ITaxStrategy taxStrategy;

        public TaxContext(ITaxStrategy taxStrategy) {
            this.taxStrategy = taxStrategy;
        }

        public double getTax(double tax) {
            return taxStrategy.calculate(tax);
        }
    }

    public static void main(String[] args) {

        TaxContext taxContext = new TaxContext(new TurkeyTaxStrategy());
        System.out.println(taxContext.getTax(15));

        taxContext = new TaxContext(new SyriaTaxStrategy());
        System.out.println(taxContext.getTax(10));

        taxContext = new TaxContext(new EgyptTaxStrategy());
        System.out.println(taxContext.getTax(12));
    }
}
