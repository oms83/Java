package Final.DesignPatterns.Strategy;

public class NotificationServices {

    public static interface INotification {
        void Send(String message);
    }

    public static class SMSService implements INotification {
        @Override
        public void Send(String message) {
            System.out.println("SMS Service: " + message);
        }
    }
    public static class EmailService implements INotification {
        @Override
        public void Send(String message) {
            System.out.println("Email Service: " + message);
        }
    }
    public static class FaxService implements INotification {
        @Override
        public void Send(String message) {
            System.out.println("Fax Service: " + message);
        }
    }
    public static class NotifcationService {
        INotification notification;
        public NotifcationService(INotification notification) {
            this.notification = notification;
        }
        public void Send(String message) {
            notification.Send(message);
        }
    }
    public static void main(String[] args) {
        NotifcationService notifcationService = new NotifcationService(new FaxService());
        notifcationService.Send("Hello World");
        notifcationService = new NotifcationService(new EmailService());
        notifcationService.Send("Hello World");
        notifcationService = new NotifcationService(new SMSService());
        notifcationService.Send("Hello World");

    }
}
