package Factory;

public class PaymentGatewaySimpleFactory {

    public static interface IPayment
    {
        void CreatePaymentRequest(String v1, float amount);
        void GetPaymentStatus(String v1);
    }

    public static class IPaypal implements IPayment
    {
        @Override
        public void CreatePaymentRequest(String v1, float amount)
        {
            System.out.println("Create Payment Request Paypal");
        }
        @Override
        public void GetPaymentStatus(String v1)
        {
            System.out.println("Get Payment Status Paypal");
        }

    }
    public static class IStripe implements IPayment
    {
        @Override
        public void CreatePaymentRequest(String v1, float amount)
        {
            System.out.println("Create Payment Request Stripe");
        }
        @Override
        public void GetPaymentStatus(String v1)
        {
            System.out.println("Get Payment Status Stripe");
        }
    }
    public static class PaymentFactory
    {
        public enum  enMethod {paypal, stripe}
        public static IPayment getPaymentMethod(enMethod method)
        {
            switch (method)
            {
                case paypal:
                    return new IPaypal();
                case stripe:
                    return new IStripe();
                default:
                    return null;
            }
        }
    }
    public static void main(String[] args) {
        IPayment method = PaymentFactory.getPaymentMethod(PaymentFactory.enMethod.paypal);
        method.GetPaymentStatus("Payment Status");
        method.CreatePaymentRequest("oms@gmail.com", 200);

        method = PaymentFactory.getPaymentMethod(PaymentFactory.enMethod.stripe);
        method.GetPaymentStatus("Payment Status");
        method.CreatePaymentRequest("oms@gmail.com", 200);

    }
}
