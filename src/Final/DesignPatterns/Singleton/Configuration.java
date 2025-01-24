package Final.DesignPatterns.Singleton;

public  class Configuration
{
    public static class Config {
        private static Config instance;
        private Config() {}
        public static Config getInstance() {
            if (instance == null) {
                synchronized (Config.class) {
                    if (instance == null) {
                        instance = new Config();
                    }
                    else {
                        System.out.println("Configuration is already initialized");
                    }
                }
            }
            else {
                System.out.println("Configuration is already initialized");
            }
            return instance;
        }

        public void setConfig(String key, String value) {
            System.out.println(key + " : " + value);
        }
    }

    public static void main(String[] args) {
        Config config = Config.getInstance();
        config.setConfig("ConnectionStrings", "Server=.; Database=DBOMS; UserName=OMS; Password=OMS1234");
    }

}
