package Final.Solid.LSP;

public class WitoutLSP {

    public static class Person {
        public void SendEmail(String message){
            System.out.println("Person: " + message);
        }

        public void PaySalary(double salary) {
            System.out.println("Person: " + salary);
        }
    }
    public static class Employee extends Person {
        @Override
        public void SendEmail(String message){
            System.out.println("Employee: " + message);
        }

        @Override
        public void PaySalary(double salary) {
            System.out.println("Employee: " + salary);
        }
    }
    public static class Student extends Person {
        @Override
        public void SendEmail(String message){
            System.out.println("Employee: " + message);
        }

        @Override
        public void PaySalary(double salary) {
            throw new UnsupportedOperationException("not supported");
        }
    }
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.SendEmail("Hello World");
        employee.PaySalary(5000);

        Student student = new Student();
        student.SendEmail("Hello World");
        student.PaySalary(5000);
    }
}
