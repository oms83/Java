package Final.Solid.OCP;

public class WithOCP {
    public static class NotificationService
    {
        private IService _service;
        public NotificationService(IService service) {
            _service = service;
        }

        public void Notify(String to, String body) {
            _service.Notify(to, body);
        }
    }
    public static interface IService {
        public abstract void Notify(String to, String body);
    }
    public static class PushService implements IService {
        public void Notify(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
    }
    public static class EmailService implements IService {
        public void Notify(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
    }

    public static class SMSService implements IService {
        public void Notify(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
    }

    public static class FaxService implements IService {
        public void Notify(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService(new EmailService());
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş");
        service = new NotificationService(new FaxService());
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş");
        service = new NotificationService(new PushService());
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş");
        service = new NotificationService(new SMSService());
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş");
    }
}
