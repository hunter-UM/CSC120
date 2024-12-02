public class Family {
    private Person[] members; // Array to store family members
    private int memberCount;   // Number of family members

    // Default constructor
    public Family() {
        members = new Person[10]; // Maximum of 10 people
        memberCount = 0;          // Start with 0 members
    }

    // Method to display family information
    public void display() {
        for (int i = 0; i < memberCount; i++) {
            System.out.println(members[i]);
        }
    }

    // Method to add a person to the family
    public boolean addPerson(String name, int age) {
        if (memberCount < 10) {
            members[memberCount] = new Person(name, age);
            memberCount++;
            return true;
        } else {
            return false; // No more space in the family
        }
    }

    // Method to increment the age for a birthday
    public void birthday(String name) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getName().equalsIgnoreCase(name)) {
                members[i].incrementAge();
                break; // Exit the loop after finding the person
            }
        }
    }

    // Accessor method to return the number of people
    public int getNumberOfPeople() {
        return memberCount;
    }

    // Accessor method to return the total age of the people
    public int getTotalAge() {
        int totalAge = 0;
        for (int i = 0; i < memberCount; i++) {
            totalAge += members[i].getAge();
        }
        return totalAge;
    }
}
