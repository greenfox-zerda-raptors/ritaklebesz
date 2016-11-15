/**
 * Created by Rita on 2016-11-15.
 */
public class Mentor extends Person {
    String seniorityLevel;
    String subject;

    public Mentor(String name, int age, String seniorityLevel, String subject) {
        super(name, age);
        this.seniorityLevel = seniorityLevel;
        this.subject = subject;
    }

    public String toString() {
        return super.toString() + " is a(n) " + subject + " " + seniorityLevel;
    }
}
