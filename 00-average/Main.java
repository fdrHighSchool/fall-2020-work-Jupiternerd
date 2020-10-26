/*author: Wai Hlaing*/

import java.util.*;

class Main {

    public static void main(String[] args)  {
   Scanner sc=new Scanner(System.in);
   int y = 0; //bucket
   int i = 0;
   System.out.println("# of grades?");
   int z = sc.nextInt();
   while ( i < z) {
       System.out.println("# " + Math.floor(i + 1) + " Enter your grade.");
   y+= sc.nextInt();
  i++;
}

  int fin = (y/z);

  System.out.println("Your Average is: " + fin);


  }
}
