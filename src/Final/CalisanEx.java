package Final;

public class CalisanEx {

    public static abstract class Calisan
    {
        protected String pozisyon;
        public abstract void calis();
        public Calisan(String pozisyon)
        {
            this.pozisyon = pozisyon;
        }
    }
    public static class Mudur extends Calisan
    {
        public Mudur(String pozisyon)
        {
            super(pozisyon);
        }
        public void calis()
        {
            System.out.println("Mudur");
        }
    }
    public static class Sekreter extends Calisan
    {
        public Sekreter(String pozisyon)
        {
            super(pozisyon);
        }
        public void calis()
        {
            System.out.println("Sekreter");
        }
    }
    public static class Programci extends Calisan
    {
        public Programci(String pozisyon)
        {
            super(pozisyon);
        }
        public void calis()
        {
            System.out.println("Programci");
        }
    }
    public static class Pazarlamaci extends Calisan
    {
        public Pazarlamaci(String pozisyon)
        {
            super(pozisyon);
        }
        public void calis()
        {
            System.out.println("Pazarlamaci");
        }
    }
    public static class GenelMudur extends Mudur
    {
        public GenelMudur(String pozisyon)
        {
            super(pozisyon);
        }

        @Override
        public void calis() {
            System.out.println("GenelMudur");
        }
    }

    public void main(String[] args) {

    }
}
