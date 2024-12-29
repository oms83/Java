package Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStatusNotification {

    public static interface IObserver
    {
        public void update(float temperature, float humidity);
    }

    public static interface ISubject
    {
        void notifyObserver();
        void addObserver(IObserver observer);
        void removeObserver(IObserver observer);
    }

    public static class Subject  implements ISubject
    {
        private final List<IObserver> observers;
        private float temperature;
        private float humidity;

        public Subject()
        {
            observers = new ArrayList<IObserver>();
        }

        @Override
        public void addObserver(IObserver observer)
        {
            observers.add(observer);
        }

        @Override
        public void notifyObserver()
        {
            for (IObserver observer : observers) {
                observer.update(temperature, humidity);
            }
        }

        @Override
        public void removeObserver(IObserver observer)
        {
            observers.remove(observer);
        }

        public void setMeasurements(float temperature, float humidity)
        {
            this.temperature = temperature;
            this.humidity = humidity;
        }
    }

    public static class CurrentConditionsDisplay implements IObserver
    {
        private float temperature;
        private float humidity;

        @Override
        public void update(float temperature, float humidity) {
            this.temperature = temperature;
            this.humidity = humidity;
            display();
        }

        public void display()
        {
            System.out.println("Current temperature: " + temperature);
            System.out.println("Current humidity: " + humidity);
        }
    }


    public static void main(String[] args) {
        Subject subject = new Subject();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        subject.addObserver(currentDisplay);

        subject.setMeasurements(25.5f, 65.0f);
        subject.setMeasurements(22.3f, 70.0f);
        subject.notifyObserver();
    }
}

/*
                Subject  <----------- ConcreteSubject
                    |
                Observer <----------- ConcreteObserver
*/
