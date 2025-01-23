package Final.Solid.ISP;

import java.util.Arrays;
import java.util.List;

public class WithISP {
    public static interface IBaseRepository extends IReadOnlyRepository {
        void Delete(int id);
        void Update(int id, Object newObject);
        int add(Object newObject);

    }

    public static interface IReadOnlyRepository {
        Object get(int id);
        List<Object> getAll();
    }

    public static class Country implements IReadOnlyRepository {
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
