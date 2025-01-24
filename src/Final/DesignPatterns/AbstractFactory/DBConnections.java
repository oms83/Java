package Final.DesignPatterns.AbstractFactory;

public class DBConnections {
    // products
    public static interface Command {
        void execute();
    }
    public static interface Connection {
        void connect();
    }

    // abstract factory
    public static interface DBProvider {
        Command getCommand();
        Connection getConnection();
    }

    // concrete product
    public static class SqlServerConnection implements Connection {
        @Override
        public void connect() {
            System.out.println("SqlServer Connecting to database...");
        }
    }
    public static class MySQLConnection implements Connection {
        @Override
        public void connect() {
            System.out.println("MySql Connecting to database...");
        }
    }
    public static class SqlServerCommand implements Command {
        @Override
        public void execute() {
            System.out.println("SqlServer Executing command...");
        }
    }
    public static class MySQLCommand implements Command {
        @Override
        public void execute() {
            System.out.println("MySql Executing command...");
        }
    }

    // concrete factory
    public static class SqlServer implements DBProvider {
        @Override
        public Connection getConnection() {
            return new SqlServerConnection();
        }

        @Override
        public Command getCommand() {
            return new SqlServerCommand();
        }
    }

    public static void main(String[] args) {
        SqlServer sqlServer = new SqlServer();
        Connection connection = sqlServer.getConnection();
        connection.connect();
        Command command = sqlServer.getCommand();
        command.execute();
    }
}
