package school;

import java.util.List;

public class School {
    private List<Teacher> teacher;
    private List<Student> student;
    private long totalMoneyEarned; 
    private long totalMoneySpent;
    /**
     * 
     * @param teacher set the list of the teachers in the school
     * @param student set the list of the students in the school
     */
    public School(List<Teacher> teacher, List<Student> student) {
        this.teacher = teacher;
        this.student = student;
        totalMoneyEarned=0;
        totalMoneySpent=0;
    }
    /**
     * 
     * @param teacher add new teacher to the staff
     */
    public void addNewTeacher(Teacher teacher, int salary){
        this.teacher.add(teacher);
        this.totalMoneySpent+=salary;
    }
    /**
     * 
     * @param student add new student to the students 
     */
    public void addNewStudent(Student student,int fees){
        this.student.add(student);
        totalMoneyEarned+=fees;
    }
    /**
     * 
     * @return all teacher in the school 
     */
    public List<Teacher> getTeacher() {
        return teacher;
    }
    /**
     * 
     * @return all student in the school 
     */
    public List<Student> getStudent() {
        return student;
    }
    /**
     *  
     * @return total money that school earned 
     */
    public long getTotalMoneyEarned() {
        return totalMoneyEarned;
    }
    /**
     * 
     * @return total money that school spent
     */
    public long getTotalMoneySpent() {
        return totalMoneySpent;
    }
    /**
     * 
     * @param id search for a student by id 
     * @return all data about the student and null if he doesn't exist
     */
    public Student getStudent(int id){
        for (Student astudent : student) {
            if(astudent.getId()==id)return astudent;
        }
        return null;
    }
    /**
     * 
     * @param id search for a student by id 
     * @return all data about the student and null if he doesn't exist
     */
    public Teacher getTeacher(int id){
        for(Teacher ateacher : teacher){
            if(ateacher.getId()==id)return ateacher;
        }
        System.out.println("Teacher not found !");
        return null;
    }


  

    
}
