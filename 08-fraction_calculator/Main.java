import java.util.*;
import java.util.regex.*;

import javax.management.RuntimeErrorException;


public class Main {

//final List<Pattern> allTheListsBB = new ArrayList<>();

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
        String sInput;
        ArrayList<String> equationsString = new ArrayList<>();
        boolean quit;
        quit = false;
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        while(quit == false) {

        sInput = sc.nextLine();
        //sInput = sInput.replaceAll("[\\/]", "\\\\/");
        //System.out.print(sInput);
        equationsString.add(sInput);

        if (sInput.equalsIgnoreCase("quit")) {
          quit = true;
          int Eindex = equationsString.size() - 1;
          equationsString.remove(Eindex); //wouldnt matter cause the regex will filter it out but safe.
        }
        }


        produceAnswer(equationsString);

        // Checkpoint 2: Accept user input multiple times.
        sc.close();
    }//end main method

    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
     /*
    public static ArrayList rankArrayList(ArrayList list) {
      for (String ops : list) {
        switch(ops) {

          case "*":

          break;

          case "/":

          break;

          case "+":

          break;

          case "-":

          break;


        }
      }

      return list;
    }*/

    public static ArrayList getBackType(String[] parsedEquation) {
      Pattern wholeWithFractionP, justFractionP, unoDigitP, operatorP, bracesP, bracesCP, ansP;

      ArrayList<Pattern> bigRegex = new ArrayList<>();
      ArrayList<String> finalEquationArrayList = new ArrayList<>();
      ArrayList<String> operators = new ArrayList<>(); //add from right to left then flip the whole thing then parse the whole equation into little chunks then after chunking them read THIS arraylist first then for example the equation chunk is
       // ["6", "+", "4", "*", "2"] ignore frac for now
       // then we have this array list now with ["+", "*"]
       // we read right to left.
       //if we have * (pemdas) we read it first
       //then add it to the final array list as ["2 * 4", "ans + 6"]
       //do 2*4 then we get 8 then with 8 we replace empty object ans with 8

       //For stuff like this ["1_6/5", "+", "6/5", "*", "8/5"]
       //We do same step || we also have ["+", "*"]
       //["6/5 * 8/5", "+", "1_6/5"] => ["54/25 + 11/5"] => 54/25 + 55/25 = 109/25
       // then run the final alg to complete this (reduction).
      //finalEquationArrayList.add("boo");

      //-? ***VERY IMPORTANT IS A negative boy
      wholeWithFractionP = Pattern.compile("(-?[1-9]*)_(-?[0-9]*)\\/(-?[0-9]*)"); //([1-9])*_([1-9][0-9])*\\/([1-9][0-9])*
      justFractionP = Pattern.compile("(-?[0-9])*\\/(-?[0-9])*"); //([1-9][0-9])*\\/([1-9][0-9])*
      unoDigitP = Pattern.compile("(-?[0-9])*");
      operatorP = Pattern.compile("([\\+\\-\\*\\/])"); //dont use / yet
      ansP = Pattern.compile("(ans)");

      /*
      bracesOP = Pattern.compile("(REGEX "(" IN)");
      bracesCP = Pattern.compile("(REGEX ")" IN)");
*/
      bigRegex.add(wholeWithFractionP); //0
      bigRegex.add(justFractionP); //1
      bigRegex.add(unoDigitP); //2
      bigRegex.add(operatorP); //3
      bigRegex.add(ansP); //4
      /*
      bigRegex.add(bracesOP);
      bigRegex.add(bracesCP);
      */








      for (Object chunks : parsedEquation) {
       String x;


       x = chunks.toString();
        //System.out.println(x + " AA");




       int whole, nom, denom;

       Matcher matcher;
       int patternCount = 0;
       for (Pattern pattern: bigRegex) {
         try {
        matcher = pattern.matcher(x);
        if (matcher.matches()) {
        //  System.out.println("For regex "+pattern.pattern()+" "+ x +" is valid");

          switch(patternCount) {

            case 0: //0 is Whole numbers + fractions;

         whole = Integer.parseInt(matcher.group(1));
         nom = Integer.parseInt(matcher.group(2));
         denom = Integer.parseInt(matcher.group(3));

         System.out.println("is whole + frac" + whole + "  and with frac of " + nom + "/" + denom);

            break;

            case 1: // 1 is just a fraction

         nom = Integer.parseInt(matcher.group(1));
         denom = Integer.parseInt(matcher.group(2));
        System.out.println("isjust  frac" + "  of " + nom + "/" + denom);


            break;

            case 2: //2 i just a num (22, 1, etc digit is name only not actual)

        whole = Integer.parseInt(matcher.group(1));
        System.out.println("is just num " + whole);

            break;

            case 3: // 3 is operater
        operators.add(matcher.group(1));
        System.out.println("is just op " + operators.get(0));


            break;

            case 4: //4 is the past ans

        System.out.println("its just ans");



            break;

            default:

            throw new Exception("Found no Nothing! shouldnt show since we usin regex");

          }





        }


       patternCount++;
       } catch (Exception e) {
         System.out.print(e);

         //throw new RuntimeException("Something went wrong in parsing equation to chunks.");
       }




      }
      }




   return finalEquationArrayList;
    //return operators;
    }
    public static int add(int a, int b) {
     return 0;
    }
    public static int subtract(int a, int b) {
     return 0;
    }
    public static int multiply(int a, int b) {
    return 0;
    }
    public static int divide(int a, int b) {
    return 0;
    }
    public static String produceAnswer(ArrayList equationsString){
            for(Object equations : equationsString) {
      String equationStringified = equations.toString();

      String parsedEquation[] = equationStringified.split(" ");
      ArrayList finalEquation = getBackType(parsedEquation);




         }











        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".

        return "";

    }//end produceAnswer method



    // TODO: Fill in the space below with helper methods

    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */

    public int greatestCommonDivisor(int a, int b){ // 5, 10


if (a == 0) {return b;}
else {

  System.out.println(a);
  return greatestCommonDivisor(b % a, a);
}








    }//end greatestCommonDivisor method

    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public int leastCommonMultiple(int a, int b){
      int ans = (a * b / greatestCommonDivisor(a, b)); //test case: 4, 5
      //a*b == 4*5 = 20
      // 20 / 1 == 20



    return ans;
    }//end leastCommonMultiple

}//end class
