package Singleton;

public class SingletonLog {
    public static class Logger {
        private static Logger instance;

        private Logger() {}

        public static Logger getInstance()
        {
            if (instance == null) {
                synchronized (Logger.class)
                {
                    if (instance == null)
                    {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }

        public void log(String message)
        {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Hello World!");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is a Singleton Logger!");

        System.out.println("Are both instances equal? " + (logger1 == logger2));
    }
}
