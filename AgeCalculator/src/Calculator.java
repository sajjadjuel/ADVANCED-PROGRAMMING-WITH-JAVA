import java.time.LocalDate;
import java.time.Period;

public class Calculator<T extends Person> {
    private T person;

    public Calculator(T person) {

        this.person = person;
    }

    public String Calculating() {
        String age;
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(person.getDate(), currentDate);


        System.out.println("Calculate from : " + currentDate);
        age = "Age is: " + period.getDays() + " days " + period.getMonths() + " months " + period.getYears() + " years";


        return age;
    }
}
