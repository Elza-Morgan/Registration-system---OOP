/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Elza Morgan
 */
public class CourseClass {
    int grade;
    private int courseID;
     private String courseName;
  LecturerClass lecturer;//object is declared
  /*We can create an object in a clas, in this case to be 
    able to create it we use the name of the class which is the first thing and
    then we add the Name object.This is how we link class to each other */

    int numberOfRegisteredStudents;
     
    
    CourseClass(String courseName,int courseID)
    {
        this.courseID=courseID;
        this.courseName=courseName;
    }
  public void setCourseName(String courseName)  
  {
      this.courseName=courseName;
  }
  public String getCourseName()
            
  {
      return courseName;
  
  }
  public void setCourseID(int courseID)
  {
      this.courseID=courseID;
  }
    public int getCourseID()
    {
        return courseID;
    
    }
    
    @Override
   public String toString()
  { /*String.valueOf(this.NametoBeConverted) this is used 
       to convert from int to string*/ 
 String informationOfCourse=String.valueOf(this.courseID)+"\n"+this.courseName+
       "\n"+lecturer.getLecturerName()+"\n"+this.numberOfRegisteredStudents ;
    return informationOfCourse;
   
   }
    
}
