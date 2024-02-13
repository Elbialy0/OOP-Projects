package school;
/**
 * This class keeping track the teacher 
 * id, salary, and name
 */

public class Teacher {
    private static int intailizeIdField =1 ;
    private final int id ;
    private float salary;
    private String name; 
    private float bouns;
    private float teacherRate ;
    private Courses course;
    /**
     * create object from teacher 
     * @param salary set the value of the salary 
     * @param name set the the name of the teacher
     * @param teacherRate set the intial rate of the teacher
     * set the id 
     */
    public Teacher(float salary, String name,float teacherRate, Courses course){
        id = intailizeIdField++;
        this.salary=salary;
        this.name=name;
        this.bouns=0;
        this.teacherRate=teacherRate;
        this.course=course;
    
    }
    /**
     * update the salary
     * @param newSalary the new salary provided by the user
     */

    public void updateSalary(float newSalary){
        this.salary=newSalary;
    }
    /**
     * set the bouns 
     * @param bouns set the value of the bouns
     */
    public void setBouns(float bouns){
        this.bouns=bouns;
    }
    // set the teaher rate
    public void setTeacherRate(float teacherRate){
        this.teacherRate=teacherRate;
    }
    /**
     * used to get the name
     *
     */
    public String getName(){
        return this.name;
    }
    // used to get the id 
    public int getId(){
        return this.id;
    }
    // used to get the main salary
    public float getMainSalary(){
        return this.salary;
    }
    // used to get the total salary
    public float getTheTotalSalary(){
        return this.bouns+this.salary;
    }
    // used to get the bouns 
    public float getBouns(){
        return this.bouns;
    }
    // used to get the teacher rate
    public float getTeacherRate(){
        return this.teacherRate;
    }
    // used to get the course that the teacher teach 
    public Courses getCourse(){
        return this.course;
    }

    /**
     *
     * @param salary pay to the teacher and add to total money spent by the school
     */
    public void  receiveSalary(){
        School.addedTotalMoneySpent((int) this.salary);
    }

    /**
     *
     * @return all data about teacher
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", bouns=" + bouns +
                ", teacherRate=" + teacherRate +
                ", course=" + course +
                '}';
    }
}
