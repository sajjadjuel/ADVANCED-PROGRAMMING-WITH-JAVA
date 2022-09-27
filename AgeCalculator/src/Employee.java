public class Employee extends Person{
    private int salary;

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
    public void Display() {
        System.out.println("\nEmployee:");
        System.out.println("Name: " + getName());
        System.out.println("Salary: " + getSalary());
        System.out.println("DOB: " +getDate());
    }
}
