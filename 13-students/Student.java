import java.util.*;

public class Student {
  // instance variables
  private String name;
  private String osis;
  private int[] grades;

  //------------------------------------------------//

  // constructor
  public Student(String n, String o) {
    this.name = n;
    this.osis = o;
    grades = new int[10];
  }//end constructor method

  //------------------------------------------------//

  // other methods
  public String getName() {


    return this.name;
  }//end getName method


  public String getOSIS() {

    return this.osis;
  }//end getOSIS method


  public void setName(String name) {
    this.name = name;

  }//end setName method

  /*
   * N: addGrade
   * P: take-in a single grade and add it to the student's gradebook.
        should find the first non-zero index in the array and insert the grade
        there. if there is no room for that value, replace the lowest grade in 
        array with it.
   * I: grade (int)
   * R: n/a
   */
  public void addGrade(int grade) {
    int iterationOfGrades = 0, lowest = grades[0], lowestIndex = 0; //Iteration Number to use in arrays;
    
    for (int items : grades) { //For loop to iterate through the grades array. It makes items hold the value in grades arr through each iteration.
      if (items == 0) { //If there is a 0 in grades array of 10 then run.
        grades[iterationOfGrades] = grade;
        break;
      }
      if (lowest > grades[iterationOfGrades]) {//if there is no 0 then run this and the code after;
        lowest = grades[iterationOfGrades];
        lowestIndex = iterationOfGrades;
      }
      


      iterationOfGrades++; //add one every loop

    }
    grades[lowestIndex] = grade;
    
    System.out.println(lowest);
    



  }//end addGrade method


  public double calculateAverage() {
    int bucket = 0, actualGrades = 0; //hold the int;
    
    for (int items : grades) {
      /**VVVVVVVVVVVVVVVVVVVVVVVVVVVV ??? */
      if (items != 0) actualGrades++;//actual grades see if its not a 0 
      bucket += items; // for every items in the grades arr add it to the bucket

    }
    System.out.println(actualGrades);
    final double average = (double) (bucket/actualGrades);
    return average; //return the average, bucket divided by actualGrades
  }//end calculateAverage() method

  /*
   * Returns the String representation of a Student.
   * Right now, we are choosing to display the student's name and OSIS.
   * NOTE: This method overrides the default toString method that
   *       displays the memory address.
   */
  public String toString() {
    return "Student: " + this.name + " OSIS: " + this.osis;

  }//end toString method


}//end class
