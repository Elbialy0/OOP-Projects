package school;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


         //create array of avilable courses
         Courses [] courses = {new Courses("Physics", 150),new Courses("Math1", 150),new Courses("Math2", 200)};
               //Create teachers of the school
         Teacher mahmoud = new Teacher(800, "Mahmoud Reda", 10, courses[0]);
        Teacher mohamed = new Teacher(800, "Mohamed Ahmed", 6, courses[1]);
        Teacher Amr = new Teacher(700, "Amr Mohamed ", 5, courses[2]);

        //add teachers to the array list
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(mohamed);
        teachers.add(mahmoud);
        teachers.add(Amr);

        // create students of the school
        Student amr = new Student(10000, 1, "Amr Ahmed");
        Student ahmed = new Student(2000, 3, "Ahmed mohamed");
        Student ali = new Student(30000, 6, "Ali Mahmoud");

        // add students to the array list
        ArrayList<Student> students = new ArrayList<>();
        students.add(ahmed);
        students.add(amr);
        students.add(ali);

        // create a school and add all data
        School mhss = new School(teachers, students);
        System.out.println(mhss.getTotalMoneyEarned());


        
    }
    
}
