package Observer;

public class Observer {

    public static interface   IHavaDurumuIstasyonu
    {
        void ElkeAbone(IHavaDurumuIstasyonu HavaDurumuOnChange);
        void CikarAbone(IHavaDurumuIstasyonu HavaDurumuOnChange);
        void Bildir();
    }

    public static interface IAbone extends IHavaDurumuIstasyonu
    {
        void Guncelle(float temperature, float humidity, float pressure);
    }

    public static class HavaDurumu implements IAbone {

        private float temperature;
        private float humidity;
        private float pressure;

        IHavaDurumuIstasyonu HavaDurumuOnChange;

        @Override
        public void Guncelle(float temperature, float humidity, float pressure) {

            if (this.temperature != temperature || this.humidity != humidity || this.pressure != pressure)
            {
                this.temperature = temperature;
                this.humidity = humidity;
                this.pressure = pressure;

                if (HavaDurumuOnChange != null)
                {
                    System.out.println("\n\n");
                    System.out.println("Hava durumu guncellendi");
                    HavaDurumuOnChange.Bildir();
                }
                else {
                    System.out.println("Abone degilsiniz");
                }
            }
        }

        @Override
        public void ElkeAbone(IHavaDurumuIstasyonu HavaDurumuOnChange) {
            this.HavaDurumuOnChange = HavaDurumuOnChange;
        }

        @Override
        public void CikarAbone(IHavaDurumuIstasyonu HavaDurumuOnChange) {
            HavaDurumuOnChange = null;
        }

        @Override
        public void Bildir() {

        }

        public void Yazdir()
        {
            System.out.println("temperature : " + this.temperature);
            System.out.println("humidity    : " + this.humidity);
            System.out.println("pressure    : " + this.pressure);
        }
    }

    public static void main(String[] args) {
        HavaDurumu havaDurumu = new HavaDurumu();

        IHavaDurumuIstasyonu abone = new IHavaDurumuIstasyonu() {
            @Override
            public void ElkeAbone(IHavaDurumuIstasyonu HavaDurumuOnChange) {
                havaDurumu.HavaDurumuOnChange = HavaDurumuOnChange;
            }


            @Override
            public void CikarAbone(IHavaDurumuIstasyonu HavaDurumuOnChange) {
                havaDurumu.HavaDurumuOnChange = null;
            }

            @Override
            public void Bildir() {
                havaDurumu.Yazdir();
            }
        };

        havaDurumu.ElkeAbone(abone);

        havaDurumu.Guncelle(0.5f, 0.5f, 0.5f);
        havaDurumu.Guncelle(0.5f, 0.5f, 0.5f);
        havaDurumu.Guncelle(0.1f, 0.2f, 0.1f);
        havaDurumu.Guncelle(0.2f, 0.3f, 0.3f);
        havaDurumu.CikarAbone(null);
        havaDurumu.Guncelle(0.21f, 0.2f, 0.1f);
        havaDurumu.Guncelle(0.2f, 0.3f, 0.3f);


    }
}
