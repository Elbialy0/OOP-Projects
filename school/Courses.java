package school;
/**
 * Create by Elbialy on 2/12/2024 
 * This class is responsible to enroll in courses 
 *
 */

public class Courses {
    private String name;
    private int grade;
    private float studentGrade;
    /*
    * create course by intialize name and the total 
    * grade of the course
    * 
     */

    public Courses(String name, int grade){
        this.grade=grade;
        this.name=name;

    }
    // used to set the student grade 
    public void setStudentGrade(float grade){
        this.studentGrade=grade;
    }
    // used to get the name of the course
    public String getName() {
        return name;
    }
    // used to get the grade of the course
    public int getGrade() {
        return grade;
    }
    // used to get the student grade of the course
    public float getStudentGrade() {
        return studentGrade;
    }

}
