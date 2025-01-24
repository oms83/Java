package Final.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class StockNotificationService {
    public static interface ObServer {
        void update(String name, float price);
    }
    public static class Stock implements ObServer {
        private String name;
        private float price;
        public void update(String name, float price) {
            this.name = name;
            this.price = price;
            Display();
        }
        public void Display() {
            System.out.println("Name: " + name + ", Price: " + price);
        }
    }
    public static interface StockManager {
        void register(ObServer o);
        void unregister(ObServer o);
        void notifyObservers();
    }
    public static class StockNotification implements StockManager {
        private String name;
        private float price;
        private List<ObServer> observers;
        StockNotification() {
            observers = new ArrayList<ObServer>();
        }
        @Override
        public void register(ObServer o) {
            observers.add(o);
        }

        @Override
        public void notifyObservers() {
            for (ObServer o : observers) {
                o.update(name, price);
            }
        }

        @Override
        public void unregister(ObServer o) {
            observers.remove(o);
        }

        public void setStock(String name, float price) {
            this.price = price;
            this.name = name;
            notifyObservers();
        }
    }

    public static void main(String[] args) {
        Stock stock = new Stock();
        StockNotification stockNotification = new StockNotification();
        stockNotification.register(stock);
        stockNotification.setStock("Bitcoin", 90000f);
        stockNotification.setStock("Bitcoin", 80000f);
    }
}
