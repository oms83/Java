package Final.Solid.SRP;

public class WithoutSRP {

    public static class NotificationService
    {
        enum enServiceType {SMS, FAX, EMAIL}
        public void Notify(String to, String body, enServiceType serviceType) {
            if (enServiceType.EMAIL == serviceType) {
                _SendEmail(to, body);
            }
            else if (enServiceType.SMS == serviceType) {
                _SendSMS(to, body);
            }
            else {
                _SendFax(to, body);
            }
        }
        private void _SendEmail(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
        private void _SendFax(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
        private void _SendSMS(String to, String body) {
            System.out.println("To: " + to + " Body: " + body);
        }
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş", NotificationService.enServiceType.EMAIL);
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş", NotificationService.enServiceType.SMS);
        service.Notify("Ömer MEMES", "Hi, Ömer Baboş", NotificationService.enServiceType.FAX);
    }
}
