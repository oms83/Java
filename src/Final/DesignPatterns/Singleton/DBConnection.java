package Final.DesignPatterns.Singleton;

public class DBConnection {

    private static volatile DBConnection instance = null;

    private DBConnection() {}

    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database!");
    }

    public static void main(String[] args) {
        DBConnection connection1 = DBConnection.getInstance();
        connection1.connect();

        DBConnection connection2 = DBConnection.getInstance();
        connection2.connect();

        System.out.println(connection1 == connection2);
    }
}
