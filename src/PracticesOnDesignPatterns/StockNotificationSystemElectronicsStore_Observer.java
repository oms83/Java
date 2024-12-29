package PracticesOnDesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class StockNotificationSystemElectronicsStore_Observer {

    public static interface IObserver
    {
        public void update(int quantity);
    }

    public static interface IStockNotification
    {
        void registerObserver(IObserver observer);
        void removeObserver(IObserver observer);
        void notifyObservers();
    }

    public static class Notification implements IStockNotification
    {
        public int quantity;
        public List<IObserver> observers;

        public Notification()
        {
            observers = new ArrayList<IObserver>();
        }

        @Override
        public void removeObserver(IObserver observer) {
            observers.remove(observer);
        }

        @Override
        public void registerObserver(IObserver observer) {
            observers.add(observer);
        }

        @Override
        public void notifyObservers() {
            for (IObserver observer : observers) {
                observer.update(quantity);
            }
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public static class SMSNotification implements IObserver
    {
        public int quantity;

        @Override
        public void update(int quantity) {
            this.quantity = quantity;
            display();
        }

        public void display()
        {
            System.out.println("By SMS, Quantity: " + quantity);
        }
    }

    public static class EmailNotification implements IObserver
    {
        public int quantity;

        @Override
        public void update(int quantity) {
            this.quantity = quantity;
            display();
        }

        public void display()
        {
            System.out.println("By Email, Quantity: " + quantity);
        }
    }

    public static class PushNotification implements IObserver
    {
        public int quantity;

        @Override
        public void update(int quantity) {
            this.quantity = quantity;
            display();
        }

        public void display()
        {
            System.out.println("By Push, Quantity: " + quantity);
        }
    }

    public static void main(String[] args) {
        EmailNotification observer = new EmailNotification();
        Notification notification = new Notification();
        notification.setQuantity(10);
        notification.registerObserver(observer);

        notification.notifyObservers();

    }

}
