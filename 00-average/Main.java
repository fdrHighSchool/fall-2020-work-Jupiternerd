/*author: Wai Hlaing*/

import java.util.*;

class Main {

    public static void main(String[] args)  {
   Scanner sc=new Scanner(System.in);
   int totalGrades = 0; //bucket
   int i = 0;
   System.out.println("# of grades?");
   int numGrades = sc.nextInt();
   while ( i < numGrades) {
       System.out.println("# " + Math.floor(i + 1) + " Enter your grade.");
   totalGrades+= sc.nextInt();
  i++;
}

  int fin = (totalGrades/numGrades);

  System.out.println("Your Average is: " + fin);


  }
}
