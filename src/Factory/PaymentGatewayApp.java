package Factory;

public class PaymentGatewayApp {

    // abstract factory
    public static interface IPaymentCommunicationFactory
    {
        IPayment getPayment();
        ICommunication getCommunication();
    }

    // abstract product for payment
    public static interface IPayment
    {
        void createPaymentRequest(String userId, float amount);
        void  getPaymentStatus(String paymentId);
    }

    // abstract product for payment
    public static interface ICommunication
    {
        void sendMessage(String message);
    }

    // concrete product for payment
    public static class PayPalPayment implements IPayment
    {

        @Override
        public void createPaymentRequest(String userId, float amount) {
            System.out.println("PayPal: Payment request created for user: " + userId + ", amount: " + amount);
        }

        @Override
        public void getPaymentStatus(String paymentId) {
            System.out.println("PayPal: Checking payment status for payment ID: " + paymentId);
        }
    }

    // concrete product for payment
    public static class StripePayment implements IPayment
    {
        @Override
        public void createPaymentRequest(String userId, float amount) {
            System.out.println("Stripe: Payment request created for user: " + userId + ", amount: " + amount);
        }

        @Override
        public void getPaymentStatus(String paymentId) {
            System.out.println("Stripe: Checking payment status for payment ID: " + paymentId);
        }
    }

    // concrete product for payment
    public static class GooglePayPayment implements IPayment
    {
        @Override
        public void createPaymentRequest(String userId, float amount) {
            System.out.println("GooglePay: Payment request created for user: " + userId + ", amount: " + amount);
        }

        @Override
        public void getPaymentStatus(String paymentId) {
            System.out.println("GooglePay: Checking payment status for payment ID: " + paymentId);
        }
    }

    public static class EmailCommunication implements ICommunication
    {
        @Override
        public void sendMessage(String message) {
            System.out.println("Email: Sending email: " + message);
        }
    }

    public static class SMSCommunication implements ICommunication
    {
        @Override
        public void sendMessage(String message) {
            System.out.println("SMS: Sending SMS: " + message);
        }
    }

    public static class PushCommunication implements ICommunication
    {
        @Override
        public void sendMessage(String message) {
            System.out.println("Push: Sending Push: " + message);
        }
    }

    public static class PaypalEmailFactory implements IPaymentCommunicationFactory
    {
        @Override
        public ICommunication getCommunication() {
            return new EmailCommunication();
        }

        @Override
        public IPayment getPayment() {
            return new PayPalPayment();
        }
    }

    public static class StripeSMSFactory implements IPaymentCommunicationFactory
    {
        @Override
        public IPayment getPayment() {
            return new StripePayment();
        }

        @Override
        public ICommunication getCommunication() {
            return new SMSCommunication();
        }
    }

    // Concrete Factory: GooglePay + Push Notification
    public static class GooglePushFactory implements IPaymentCommunicationFactory
    {
        @Override
        public ICommunication getCommunication() {
            return new PushCommunication();
        }

        @Override
        public IPayment getPayment() {
            return new GooglePayPayment();
        }
    }

    public static void main(String[] args) {
        IPaymentCommunicationFactory factory = new PaypalEmailFactory();
        IPayment payment = factory.getPayment();
        ICommunication communication = factory.getCommunication();
        payment.createPaymentRequest("user1", 100.0f);
        communication.sendMessage("user1");

    }
}
