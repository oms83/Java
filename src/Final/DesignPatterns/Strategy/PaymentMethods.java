package Final.DesignPatterns.Strategy;

public class PaymentMethods {

    public static interface IPayment {
        void Pay(double amount);
    }

    public static class CashService implements IPayment {
        public void Pay(double amount) {
            System.out.println("Paying " + amount + " in cash");
        }
    }

    public static class CreditCardService implements IPayment {
        private String CardNo;
        public CreditCardService(String CardNo) {
            this.CardNo = CardNo;
        }
        public void Pay(double amount) {
            System.out.println("Paying " + amount + " in credit card\n" + "Card NO: " + CardNo);
        }
    }

    public static class PaymentMethod {
        private IPayment payment;
        public PaymentMethod(IPayment payment) {
            this.payment = payment;
        }
        public void Pay(double amount) {
            payment.Pay(amount);
        }
    }

    public static void main(String[] args) {
        PaymentMethod paymentMethod = new PaymentMethod(new CashService());
        paymentMethod.Pay(2500f);
        paymentMethod = new PaymentMethod(new CreditCardService("12345"));
        paymentMethod.Pay(300f);
        paymentMethod = new PaymentMethod(new CashService());
        paymentMethod.Pay(1000f);
    }
}
