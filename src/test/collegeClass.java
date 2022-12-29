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
public class collegeClass {
private int collegeID;
  private String collegeName;
  CourseClass courses[]=new  CourseClass[48];
  StudentClass students[]=new StudentClass[5];
  LecturerClass lecturer[]=new LecturerClass[6];
  int i;
  int j;
  int z;
  private static collegeClass college_Class=null; /*it is static because it must give the same copy each time*/
  /*The idea of singletone class is that to keep something constant and can't be changed for example like a LOGO of something.
  In order to do that you need to we need to declare an object in college class and set it to be prviate so it couldn't be changed
  and then assignment to null because we don't want to create here yet.
 */
 private  collegeClass(String collegeName, int collegeID)
  {
      this.collegeID=collegeID;
      this.collegeName=collegeName;
  
  }
/*i created a getter in order to accessd it and it has to be static because it was set up static
 and then in this methode will get same as constructore so for the fisrt time when i enter the name of the college and the id 
 it will enter first if conditon since it is set to nulla dn will take the name and the id.If i enter another one it will not except it becuse it is
 not null anymore its is already reserved with the perivous name and id so it will pass if condtiotn and return the previous name and id
 */
 public static collegeClass getcollege_class(String collegeName, int collegeID)
 {
     if(college_Class==null)
     {
         college_Class=new collegeClass(collegeName,collegeID);//Creation
     }
     
   return    college_Class;
 
 }
         
 /*method addcourses,addstudents,addlectrures are used to store each of the 
  objects in a different index and the value of them*/ 
  
  
    public void setCollegeName(String collegeName)  
  {
      this.collegeName=collegeName;
  }
  public String getCollegeName()
            
  {
      return collegeName;
  
  }
  public void setCollegeID(int collegeID)
  {
      this.collegeID=collegeID;
  }
    public int getCollegeID()
    {
        return collegeID;
    
    }
public void addCourse(CourseClass ObjectOfCourses)
      /*its void because i'm storing them no returning anything*/    
{
    /*here if conditon is made because everthing has a limit its not unlimited, by logic*/
    if(i<48){
  courses[i]=ObjectOfCourses;
        System.out.println("......................... This Course is registered............................");
  i++;
    }else
        System.out.println("........................... The list courses is full................................");
        
 
}
public void addStudent(StudentClass ObjectsOfStudent)
{   
    if(j<5){
students[j]= ObjectsOfStudent;
        System.out.println("...................... This student registered......................");
j++;
    }else
        System.out.println("...................... The list of students is full......................");
   
}
public void addLecturer( LecturerClass objectOfLecturer)
    {
        if(z<6){
        lecturer[z]=objectOfLecturer;
            System.out.println("...................... This lecturer registered......................");
        z++;
        }else
            System.out.println("......................The list of lecturers is full......................");
    }
@Override
public String toString()
{
   String informationOfCollege="College ID is: "+String.valueOf(this.collegeID)+"\nCollege name is: "+
   this.collegeName+"\nCourses: "+String.valueOf(this.courses.length)+
   "\nStudents: "+String.valueOf(this.students.length)+"\nLecturer: "
    +String.valueOf(this.lecturer.length);
   
   return informationOfCollege;
   
}



}
