package Strategy;

public class NotificationServices {

    public static interface INotifyStrategy {
        void sendMessage(String message);
    }

    public static class SMSService implements INotifyStrategy {
        @Override
        public void sendMessage(String message) {
            System.out.println("SMS: " + message);
        }
    }

    public static class EmailService implements INotifyStrategy {
        @Override
        public void sendMessage(String message) {
            System.out.println("Email: " + message);
        }
    }

    public static class FaxService implements INotifyStrategy {
        @Override
        public void sendMessage(String message) {
            System.out.println("Fax: " + message);
        }
    }

    public static class NotifyContext implements INotifyStrategy {

        INotifyStrategy strategy;

        public NotifyContext(INotifyStrategy strategy) {
            this.strategy = strategy;
        }

        public void sendMessage(String message) {
            strategy.sendMessage(message);
        }
    }

    public static void main(String[] args) {

        NotifyContext context = new NotifyContext(new SMSService());
        context.sendMessage("Hello World");

        context = new NotifyContext(new EmailService());
        context.sendMessage("Hello World");

        context = new NotifyContext(new FaxService());
        context.sendMessage("Hello World");

    }
}
