package Factory;

public class Notifications {
    enum enNotifications {sms, fax, phone, email}
    public static class NotificationFactory {
        public static INotification getNotification(enNotifications en) {
            switch (en) {
                case sms:
                    return new SMSNotify();
                case fax:
                    return new FaxNotify();
                case phone:
                    return new PhoneNotify();
                case email:
                    return new EmailNotify();
                default:
                    return null;
            }
        }
    }

    public static interface INotification {
        public void notify(String message);
    }

    public static class SMSNotify implements INotification {
        @Override
        public void notify(String message) {
            System.out.println("SMS Notification: " + message);
        }
    }
    public static class EmailNotify implements INotification {
        @Override
        public void notify(String message) {
            System.out.println("Email Notification: " + message);
        }
    }
    public static class PhoneNotify implements INotification {
        @Override
        public void notify(String message) {
            System.out.println("Phone Notification: " + message);
        }
    }
    public static class FaxNotify implements INotification {
        @Override
        public void notify(String message) {
            System.out.println("Fax Notification: " + message);
        }
    }

    public static void main(String[] args) {
        INotification notification = NotificationFactory.getNotification(enNotifications.fax);
        if (notification != null) {

            notification.notify("Hello World");
        }

        notification = NotificationFactory.getNotification(enNotifications.phone);
        if (notification != null) {
            notification.notify("Hello World");
        }

        notification = NotificationFactory.getNotification(enNotifications.email);
        if (notification != null) {
            notification.notify("Hello World");
        }

        notification = NotificationFactory.getNotification(enNotifications.sms);
        if (notification != null) {
            notification.notify("Hello World");
        }

        notification = NotificationFactory.getNotification(enNotifications.fax);
        if (notification != null) {
            notification.notify("Hello World");
        }
    }
}
/*
             NotificationFactory
            [+getNotifiactions()]
                     |
                <interface>
               INotification
                [+notify()]
              /             \
            SMS             FAX
        [+notify()]       [+notify()]
*/