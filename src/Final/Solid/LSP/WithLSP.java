package Final.Solid.LSP;

public class WithLSP {
    public static class Person {
        public void SendEmail(String message){
            System.out.println("Person: " + message);
        }
    }

    public static class Employee extends Person {
        @Override
        public void SendEmail(String message) {
            System.out.println("Employee: " + message);
        }

        public void PaySalary(double salary) {
            System.out.println("Employee: " + salary);
        }
    }

    public static class Manager extends Employee {

        @Override
        public void SendEmail(String message) {
            System.out.println("Manager: " + message);
        }

        @Override
        public void PaySalary(double salary) {
            System.out.println("Manager: " + salary);
        }
    }

    public static class Student extends Person {
        @Override
        public void SendEmail(String message){
            System.out.println("Employee: " + message);
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.SendEmail("Hello World");
        employee.PaySalary(5000);

        Manager manager = new Manager();
        employee.SendEmail("Hello World");
        employee.PaySalary(5000);

        Student student = new Student();
        student.SendEmail("Hello World");
    }

}
