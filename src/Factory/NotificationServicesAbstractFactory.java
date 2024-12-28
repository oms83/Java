package Factory;

public class NotificationServicesAbstractFactory {

    // Abstract factory
    public static interface INotificationServices {
        ISend getMessage();
    }

    // Product factory
    public static interface ISend
    {
        void send(String message);
    }

    // Concrete product
    public static class SendSMS implements ISend
    {
        @Override
        public void send(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    public static class SendEmail implements ISend
    {
        @Override
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }
    public static class SendFax implements ISend
    {
        @Override
        public void send(String message) {
            System.out.println("Sending Fax: " + message);
        }
    }
    public static class SendSMSFactory implements INotificationServices
    {
        @Override
        public ISend getMessage() {
            return new SendSMS();
        }
    }
    public static class SendEmailFactory implements INotificationServices
    {
        @Override
        public ISend getMessage() {
            return new SendEmail();
        }
    }
    public static class SendFaxFactory implements INotificationServices
    {
        @Override
        public ISend getMessage() {
            return new SendFax();
        }
    }

    public static void main(String[] args) {

        INotificationServices ns = new SendSMSFactory();
        ISend sm = ns.getMessage();
        sm.send("Hello World");

        ns = new SendEmailFactory();
        sm = ns.getMessage();
        sm.send("Hello World");

        ns = new SendFaxFactory();
        sm = ns.getMessage();
        sm.send("Hello World");
    }
}
