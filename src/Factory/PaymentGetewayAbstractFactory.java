package Factory;

public class PaymentGetewayAbstractFactory {

    public static interface IPaymentFactory
    {
        IPaymentRequest createPaymentRequest();
        IPaymentStatus getPaymentStatus();
    }
    public static interface IPaymentRequest
    {
        void create(String v, float amount);
    }
    public static interface IPaymentStatus
    {
        void get(String v);
    }
    public static class PaypalPaymentRequest implements IPaymentRequest
    {
        @Override
        public void create(String email, float amount) {
            System.out.println("PayPal Payment Request Created for " + email + " with amount: " + amount);
        }
    }
    public static class PaypalPaymentStatus implements IPaymentStatus
    {
        @Override
        public void get(String transactionId) {
            System.out.println("PayPal Payment Status Retrieved for Transaction ID: " + transactionId);
        }
    }
    public static class StripePaymentRequest implements IPaymentRequest
    {
        @Override
        public void create(String cardNumber, float amount) {
            System.out.println("Stripe Payment Request Created for Card: " + cardNumber + " with amount: " + amount);
        }
    }
    public static class StripePaymentStatus implements IPaymentStatus
    {
        @Override
        public void get(String paymentRef) {
            System.out.println("Stripe Payment Status Retrieved for Payment Ref: " + paymentRef);
        }
    }
    public static class PaypalPaymentFactory implements IPaymentFactory
    {
        @Override
        public IPaymentRequest createPaymentRequest() {
            return new PaypalPaymentRequest();
        }
        @Override
        public IPaymentStatus getPaymentStatus() {
            return new PaypalPaymentStatus();
        }
    }
    public static class StripePaymentFactory implements IPaymentFactory
    {
        @Override
        public IPaymentRequest createPaymentRequest() {
            return new StripePaymentRequest();
        }

        @Override
        public IPaymentStatus getPaymentStatus() {
            return new StripePaymentStatus();
        }
    }
    public static void main(String[] args) {
        IPaymentFactory pf = new StripePaymentFactory();
        IPaymentRequest preq = pf.createPaymentRequest();
        IPaymentStatus ps = pf.getPaymentStatus();
        ps.get("343434343");
        preq.create("oms@gmail.com", 4555);
    }
}
