



class SinifDiyagram {

    public static abstract class  Calisan
    {
        public String Pozisyon;

        public Calisan(String Pozisyon)
        {
            this.Pozisyon = Pozisyon;
        }

        public abstract void Calis();
    }

    public static abstract class Mudur extends Calisan
    {
        public String Pozisyon2;

        Mudur(String Pozisyon1, String Pozisyon2)
        {
            super(Pozisyon1);
            this.Pozisyon2 = Pozisyon2;
        }

        @Override
        public void Calis()
        {
            System.out.println("Mudur");
        }
    }

    public static  class GenelMudur extends Mudur
    {
        public String Pozisyon3;

        public GenelMudur(String Pozisyon1, String Pozisyon2, String Pozisyon3)
        {
            super(Pozisyon1, Pozisyon2);
            this.Pozisyon3 = Pozisyon3;
        }

        @Override
        public void Calis()
        {
            System.out.println("Genel Mudur");
        }
    }
    public static void Main(String[] args) {
        (new GenelMudur("", "","")).Calis();
    }
}
