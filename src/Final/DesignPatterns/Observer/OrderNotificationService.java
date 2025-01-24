package Final.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class OrderNotificationService {
    public static interface Observer {
        void create(String order, int quantity, float price);
    }
    public static class  Order implements  Observer {
        private String order;
        private int quantity;
        private float price;
        public void create(String order, int quantity, float price) {
            this.order = order;
            this.quantity = quantity;
            this.price = price;
            display();
        }
        private void display() {
            System.out.println(order + "\t" + quantity + "\t" + price);
        }
    }

    public static interface OrderNotification {
        void register(Observer observer);
        void unregister(Observer observer);
        void notifyOrder();
    }

    public static class Notification implements OrderNotification {
        private String order;
        private int quantity;
        private float price;
        private List<Observer> observers;
        Notification() {
            observers = new ArrayList<Observer>();
        }

        @Override
        public void register(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void notifyOrder() {
            for (Observer observer : observers) {
                observer.create(this.order, this.quantity, this.price);
            }
        }

        @Override
        public void unregister(Observer observer) {
            observers.remove(observer);
        }

        public void setOrder(String order, int quantity, float price) {
            this.order = order;
            this.quantity = quantity;
            this.price = price;
            notifyOrder();
        }
    }

    public static void main(String[] args) {
        Order order = new Order();
        Notification notification = new Notification();
        notification.register(order);

        notification.setOrder("Laptop", 1, 2000f);
        notification.setOrder("PC", 1, 1500f);
        notification.unregister(order);
        notification.notifyOrder();
        notification.register(order);
        notification.setOrder("PC", 1, 1500f);
    }
}
