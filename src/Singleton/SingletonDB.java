package Singleton;

public class SingletonDB {
    public static class clsDatabase
    {
        private static clsDatabase context = null;
        private clsDatabase()
        {
        }
        public static clsDatabase GetInstance()
        {
            if (context == null)
                context = new clsDatabase();
            else
                System.out.println("cannot create more than one database");

            return context;
        }
        public void connect()
        {
            System.out.println("connecting to the database");
        }
    }

    public static void main(String[] args) {
        clsDatabase db = clsDatabase.GetInstance();
        db.connect();
    }
}
