import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

class Employee3 implements Comparable<Employee3> {
    private int id;
    private String name;

    public Employee3(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Two Employees are equal if their IDs are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee3 employee = (Employee3) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Compare employees based on their IDs
    @Override
    public int compareTo(Employee3 employee) {
        return this.getId() - employee.getId();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


public class TreeSetUserDefinedObjectExample {
    public static void main(String[] args) {
        // Creating a TreeSet of User Defined Objects.

        /*
           The requirement for a TreeSet of user defined objects is that

           1. Either the class should implement the Comparable interface and provide
              the implementation for the compareTo() function.
           2. Or you should provide a custom Comparator while creating the TreeSet.
        */

        SortedSet<Employee3> employees = new TreeSet<>();

        // TreeSet uses the compareTo() method of the Employee class to compare two employees and sort them
        employees.add(new Employee3(1010, "Rajeev"));
        employees.add(new Employee3(1005, "Sachin"));
        employees.add(new Employee3(1008, "Chris"));

        System.out.println("Employees (sorted based on Employee class's compareTo() function)");
        System.out.println(employees);

        // Providing a Custom Comparator (This comparator compares the employees based on their Name)
        employees = new TreeSet<>(Comparator.comparing(Employee3::getName));

        employees.add(new Employee3(1010, "Rajeev"));
        employees.add(new Employee3(1005, "Sachin"));
        employees.add(new Employee3(1008, "Chris"));

        System.out.println("\nEmployees (sorted based on the supplied Comparator)");
        System.out.println(employees);

    }
}
