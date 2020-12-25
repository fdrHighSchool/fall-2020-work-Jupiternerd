import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    final int ROWS = 30;
    final int COLUMNS = 10;
    double answer [];
    int[][] grades = new int [ROWS][COLUMNS];
    
    for (int rows = 0; rows < ROWS; rows++){
      for (int columns = 0; columns < COLUMNS; columns++){
        int grade = (int)(Math.random()* (100 - 55 + 1) + 55);
        grades[rows][columns] = grade;
      }
    }
    //System.out.println(Arrays.deepToString(grades));
    displayValues (grades);
    double[] averages = getAverages(grades);
    System.out.println(Arrays.toString(compare(averages)));

    double[] sortedAverages = compare(averages);
    System.out.println("The highest average is: " + sortedAverages[sortedAverages.length - 1]);
    System.out.println("The second highest average is: " + sortedAverages[sortedAverages.length - 2]);
    
    //System.out.println(getAverage(grades[0])); first row
  }

  // print all student's grades
  public static void displayValues(int[][] arrays) {
    for (int rows = 0; rows < arrays.length; rows++) {
      System.out.println(Arrays.toString(arrays[rows]));
    }
  }
  
  // get average for one student
  public static double getAverage(int [] array){
    double sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    return sum / (double) array.length; 
  }

  // get averages of every student
  public static double[] getAverages(int[][] arrays) {
    double[] averages = new double[arrays.length];
    for (int i = 0; i < arrays.length; i++) {
      averages[i] = getAverage(arrays[i]);
    }

    return averages;
  }
  public static double[] compare(double[] array) {
     Arrays.sort(array);
     System.out.println(array);
     return array;
  }
}