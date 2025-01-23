package Final.Solid.OCP;

public class WithoutOCP {
    public static class NotificationService
    {
        enum enServiceType {SMS, FAX, EMAIL, PUSH}
        public void Notify(String to, String body, enServiceType serviceType) {
            if (NotificationService.enServiceType.EMAIL == serviceType) {
                EmailService.SendEmail(to, body);
            }
            else if (NotificationService.enServiceType.SMS == serviceType) {
                SMSService.SendSMS(to, body);
            }
            else if (NotificationService.enServiceType.PUSH == serviceType) {
                PushService.SendPush(to, body);
            }
            else {
                FaxService.SendFax(to, body);
            }
        }
    }
    public static class PushService {
        public static void SendPush(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
    }
    public static class EmailService {
        public static void SendEmail(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
    }

    public static class SMSService {
        public static void SendSMS(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
    }

    public static class FaxService {
        public static void SendFax(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş", NotificationService.enServiceType.EMAIL);
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş", NotificationService.enServiceType.SMS);
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş", NotificationService.enServiceType.FAX);
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş", NotificationService.enServiceType.PUSH);
    }
}
