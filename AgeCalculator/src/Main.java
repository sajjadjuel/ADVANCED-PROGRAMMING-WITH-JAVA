import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Person> person = new ArrayList<>();

        Student student = new Student();
        student.setName("Sajjad");
        student.setId("20-42576-1");
        student.setDate(LocalDate.of(2001, 6, 17));

        Employee employee = new Employee();
        employee.setName("Juel");
        employee.setSalary(25000);
        employee.setDate(LocalDate.of(1999, 6, 17));



        //System.out.println(calculator.Calculating());



        //System.out.println(calculator1.Calculating());

        person.add(student);
        person.add(employee);

        for (Person per:person) {
            per.Display();
            Calculator calculator = new Calculator(per);
            System.out.println(calculator.Calculating());

        }


    }
}