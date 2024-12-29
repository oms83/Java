package PracticesOnDesignPatterns;

// Single Sign on System - Singleton Design Pattern
// bir siniftan tek bir nesnse olsutumamizi saglar ve buna static\ gloabal olarak erismemizi saglar
public class SSO_Singleton {

    public static class Login
    {
        private static Login instance;
        private final String username;
        private final String password;

        private Login(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public static Login loginToSystem(String username, String password)
        {
            if (instance == null)
            {
                synchronized (Login.class)
                {
                    if (instance == null)
                    {
                        instance = new Login(username, password);
                    }
                }
            }
            return instance;
        }

        @Override
        public String toString() {
            return "Login{" + "username=" + username + ", password=" + password + '}';
        }
    }

    public static void main(String[] args) {
        Login omsLogin = Login.loginToSystem("Oms", "oms83");
        omsLogin = Login.loginToSystem("Oms", "dsdvsd");
        System.out.println(omsLogin); // Login{username=Oms, password=oms83}

        Login aliLogin = Login.loginToSystem("Ali", "Ali83");
        System.out.println(aliLogin); // Login{username=Oms, password=oms83}
    }
}
