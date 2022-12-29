/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*here we created an obbject called CCIT for the class called collegeclass,so 
    whenever we want to access collegeclass we use the name of the object 
    which is "CCIT."*/

        collegeClass CCIT = collegeClass.getcollege_class("CCIT", 1);
        //collegeClass CCIT2=collegeClass.getcollege_class("CCIT2",2);//test

        System.out.println("Welcome to the course registration system main menu:\n"
                + "1.  Add a course\n"
                + "2.  Add a student\n"
                + "3.  Add a lecturer\n"
                + "4.  Register a course for a student\n"
                + "5.  Register a course for a lecturer\n"
                + "6.  Display collage information\n"
                + "7.  Display the complete list of courses\n"
                + "8.  Display the complete list of students\n"
                + "9.  Display the complete list of lecturers\n"
                + "10. Display a list of courses currently taken by a particular student\n"
                + "11. Display a list of courses currently taught by a particular lecturer\n"
                + "12. Remove a Student\n"
                + "13. Remove a Lecturer\n"
                + "14. Remove a Courses\n"
                + "15.Quit");
        System.out.print("Enter your number of choice: ");
        int choice = input.nextInt();
        /*I created the name of the objects globaly because
          i will use it later on, so inteaded of keep declaring it, i declared it once*/

 /*counter is created to count how many of the courses,students or lecturer
          to prevent garbage*/
        int counter_of_courses = 0;
        int counter_of_students = 0;
        int counter_of_lecturer = 0;
        /*These are my objects being only declared gloably to prevent from declaring it everytime i need it*/
        CourseClass courses;
        /*These objects when they are declred and if they are not created then it should be null because it acts as a local varible
        and local varible needs to be assihned to something*/
        StudentClass student = null;
        LecturerClass lecturer = null;
        /*same thing as the above onece i only declared their type globaly so i can use it
        without always saying the type*/
        String course_name;
        int course_id;
        String student_name;
        int student_id;
        String lecturer_name;
        int lecturer_id;
        int y = 0;//counter for the students
        int f = 0;//counter for the lecturer
        int n = 0;//variable for resting my choice number 4 which is "Y"
        int r = 0;//variable for resting my choice number 5 which is "f"
        /*I created an outer for loop to let the user choose again 
          and this will be infinite until the user enter 12 to break*/

        for (int q = 0; q == q; q++) {
            if (choice == 1) {
                System.out.print("Enter course Name: ");
                course_name = input.next();
                System.out.print("Enter course ID: ");
                course_id = input.nextInt();

                /*Here i CREATED an object that will take the name and the id*/
                courses = new CourseClass(course_name, course_id);
                /*Here is the calling of an object to the class called CCIT at method called addcourses, so at this methode we
                sent them the name and the id of a course which is called objectofcourses(name and the id)*/
                CCIT.addCourse(courses);
                /*Counter is added because if my length is set to whatever it is set to 
                in the class and when i enter less then what it is set, this doesn't 
                mean it have to check every index of the empty one.In otherwords this is
                used to prevent garbage or an error called nullpointer*/
                counter_of_courses++;
            }

            if (choice == 2) {
                System.out.print("Enter student Name: ");
                student_name = input.next();
                System.out.print("Enter student ID: ");
                student_id = input.nextInt();
                student = new StudentClass(student_name, student_id);//objected CREATED
                CCIT.addStudent(student);//we called CCIT and then we accessed methode called addstudent and we sent student name and add
                counter_of_students++;
            }

            if (choice == 3) {
                System.out.print("Enter Lecturer Name: ");
                lecturer_name = input.next();
                System.out.print("Enter Lecturer ID: ");
                lecturer_id = input.nextInt();
                lecturer = new LecturerClass(lecturer_name, lecturer_id);//Object Created
                CCIT.addLecturer(lecturer);//calling function
                counter_of_lecturer++;
            }

            if (choice == 4) {
                boolean flag = false;
                System.out.print("Enter Your name: ");
                student_name = input.next();
                System.out.print("Enter your ID: ");
                student_id = input.nextInt();
                for (int i = 0; i < counter_of_students; i++) {
                    if (student_name.equalsIgnoreCase(CCIT.students[i].getStudentName()) && student_id == CCIT.students[i].getstudentID()) {

                        /*this "if-condtion"is used to rest my index for the array called courses which comes under the array called student
                                  because if i didn't do that it will continue from the next index "y" after increamenting it and and will added the courses for a different name and add privous courses
                                  this is logically wrong, because as soon as i enter a new name it must have an index of courses set by 0 not from the old one.*/
                        if (n != i) {
                            y = 0;
                        }
                        System.out.println("......................This name exists......................");//my flag
                        flag = true;
                        System.out.print("Enter the course name: ");
                        course_name = input.next();
                        System.out.print("Enter the course ID: ");
                        course_id = input.nextInt();
                        courses = new CourseClass(course_name, course_id);

                        for (int j = 0; j < counter_of_courses; j++) {
                            if (course_name.equalsIgnoreCase(CCIT.courses[j].getCourseName()) && course_id == CCIT.courses[j].getCourseID()) /*if the name and id is found*/ {
                                n = i;
                                CCIT.students[i].courses[y] = courses;
                                CCIT.courses[j].numberOfRegisteredStudents++;/*so here we want the total of courses taken by the
                                                                                      students in order to let the lecturer know how many studnets are in this specific course
                                                                                      so basically we called the college which has everthing then we called the array of courses and then 
                                                                                      we called the counter which was found in the class called courses.*/
                                System.out.println("......................Student: " + CCIT.students[i].getStudentName()
                                        + " has registered " + CCIT.courses[j].getCourseName() + "......................");
                                y++;

                            }

                        }
                    }

                }
                if (flag == false) {
                    System.out.println("......................This name doesn't exists......................");
                }

            }

            if (choice == 5) {

                boolean flag = false;
                System.out.print("Enter the lecturer name: ");
                lecturer_name = input.next();
                System.out.print("Enter the lecturer ID: ");
                lecturer_id = input.nextInt();
                for (int i = 0; i < counter_of_lecturer; i++) {
                    if (lecturer_name.equalsIgnoreCase(CCIT.lecturer[i].getLecturerName()) && lecturer_id == CCIT.lecturer[i].getlecturerID()) 
                    {
                        if (r != i) {
                            f = 0;
                        }
                        /*this "if-condtion"is used to rest my index for the array called courses which comes under the array called lecturer
                               because if i didn't do that it will continue from the next index "f" after increamenting it and and will added the courses for a different name and add privous courses
                                this is logically wrong, because as soon as i enter a new name it must have an index of courses set by 0 not from the old one.*/
                        flag = true;

                        System.out.println("......................This lecturer exists......................");//my flag for lecturer
                        System.out.print("Enter the name of the courses: ");
                        course_name = input.next();
                        System.out.print("Enter the course ID: ");
                        course_id = input.nextInt();
                        courses = new CourseClass(course_name, course_id);
                        for (int j = 0; j < counter_of_courses; j++) {
                            r = i;
                            if (course_name.equalsIgnoreCase(CCIT.courses[j].getCourseName()) && course_id == CCIT.courses[j].getCourseID()) {

                                CCIT.lecturer[i].courses[f] = courses;
                                System.out.println("......................Lecturer: " + CCIT.lecturer[i].getLecturerName() + " has registered " + CCIT.courses[j].getCourseName() + "......................");
                                f++;

                            }
                        

                    }
                    if (flag == false) {
                        System.out.println("......................This lecturer doen't exists.......................");
                    }

                
                System.out.println("Enter the name of the course: ");
                course_name = input.next();
                        System.out.println(counter_of_lecturer);
                for (int h = 0; h < counter_of_lecturer; h++) {
                     if (CCIT.lecturer[h].getLecturerName().equalsIgnoreCase(lecturer_name)) {
                        System.out.print("Enter the ID of the student: ");
                        student_id = input.nextInt();
                        for (int j = 0; j < counter_of_students; j++) {

                            if (CCIT.students[j].getstudentID() == student_id) {

                                System.out.print("Enter the id for the course: ");
                                course_id = input.nextInt();
                                for (int a = 0; a < counter_of_courses; a++) {
                                    if (CCIT.students[j].courses[a].getCourseID() == course_id) {

                                        for (int z = 0; z < counter_of_courses; z++) {
                                            if (CCIT.lecturer[h].courses[z].getCourseID() == course_id) {
                                                System.out.println("Enter the grade for the student: ");
                                                CCIT.students[j].courses[a].grade = input.nextInt();
                                                System.out.println("student grade: " + CCIT.students[j].courses[a].grade);
                                            }

                                        }

                                    }

                                }

                            }

                        }

                    }

                }

            }
                }
            }

            if (choice == 6) {
                System.out.println("......................The display of college Information......................\n" + CCIT.toString());
                /// System.out.println("......................The display of college Information (Test)......................\n"+CCIT2.toString());
            }

            if (choice == 7) {
                for (int a = 0; a < counter_of_courses; a++) {
                    System.out.println("Course Name: " + CCIT.courses[a].getCourseName() + "\n course ID: " + CCIT.courses[a].getCourseID());
                }
            }

            if (choice == 8) {
                for (int a = 0; a < counter_of_students; a++) {

                    System.out.println("Studen Name: " + CCIT.students[a].getStudentName() + "\n student ID: " + CCIT.students[a].getstudentID());

                }

            }

            if (choice == 9) {
                for (int a = 0; a < counter_of_lecturer; a++) {
                    System.out.println("Lecturer Name: " + CCIT.lecturer[a].getLecturerName() + "\n lecturer ID: " + CCIT.lecturer[a].getlecturerID());

                }

            }

            if (choice == 10) {
                System.out.print("Enter your name: ");
                student_name = input.next();
                System.out.print("Enter your ID: ");
                student_id = input.nextInt();
                for (int i = 0; i < counter_of_students; i++) {
                    if (student_name.equalsIgnoreCase(CCIT.students[i].getStudentName()) && student_id == CCIT.students[i].getstudentID()) {
                        System.out.println("...................... The list of courses currently taken by a particular student......................");
                        for (int j = 0; j < student.sizeOfTakenCourses; j++) {
                            System.out.println(CCIT.students[i].getStudentName() + " has registered " + CCIT.students[i].courses[j].getCourseName() + " and the ID for this course is " + CCIT.students[i].courses[j].getCourseID());
                        }
                    }
                }

            }

            if (choice == 11) {
                System.out.print("Enter the lecturer name: ");
                lecturer_name = input.next();
                System.out.print("Enter the lecturer ID: ");
                lecturer_id = input.nextInt();
                for (int i = 0; i < counter_of_lecturer; i++) {
                    if (lecturer_name.equalsIgnoreCase(CCIT.lecturer[i].getLecturerName()) && lecturer_id == CCIT.lecturer[i].getlecturerID()) {
                        System.out.println("......................The list of courses currently taught by a particular lecturer......................");

                        for (int j = 0; j < lecturer.SizeOfTaughtClasses; j++) {
                            System.out.println(CCIT.lecturer[i].getLecturerName() + " has registered " + CCIT.lecturer[i].courses[j].getCourseName() + " and the ID for this courses is " + CCIT.lecturer[i].courses[j].getCourseID());
                        }
                    }
                }
            }
            if (choice == 12) {
                boolean flag = false;
                /*it starts false it will change until the name in the list is found and it will be true*/
                System.out.print("Enter the student name to be removed: ");
                student_name = input.next();
                System.out.print("Enter the student ID to be removed: ");
                student_id = input.nextInt();
                /*j=represnts the same as the array in college of students.*/
                for (int j = 0; j < counter_of_students; j++) {
                    /*finding the students name and id*/
                    if (student_name.equalsIgnoreCase(CCIT.students[j].getStudentName()) && student_id == CCIT.students[j].getstudentID()) {
                        flag = true;
                        System.out.println("......................Student name: " + CCIT.students[j].getStudentName() + " is removed......................");

                        /*after finding the name and id of the student we will create another array to shift the names,by restetting the 
                 another index by zero*/
                        for (int s = j; s < CCIT.students.length - 1; s++) {
                            CCIT.students[s] = CCIT.students[s + 1];
                        }
                        break;
                    }

                }
                if (flag == false) {
                    System.out.println("......................Student: " + student_name + " is not in the list of names......................");
                }
                counter_of_students--;
                CCIT.j--;

            }

            if (choice == 13) {
                boolean flag = false;
                /*it starts false it will change until the name in the list is found and it will be true*/
                System.out.print("Enter the lecturer name to be removed: ");
                lecturer_name = input.next();
                System.out.print("Enter the lecturer ID to be removed: ");
                lecturer_id = input.nextInt();
                /*j=represnts the same as the array in college of students.*/
                for (int z = 0; z < counter_of_lecturer; z++) {
                    /*finding the students name and id*/
                    if (lecturer_name.equalsIgnoreCase(CCIT.lecturer[z].getLecturerName()) && lecturer_id == CCIT.lecturer[z].getlecturerID()) {
                        flag = true;
                        System.out.println("......................Lecturer: " + CCIT.lecturer[z].getLecturerName() + " is removed......................");

                        /*after finding the name and id of the student we will create another array to shift the names,by restetting the 
                 another index by zero*/
                        for (int l = z; l < CCIT.lecturer.length - 1; l++) {
                            CCIT.lecturer[l] = CCIT.lecturer[l + 1];
                        }
                        break;
                    }
                }
                if (flag == false) {
                    System.out.println("......................Lecturer: " + lecturer_name + " is not in the list of names......................");
                }

                counter_of_lecturer--;
                CCIT.z--;

            }

            if (choice == 14) {
                boolean flag = false;
                System.out.print("Enter Course name: ");
                course_name = input.next();
                System.out.print("Enter course ID: ");
                course_id = input.nextInt();
                for (int i = 0; i < counter_of_courses; i++) {
                    if (course_name.equalsIgnoreCase(CCIT.courses[i].getCourseName()) && course_id == CCIT.courses[i].getCourseID()) {
                        flag = true;
                        System.out.println("......................Courses: " + CCIT.courses[i].getCourseName() + " is removed......................");

                        for (int c = i; c < CCIT.courses.length - 1; c++) {
                            CCIT.courses[c] = CCIT.courses[c + 1];
                        }
                        break;
                    }

                }

                if (flag == false) {
                    System.out.println("......................Course: " + course_name + " is not in the list of names......................");
                }

                counter_of_courses--;
                CCIT.i--;
            }
            if (choice == 15) {
                break;
            } else {
                System.out.println("Welcome back again to the main manu\n"
                        + "1.  Add a course\n"
                        + "2.  Add a student\n"
                        + "3.  Add a lecturer\n"
                        + "4.  Register a course for a student\n"
                        + "5.  Register a course for a lecturer\n"
                        + "6.  Display collage information\n"
                        + "7.  Display the complete list of courses\n"
                        + "8.  Display the complete list of students\n"
                        + "9.  Display the complete list of lecturers\n"
                        + "10. Display a list of courses currently taken by a particular student\n"
                        + "11. Display a list of courses currently taught by a particular lecturer\n"
                        + "12. Remove a Student\n"
                        + "13. Remove a Lecturer\n"
                        + "14. Remove a Courses\n"
                        + "15. Quit");
                System.out.print("\nEnter another choice: ");
                choice = input.nextInt();
            }
        }
    }

}
