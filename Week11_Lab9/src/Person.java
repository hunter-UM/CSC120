public class Person {
    private String name;
    private int age;

    // Default constructor
    public Person() {
        this.name = "";
        this.age = 0;
    }

    // Constructor with parameters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to return a string representation of the person
    public String toString() {
        return name + " is " + age + " years old";
    }

    // Mutator method to increment the age of the person
    public void incrementAge() {
        this.age++;
    }

    // Accessor method to return the name of the person
    public String getName() {
        return name;
    }

    // Accessor method to return the age of the person
    public int getAge() {
        return age;
    }
}
