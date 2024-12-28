package Strategy;

public class PaymentMethods {

    public static interface IPayment
    {
        void pay(double amount);
    }
    public static class CreditCard implements IPayment
    {
        private String _cardNumber;

        public CreditCard(String cardNumber)
        {
            _cardNumber = cardNumber;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paying " + amount + " using Credit Card: " + _cardNumber);
        }
    }

    public static class Paypal implements IPayment
    {
        private String _email;

        public Paypal(String email) {
            _email = email;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paying " + amount + " using PayPal: " + _email);
        }
    }

    public static class GooglePay implements IPayment
    {
        private String _phoneNumber;

        public GooglePay(String phoneNumber)
        {
            _phoneNumber = phoneNumber;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paying " + amount + " using Google Pay: " + _phoneNumber);
        }
    }

    public static class PaymentContext
    {
        IPayment payment;

        public PaymentContext(IPayment payment)
        {
            this.payment = payment;
        }

        public void pay(double amount) {
            payment.pay(amount);
        }
    }
    public static void main(String[] args) {
        PaymentContext payment = new PaymentContext(new CreditCard("4355-5445-5452-1213"));
        payment.pay(46.00);

        payment = new PaymentContext(new Paypal("oms@gmail.com"));
        payment.pay(132.00);

        payment = new PaymentContext(new GooglePay("+49 988 555-5555"));
        payment.pay(76.00);

    }
}
