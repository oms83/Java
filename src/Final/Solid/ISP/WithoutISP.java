package Final.Solid.ISP;

import java.util.Arrays;
import java.util.List;

public class WithoutISP {

    public static interface IBaseRepository
    {
        void Delete(int id);
        void Update(int id, Object newObject);
        int add(Object newObject);
        Object get(int id);
        List<Object> getAll();
    }
    public static class Country implements IBaseRepository
    {

        @Override
        public void Delete(int id) {
            // kullanmasi dogur degil
        }

        @Override
        public void Update(int id, Object newObject) {
            // kullanmasi dogur degil
        }

        @Override
        public int add(Object newObject) {
            // kullanmasi dogur degil
            return -1;
        }

        @Override
        public Object get(int id) {
            return "Syira";
        }

        @Override
        public List<Object> getAll() {
            return Arrays.asList("Syria", "Turkiye");
        }
    }
    public static void main(String[] args) {
        Country country = new Country();

        for (Object object : country.getAll()) {
            System.out.println(object);
        }

        System.out.println("\n");

        System.out.println(country.get(0));
    }

}
