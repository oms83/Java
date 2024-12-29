package Observer;

import java.util.ArrayList;
import java.util.List;

public class StockNotificationServices {

    public static interface IStock
    {
        void update(String code, float currentPrice);
    }

    public static interface INotification
    {
        void register(IStock stock);
        void unregister(IStock stock);
        void notifying();
    }

    public static class Notification implements INotification
    {
        private String code;
        private float currentPrice;
        private List<IStock> stocks;

        public Notification()
        {
            stocks = new ArrayList<IStock>();
        }

        @Override
        public void register(IStock stock)
        {
            stocks.add(stock);
        }

        @Override
        public void unregister(IStock stock)
        {
            stocks.remove(stock);
        }

        @Override
        public void notifying()
        {
            for(IStock stock : stocks)
            {
                stock.update(code, currentPrice);
            }
        }

        public void setStock(String code, float currentPrice)
        {
            this.code = code;
            this.currentPrice = currentPrice;
            this.notifying();
        }
    }

    public static class SMSService implements IStock
    {
        @Override
        public void update(String code, float currentPrice) {
            System.out.println("SMS Service: {" + code + ", " + currentPrice + "}");
        }
    }

    public static class PushService implements IStock
    {
        @Override
        public void update(String code, float currentPrice) {
            System.out.println("Push Service: {" + code + ", " + currentPrice + "}");
        }
    }

    public static class DashboardService implements IStock
    {
        @Override
        public void update(String code, float currentPrice) {
            System.out.println("SMS Service: Stock Code: " + code + ", Current Price: " + currentPrice + ", Time: " + java.time.LocalDateTime.now());
        }
    }
    public static void main(String[] args)
    {
            Notification notification = new Notification();
            IStock stock = new SMSService();
            notification.register(stock);
            stock = new PushService();
            notification.register(stock);
            stock = new DashboardService();
            notification.register(stock);

            notification.setStock("AX", 23223.32f);
            notification.setStock("BX", 23223.32f);
            notification.setStock("CX", 23223.32f);
            notification.setStock("DX", 23223.32f);
    }
}
