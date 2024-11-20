public class RealExampleOopWithoutPolymorphism {

    public static class PaymentMethod {

        private int _amount;

        public PaymentMethod(int amount) {
            this._amount = amount;
        }

        public void CreditCardPayment()
        {
            float commission = (float) ((float) this._amount * 0.1);

            System.out.println("\n----------------------------");
            System.out.println("Credit Card Payment Method");
            System.out.println("Commission: " + commission);
            System.out.println("Amount: " + _amount);
            System.out.println("Total Amount: " + this._amount + commission);
        }

        public void RemitPayment()
        {
            float commission = (float) ((float) this._amount * 0.2);

            System.out.println("\n----------------------------");
            System.out.println("Remit Payment Method");
            System.out.println("Commission: " + commission);
            System.out.println("Amount: " + _amount);
            System.out.println("Total Amount: " + this._amount + commission);
        }

        public void PaymentAtTheDoor()
        {
            float commission = (float) 5.0;

            System.out.println("\n----------------------------");
            System.out.println("Payment At The Door Method");
            System.out.println("Commission: " + commission);
            System.out.println("Amount: " + _amount);
            System.out.println("Total Amount: " + this._amount + commission);
        }
    }

    public static void main(String[] args) {

        PaymentMethod paymentMethod = new PaymentMethod(1000);

        paymentMethod.CreditCardPayment();
        paymentMethod.RemitPayment();
        paymentMethod.PaymentAtTheDoor();
    }
}
