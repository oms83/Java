public class AbstractClassEx1 {
    public static abstract class BankAccount
    {

        public interface BalanceChangedListener
        {
            void OnBalanceChanged();
        }

        BalanceChangedListener balanceChangedListener;

        public void setBalanceChangedListener(BalanceChangedListener balanceChangedListener)
        {
            this.balanceChangedListener = balanceChangedListener;
        }

        protected double balance;

        public BankAccount(double balance)
        {
            this.balance = balance;
        }

        public void Deposit(double amount)
        {
            if (amount > 0)
            {
                balance = balance + amount;

                if (balanceChangedListener != null)
                {
                    balanceChangedListener.OnBalanceChanged();
                }
            }
            else
            {
                System.out.println("Invalid Amount");
            }
        }

        public void Withdraw(double amount)
        {
            if (amount > 0 && balance >= amount)
            {
                balance = balance - amount;

                if (balanceChangedListener != null)
                {
                    balanceChangedListener.OnBalanceChanged();
                }
            }
            else
            {
                System.out.println("Insufficient Balance");
            }
        }

        public abstract double CalculateInterest();

        public double GetBalance()
        {
            return balance;
        }

        public void PrintBalance()
        {
            System.out.println("-------------------------");
            System.out.println( "New Balance: " + balance);
            System.out.println("-------------------------");
        }
    }

    public static class SavingsAccount extends BankAccount
    {
        private double _interestRate;

        public SavingsAccount(double interestRate, double balance)
        {
            super(balance);
            _interestRate = interestRate;
        }

        @Override
        public double CalculateInterest()
        {
            return  (super.balance * _interestRate / 100);
        }
    }

    public static class CheckingAccount extends BankAccount
    {
        private final double FEE = 1.5;

        public CheckingAccount(double balance)
        {
            super(balance);
        }

        @Override
        public double CalculateInterest()
        {
            System.out.println("Checking accounts do not earn interest.");
            return -1;
        }

        @Override
        public void Withdraw(double amount)
        {
            if (amount > 0 && (amount + FEE) >= amount)
            {
                balance = balance - (amount + FEE);

                if (balanceChangedListener != null)
                {
                    balanceChangedListener.OnBalanceChanged();
                }
            }
            else
            {
                System.out.println("Insufficient Balance");
            }
        }
    }

    public static void main(String[] args) {

        SavingsAccount savingsAccount = new SavingsAccount(0.2, 10000);

        savingsAccount.setBalanceChangedListener(new BankAccount.BalanceChangedListener() {
            @Override
            public void OnBalanceChanged() {
                    savingsAccount.PrintBalance();
            }
        });

        savingsAccount.Deposit(500);
        savingsAccount.Deposit(500);
        savingsAccount.Deposit(500);
        savingsAccount.Deposit(500);
        savingsAccount.Withdraw(1000);

        System.out.println(savingsAccount.CalculateInterest());

        System.out.println("\n\n============================================\n\n");

        CheckingAccount checkingAccount = new CheckingAccount(5000);

        checkingAccount.setBalanceChangedListener(new BankAccount.BalanceChangedListener() {
            @Override
            public void OnBalanceChanged() {
                checkingAccount.PrintBalance();
            }
        });

        checkingAccount.Withdraw(500);
        checkingAccount.Withdraw(500);
        checkingAccount.Deposit(2000);

    }

}
