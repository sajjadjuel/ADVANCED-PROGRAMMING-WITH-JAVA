public class Student extends Person{
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void Display()
    {
        System.out.println("\nStudent:");
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("DOB: " +getDate());
    }
}
