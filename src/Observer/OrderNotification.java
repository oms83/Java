package Observer;

import java.util.ArrayList;
import java.util.List;

public class OrderNotification {

    public static interface OrderSubscriber
    {
        void createOrder(String userId, String OrderDetails);
    }

    public static interface OrderNotificationService
    {
        void registerOrder(OrderSubscriber order);
        void unregisterOrder(OrderSubscriber order);
        void notifyOrder();
    }

    public static class Notification implements OrderNotificationService
    {
        private List<OrderSubscriber> subscribers;
        private String userId;
        private String OrderDetails;

        public Notification()
        {
            subscribers = new ArrayList<OrderSubscriber>();
        }

        @Override
        public void notifyOrder() {
            for (OrderSubscriber subscriber : subscribers)
            {
                subscriber.createOrder(userId, OrderDetails);
            }
        }

        @Override
        public void registerOrder(OrderSubscriber order) {
            subscribers.add(order);
        }

        @Override
        public void unregisterOrder(OrderSubscriber order) {
            subscribers.remove(order);
        }

        public void setOrderDetails(String userId, String orderDetails) {
            this.userId = userId;
            this.OrderDetails = orderDetails;
            this.notifyOrder();
        }
    }

    public static class SMSNotify implements OrderSubscriber
    {
        private String userId;
        private String OrderDetails;

        @Override
        public void createOrder(String userId, String OrderDetails) {
            this.userId = userId;
            this.OrderDetails = OrderDetails;
            display();
        }

        public void display()
        {
            System.out.println("By SMS User Id: " + userId);
            System.out.println("By SMS Order Details: " + OrderDetails);
        }
    }

    public static class EmailNotify implements OrderSubscriber
    {
        private String userId;
        private String OrderDetails;

        @Override
        public void createOrder(String userId, String OrderDetails) {
            this.userId = userId;
            this.OrderDetails = OrderDetails;
            display();
        }

        public void display()
        {
            System.out.println("By Email User Id: " + userId);
            System.out.println("By Email Order Details: " + OrderDetails);
        }
    }

    public static void main(String[] args) {
        Notification ons = new Notification();
        SMSNotify sms = new SMSNotify();
        ons.registerOrder(sms);
        EmailNotify em = new EmailNotify();
        ons.registerOrder(em);
        ons.setOrderDetails("oms", "order details");
        ons.unregisterOrder(sms);
        ons.unregisterOrder(em);
    }
}
