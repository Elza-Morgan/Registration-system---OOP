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
public class StudentClass {
    private int studentID;
     private String studentName;
    int sizeOfTakenCourses=1;/*the reason we did it outside because this acts as my
    copy in order i can send a copy of it to many classes if needed, also because i'm using arry of objects
    i need to enter the same thing as i set in order it don't give me error nullpointer which means it doesn't 
    check my empty indexes or array*/
     CourseClass courses[]=new  CourseClass[ sizeOfTakenCourses];
     
    StudentClass(String studentName,int studentID)
    {
        this.studentID=studentID;
        this.studentName=studentName;
    
    }
      public void setStudentName(String studentName)  
  {
      this.studentName=studentName;
  }
  public String getStudentName()
            
  {
      return studentName;
  
  }
  public void setStudentID(int studentID)
  {
      this.studentID=studentID;
  }
    public int getstudentID()
    {
        return studentID;
    
    }
   @Override 
   /*The idea of tosting is that it combines everything togther and when you call it 
   sends it to you togther, in other words it is used to concatucate everything togther
   and once you  call the method tostring it will send everthing you want*/
 public String toString()
 {
     String informationOfStudents=String.valueOf(this.studentID)+"\n"
             +this.studentName+"\n"+this.courses.length;
     return informationOfStudents;
 
 }
    
}
