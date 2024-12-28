package Singleton;

public class SingletonConfig {
    public static class ConfigurationManager
    {
        private static ConfigurationManager instance;
        private String config;
        private ConfigurationManager()
        {
            this.config = "Default Configuration";
        }
        public static ConfigurationManager getInstance() {
            if (instance == null) {
                synchronized (ConfigurationManager.class) {
                    if (instance == null) {
                        instance = new ConfigurationManager();
                    }
                    else
                    {
                        System.out.println("ConfigurationManager is already set");
                    }
                }
            }
            return instance;
        }
        public String getConfig() {
            return config;
        }
    }

    public static void main(String[] args) {
        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.println(config.getConfig());
    }
}
