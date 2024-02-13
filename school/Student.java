package school;

import java.util.ArrayList;

/**
 * Created by Elbialy on 2/12/2024
 * This class is responsalbe for keeping the track of 
 * students fees, name and grade
 */
public class Student {
    //to avoid reaptaion 
    private static int intailizeIdField=1;
    // make id final because it is constant and avoid reaptaion
    private final int id; 
    private String name ;
    private int grade;
    private float feesPaid;
    private float feesTotal;
    // total grades of courses 
    private int totalGrades=0;
    // grades that student achives 
    private float studentGrade=0;
    private ArrayList<Courses> courses =new ArrayList<>();

    /*
     * To create new student by intializing 
     * id by intializeIdField and and on to it 
     * feesPaid by set it to money paid in 
     * feesTotal suppose it 30000
     * grade grade of the student 
     * name name of the student
     * 
     */

    public Student(float feesPaid , int grade , String name){
        this.id=intailizeIdField++;
        this.feesPaid=feesPaid;
        this.feesTotal=30000;
        this.grade=grade;
        this.name=name; 
        
    }
    /* Used to update the student's grade
    * @param grade new grade of the student
     */
    public void setGrade(int grade){
        this.grade=grade;

    }
    // Used to update the fees per year 
    public void setFeesTotal(float feesTotal){
        this.feesTotal=feesTotal;

    }
    // Used to add new paid fees
    public void updateFeesPaid(float fees){
        this.feesPaid+=fees;
    }
    // Used to get the id of the student 
    public int getId(){
        return this.id;
    }
    // Used to get the name of the student
    public String getName(){
        return this.name;

    }
    // Used to get the grade of the student
    public int getGrade(){
        return this.grade;
    }
    // Used to get the fees that the student paid 
    public float getFeesPaid(){
        return this.feesPaid;
    }
    // Used to get the fees that student pay over the year
    public float getFeesTotal(){
        return this.feesTotal;
    }
    // Used to check if student pay all fees or no
    public boolean isStudentPayAllFees(){
        return this.feesPaid==this.feesTotal;
    }
    // Used to know the remaining fees
    public float remainFees(){
        return this.feesTotal-this.feesPaid;
    }
    // used to set courses of the student
    public void setCourses(ArrayList<Courses> courses){
        this.courses=courses;
        // used to count the total grades of the courses
        for (Courses course : courses) {
            totalGrades+=course.getGrade();
        }
    }
    // used to get courses of the student
    public ArrayList<Courses> getCourses(){
        return courses;
    }
    // used to get the final grades of the student
    public float finalGrades(){
        for (Courses course : courses) {
            studentGrade+=course.getStudentGrade();
        }
        return studentGrade;
    }
    // used to get the total grades
    public int getTotalGrades(){
        return this.totalGrades;
    }
    // used to know if student success or not
    public boolean isSuccess(){
        return (totalGrades/2)<=studentGrade;
    }
    
    
 

}
