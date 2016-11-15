import java.util.ArrayList;

/**
 * Created by Rita on 2016-11-15.
 */
public class Student extends Person {
    ArrayList<Integer> grades = new ArrayList<>();
    public Student(String name, int age) {
        super(name, age);
    }

    void addGrade(int grade) {
        if (grade <6 && grade > 0) {
            grades.add(grade);
        } else {
            System.out.println("invalid value");
        }
    }

    double getAverage() {
        double sum =0;
        for (double grade:grades) {
            sum += grade;
        }
        return sum/grades.size();
    }

    public String toString() {
        return super.toString() + " average: " + this.getAverage();
    }
}
