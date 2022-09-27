import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Student student = new Student();
        student.setName("Sajjad");
        student.setId("20-42576-1");
        student.setDate(LocalDate.of(2001, 6, 17));

        Employee employee = new Employee();
        employee.setName("Juel");
        employee.setSalary(25000);
        employee.setDate(LocalDate.of(1999, 6, 17));

        Calculator calculator = new Calculator(student);
        System.out.println("Student:\n");
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("DOB: " + student.getDate());
        System.out.println(calculator.Calculating());

        Calculator calculator1 = new Calculator(employee);
        ;
        System.out.println("Employee:\n");
        System.out.println("Name: " + employee.getName());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("DOB: " + employee.getDate());
        System.out.println(calculator1.Calculating());


    }
}