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
public class LecturerClass {
private int lecturerID;
  private String lecturerName;
 int SizeOfTaughtClasses=1;
 CourseClass courses[]=new CourseClass[SizeOfTaughtClasses];/*courses(course[]) means you 
 need to create and array of objects*/
  LecturerClass(String lecturerName,int lecturerID)
  {
      this.lecturerID=lecturerID;
      this.lecturerName=lecturerName;
      
  }
  
    public void setLecturerName(String lecturerName)  
  {
      this.lecturerName=lecturerName;
  }
  public String getLecturerName()
            
  {
      return lecturerName;
  
  }
  public void setlecturerID(int lecturerID)
  {
      this.lecturerID=lecturerID;
  }
    public int getlecturerID()
    {
        return lecturerID;
    
    }
  @Override/*this is used when you have a same name of header and return type in 
  different classes, so basically all it does that it takes all these header and 
  return type under one umberalla so that no repetion happened in the program
  and it should be added above every header in each class
  The access modifiers could be changed only to a higher never to low and the 
  return type could be changed only if there is a Subtype for it */
  public String toString(){
 String informationOfLecturer=String.valueOf(this.lecturerID)+"\n Lecture name:"
  +this.lecturerName+"\n"+this.courses.length;/*the resone it is .length because 
 in the question they asked for the number of the courses which means the length
 */
 return informationOfLecturer;
  }
    
}
