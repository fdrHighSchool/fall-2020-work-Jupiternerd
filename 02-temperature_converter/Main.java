/* Author: Wai Hlaing
   Java 07. Temperature.java
   AP CS A
*/

import java.util.*;

class Main {

  public static void main(String[] args) {
    setup();
  }
  public static void setup() {

    Scanner sc = new Scanner(System.in);
    System.out.println("Hello, insert input and output options.\n(1) Celcius to Fahrenheit\n(2) Fahrenheit to Celcius");

    int choice;
    choice = sc.nextInt();
    //System.out.println(choice);


    Temp(choice, sc);
  }

    public static void Temp(int choice, Scanner sc) {

double from;

double result;

if (choice > 2) setup();

    System.out.println(choice == 1? "Input Celcius": "Input Fahrenheit.");
from = sc.nextInt();


   if (choice == 1) {
result = (from * 9/5) + 32;

System.out.printf("[%.1f] degree Celcius to [%.1f] degree Fahrenheit.", from, result);
   } else if (choice == 2) {
result = (from - 32) * 5/9;

System.out.printf("[%.1f] degree Fahrenheit to [%.1f] degree Celcius.", from, result);

   }






    }

}
