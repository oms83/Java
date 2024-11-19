import java.util.Scanner;

public class SCANNER {
    public static class Person
    {
        public String FirstName;
        public String LastName;
        public short Age;
        public String Address;

        public Person(){}

        public Person(String FirstName, String LastName, short Age, String Address)
        {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.Age = Age;
            this.Address = Address;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Person person = new Person();

        GetPersonInfo(person, sc);

        PrintPersonInfo(person);
    }

    private static void PrintPersonInfo(Person person) {
        System.out.println(person.FirstName + " " + person.LastName);
        System.out.println(person.Age + " " + person.Address);
    }

    private static void GetPersonInfo(Person person, Scanner sc) {
        System.out.println("Enter First Name: ");
        person.FirstName = sc.nextLine();

        System.out.println("Enter Last Name: ");
        person.LastName = sc.nextLine();

        System.out.println("Enter Age: ");
        person.Age = sc.nextShort();
        sc.nextLine();

        System.out.println("Enter Address: ");
        person.Address = sc.nextLine();
    }
}
