package Observer;

import java.util.ArrayList;
import java.util.List;

public class EmergencyManagerNotificationService {

    public static interface IObserver {
        enum enEmergencyType {FIRE, EARTHQUAKE, FLOOD }
        enum enSeverityLevel {LOW, MEDIUM, HIGH }
        void update(enEmergencyType EmergencyType, String location, enSeverityLevel SeverityLevel);
    }

    public static interface IEmergencyManager {
        void registerObserver(IObserver observer);
        void unregisterObserver(IObserver observer);
        void notifyObservers();
    }

    public static class EmergencyManager implements IEmergencyManager {

        private IObserver.enEmergencyType emergencyType;
        private IObserver.enSeverityLevel severityLevel;
        private String location;
        private List<IObserver> notifications;

        public EmergencyManager()
        {
            notifications = new ArrayList<IObserver>();
        }

        @Override
        public void unregisterObserver(IObserver observer) {
            notifications.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (IObserver notification : notifications) {
                notification.update(emergencyType, location, severityLevel);
            }
        }

        @Override
        public void registerObserver(IObserver observer) {
            notifications.add(observer);
        }

        public void setEmergencyDetails(IObserver.enEmergencyType EmergencyType, String location, IObserver.enSeverityLevel SeverityLevel) {
            this.emergencyType = EmergencyType;
            this.severityLevel = SeverityLevel;
            this.location = location;
            this.notifyObservers();
        }
    }

    public static class SMSService implements IObserver
    {
        @Override
        public void update(enEmergencyType EmergencyType, String location, enSeverityLevel SeverityLevel) {

            System.out.println("\n----------------------------------\n");
            System.out.println("Emergency Alert:");
            System.out.println("Type: " + EmergencyType);
            System.out.println("Location: " + location);
            System.out.println("Severity Level: " + SeverityLevel);
            System.out.println("Please take necessary precautions.");
            System.out.println("Time: " + java.time.LocalDateTime.now());
            System.out.println("\n----------------------------------\n");
        }
    }

    public static class PushService implements IObserver
    {
        @Override
        public void update(enEmergencyType EmergencyType, String location, enSeverityLevel SeverityLevel) {

            System.out.println("\n----------------------------------\n");
            System.out.println("Emergency Alert:");
            System.out.println("Type: " + EmergencyType);
            System.out.println("Location: " + location);
            System.out.println("Severity Level: " + SeverityLevel);
            System.out.println("Please take necessary precautions.");
            System.out.println("Time: " + java.time.LocalDateTime.now());
            System.out.println("\n----------------------------------\n");
        }
    }

    public static void main(String[] args) {
        EmergencyManager manager = new EmergencyManager();
        IObserver observer = new SMSService();
        manager.registerObserver(observer);
        observer = new PushService();
        manager.setEmergencyDetails(IObserver.enEmergencyType.EARTHQUAKE, "Downtown", IObserver.enSeverityLevel.HIGH);

        observer = new PushService();
        manager.registerObserver(observer);
        manager.setEmergencyDetails(IObserver.enEmergencyType.EARTHQUAKE, "Street 16.", IObserver.enSeverityLevel.MEDIUM);
    }
}
