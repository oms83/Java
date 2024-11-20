public class EmployeesHierarchyUsingPolymorphsim {

    public static abstract class Employee{

        protected String name;
        protected int YearsOfService ;

        public Employee(String name, int YearsOfService) {
            this.name = name;
            this.YearsOfService = YearsOfService;
        }

        public abstract double CalculateSalary();

        public int AnnualLeaveDays()
        {
            return 14;
        }

        public void PrintInfo()
        {
            System.out.println("Name: " + name);
            System.out.println("Years of Service: " + YearsOfService);
            System.out.println("Annual Leave Days: " + AnnualLeaveDays());
        }
    }

    public static class Manager extends Employee{

        public Manager(String name, int YearsOfService) {
            super(name, YearsOfService);
        }

        @Override
        public double CalculateSalary() {
            return  5000 + (300 * super.YearsOfService);
        }

        @Override
        public int AnnualLeaveDays() {
            return 30;
        }

        @Override
        public void PrintInfo()
        {
            System.out.println("\n---------------------------");
            System.out.println("Manager Information");
            System.out.println("---------------------------");
            super.PrintInfo();
            System.out.println("---------------------------");

        }
    }

    public static class Developer extends Employee{

        private String [] _ProgrammingLanguages;

        public Developer(String [] ProgrammingLanguages, String name, int YearsOfService) {
            super(name, YearsOfService);
            this._ProgrammingLanguages = ProgrammingLanguages;
        }

        @Override
        public double CalculateSalary() {
            return  5000 + (300 * super.YearsOfService);
        }

        @Override
        public int AnnualLeaveDays() {
            return 20;
        }

        @Override
        public void PrintInfo()
        {
            System.out.println("\n---------------------------");
            System.out.println("Developer Information");
            System.out.println("---------------------------");
            super.PrintInfo();
            System.out.println("Programming Languages: " + String.join(", ", _ProgrammingLanguages));
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {

        Manager manager = new Manager("Omer MEMES", 10);

        Developer developer = new Developer(new String []{"C", "C++", "C#", "Java"}, "Omer MEMES", 5);

        manager.PrintInfo();

        developer.PrintInfo();
    }
}
