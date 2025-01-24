package Final.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStatusNotification {

    // Observer
    public static interface Observer {
        void update(float temp, float humidity, float pressure);
    }

    // Observer concrete
    public static class CurrentWeather implements Observer {

        float temp;
        float humidity;
        float pressure;

        @Override
        public void update(float temp, float humidity, float pressure) {
            this.temp = temp;
            this.humidity = humidity;
            this.pressure = pressure;
            Display();
        }
        private void Display() {
            System.out.println("Current conditions: " + temp + "°C and " + humidity + "% humidity " + " pressure: " + pressure);
        }
    }

    // Subject
    public static interface Subject {
        void subscribe(Observer observer);
        void unsubscribe(Observer observer);
        void notifyObservers();
    }
    public static class WeatherData implements Subject {
        private float temp;
        private float humidity;
        private float pressure;
        List<Observer> observers;

        WeatherData() {
            observers = new ArrayList<>();
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(temp, humidity, pressure);
            }
        }

        @Override
        public void subscribe(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void unsubscribe(Observer observer) {
            observers.remove(observer);
        }

        public void setMeasurements(float temperature, float humidity, float pressure) {
            this.temp = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            notifyObservers();
        }
    }

    public static void main(String[] args) {
        Observer observer = new CurrentWeather();
        WeatherData weatherData = new WeatherData();
        weatherData.subscribe(observer);
        weatherData.setMeasurements(27.6f, 30.6f, 30.6f);
    }
}
