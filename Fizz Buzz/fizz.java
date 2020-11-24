/**
 * @author Wai Hlaing
 * @purpose
 * Work for fdrhs apcsa
 */

import java.util.Scanner;

class Main {

    /**
     * Calls fizzBuzz with the max iteration #.
     * @param args
     */

    public static void main(String args[]) {

        System.out.println("Starting fizzbuzz");
        Scanner sc =  new Scanner(System.in);
        System.out.println("Input max amount of fizzing and buzzing");
        int getBackMax = sc.nextInt();
        


        fizzBuzz(getBackMax);
        sc.close();
    } //end main class

    /**
     * Has conditions to check whether to output fizz, buzz or both of them depending on the iteration # it's in.
     * @param i {int} | max amount of iterations to loop through.
     * @return void;
     */

    public static void fizzBuzz(int i) {
        boolean fizzFlag, buzzFlag;

        int z = 0; //keepst track of our position and also is for seeing if its fizzing or buzzin.
        do {
            z++; //Increase z by one every time so it actually progresses the loop forward.
            fizzFlag = (z % 3 == 0);
            buzzFlag = (z % 5 == 0);
          /**
           * A lot to unpack:
           * Lets only focus on the conditional fizzFlag and buzzFlag;
           * (If fizzFlag and buzzFlag is true then we log out fizzBuzz.) IF NOT (Is fizzFlag true? log out fizz) IF NOT (is buzzFlag true? Log out buzz)
           * IF NOT (log out z);
           */
          System.out.println(z + " ? "+ (fizzFlag && buzzFlag ? "fizzBuzz" : (fizzFlag ? "fizz" : (buzzFlag ? "buzz" : z))));

        } while (z < i); 

    } //end fizzbuzz method

} // end class