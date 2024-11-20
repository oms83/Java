import java.util.Scanner;

public  class RealExampleOopWithPolymorphism {

    public static abstract class PaymentMethod {

        protected int _amount;

        public PaymentMethod(int amount) {
            this._amount = amount;
        }

        public abstract float CalcCommission();

        public void MakePayment()
        {
            float  commission = CalcCommission();

            System.out.println("Commission: " + commission);
            System.out.println("Amount: " + this._amount);
            System.out.println("Total Amount: " + this._amount + commission);
        }
    }

    public static class CreditCardPayment extends PaymentMethod {

        public CreditCardPayment(int amount) {
            super(amount);
        }

        @Override
        public float CalcCommission() {
            return  (float)((float) super._amount * 0.1);
        }

        @Override
        public void MakePayment() {
            System.out.println("\n---------------------------");
            System.out.println("Credit Card Payment Method");
            super.MakePayment();
        }
    }

    public static class RemitPayment extends PaymentMethod {

        public RemitPayment(int amount) {
            super(amount);
        }

        @Override
        public float CalcCommission() {
            return  (float)((float) super._amount * 0.2);
        }

        @Override
        public void MakePayment() {
            System.out.println("\n----------------------------");
            System.out.println("Remit Payment Method");
            super.MakePayment();
        }
    }

    public static class PaymentAtTheDoor extends PaymentMethod {

        public PaymentAtTheDoor(int amount) {
            super(amount);
        }

        @Override
        public float CalcCommission() {
            return  (float)5;
        }

        @Override
        public void MakePayment() {
            System.out.println("\n---------------------------");
            System.out.println("Payment At The Door Method");
            super.MakePayment();
        }
    }

    public static void main(String[] args) {

        /*
            PaymentAtTheDoor paymentAtTheDoor = new PaymentAtTheDoor(1000);
            CreditCardPayment creditCardPayment = new CreditCardPayment(1000);
            RemitPayment remitPayment = new RemitPayment(1000);
        */

        PaymentMethod paymentMethod1 = new PaymentAtTheDoor(1000);
        PaymentMethod paymentMethod2 = new CreditCardPayment(1000);
        PaymentMethod paymentMethod3 = new RemitPayment(1000);

        InstanceOf(paymentMethod1);
        InstanceOf(paymentMethod2);
        InstanceOf(paymentMethod3);
    }

    private static void InstanceOf(PaymentMethod paymentMethod)
    {
        switch(paymentMethod)
        {
            case  PaymentAtTheDoor paymentAtTheDoor ->
            {
                paymentAtTheDoor.MakePayment();
            }

            case CreditCardPayment creditCardPayment ->
                creditCardPayment.MakePayment();

            case RemitPayment remitPayment ->
                remitPayment.MakePayment();

            default -> System.out.println("Invalid PaymentMethod");
        }

//        switch(paymentMethod)
//        {
//            case  PaymentAtTheDoor paymentAtTheDoor:
//                paymentAtTheDoor.MakePayment();
//                break;
//
//            case CreditCardPayment creditCardPayment:
//                    creditCardPayment.MakePayment();
//                    break;
//            case RemitPayment remitPayment:
//                    remitPayment.MakePayment();
//                    break;
//
//            default: System.out.println("Invalid PaymentMethod");
//        }
    }
}
