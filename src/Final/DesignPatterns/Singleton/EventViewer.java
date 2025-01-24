package Final.DesignPatterns.Singleton;

public class EventViewer {

    public static class EventLogger
    {
        private EventLogger(){}
        private static EventLogger logger = null;

        public static EventLogger createLogger() {
            if (logger == null) {
                synchronized(EventLogger.class) {
                    if (logger == null)
                        logger = new EventLogger();
                    else
                        System.out.println("logger already has been created");
                }
            }
            else {
                System.out.println("logger already has been created");
            }
            return logger;
        }

        public void log(String message) {
            logger.log(message);
        }

    }

    public static void main(String[] args) {
        EventLogger logger = EventLogger.createLogger();
        logger.log("Hello World");
        logger.log("Error occurred in 6. line");
    }

}

