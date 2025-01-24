package Final.DesignPatterns.AbstractFactory;

public class PaymentGateway {
    // product
    public static interface IPaymentService {
        void Pay(double amount);
    }
    public static class CashService implements IPaymentService {
        public void Pay(double amount) {
            System.out.println("Paying " + amount + " on cash");
        }
    }
    public static class CreditCardService implements IPaymentService {
        public void Pay(double amount) {
            System.out.println("Paying " + amount + " on credit card");
        }
    }

    public static interface INotificationService {
        void Notify(String message);
    }
    public static class SMSService implements INotificationService {
        public void Notify(String message) {
            System.out.println("Notifying " + message);
        }
    }
    public static class EmailService implements INotificationService {
        public void Notify(String message) {
            System.out.println("Notifying " + message);
        }
    }

    // abstract factory
    public static interface IPaymentNotificationService {
        INotificationService getNotificationService();
        IPaymentService getPaymentService();
    }

    public static class EmailCreditCardService implements IPaymentNotificationService {
        public INotificationService getNotificationService() {
            return new EmailService();
        }
        public IPaymentService getPaymentService() {
            return new CreditCardService();
        }
    }

    public static void main(String[] args) {
        EmailCreditCardService emailCreditCardService = new EmailCreditCardService();
        INotificationService notificationService = emailCreditCardService.getNotificationService();
        IPaymentService paymentService = emailCreditCardService.getPaymentService();
        notificationService.Notify("Hello World!");
        paymentService.Pay(1000f);
    }
}
