import java.util.*;
import java.util.regex.*;


public class Main {
int ans;
//final List<Pattern> allTheListsBB = new ArrayList<>();

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
        String sInput;
        List<String> equationsString = new ArrayList<>();
        boolean quit;
        quit = false;
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        while(quit == false) {

        sInput = sc.nextLine();
        equationsString.add(sInput);

        if (sInput.equalsIgnoreCase("quit")) quit = true;
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
    public static String produceAnswer(List equationsString){
      Pattern wholeWithFractionP, justFractionP, unoDigitP, operatorP;
      Matcher mF, jF, dF, op;
      //List<String> parsedEquation = new ArrayList<>();
      //-? ***VERY IMPORTANT IS A negative boy
      wholeWithFractionP = Pattern.compile("(-?[1-9]*)_(-?[0-9]*)\\/(-?[0-9]*)"); //([1-9])*_([1-9][0-9])*\\/([1-9][0-9])*
      justFractionP = Pattern.compile("(-?[0-9])*\\/(-?[0-9])*"); //([1-9][0-9])*\\/([1-9][0-9])*
      unoDigitP = Pattern.compile("-?[0-9]*");
      operatorP = Pattern.compile("[\\+\\-\\*\\/]");


      for(Object equations : equationsString) {
      String equationStringified = equations.toString();

      String parsedEquation[] = equationStringified.split(" ");




      for (Object chunks : parsedEquation) {
        String x;
       x = chunks.toString();
       mF = wholeWithFractionP.matcher(x);
       jF = justFractionP.matcher(x);
       dF = unoDigitP.matcher(x);
       op = operatorP.matcher(x);
       int whole, nom, denom;
       String operator = null;


       if (mF.matches()) {


         whole = Integer.parseInt(mF.group(1));
         nom = Integer.parseInt(mF.group(2));
         denom = Integer.parseInt(mF.group(3));


        // System.out.println(mF.group(1));





       System.out.println(x + "its whole with frac WITH " + whole + " as WHOLE with " + nom + "/" + denom + " as the Fraction part");

       }
       if (jF.matches()) System.out.println(x + "its just a pure frac");
       if (dF.matches()) System.out.println(x + "its just a pure digit");
       if (op.matches()) System.out.println(x + "its just an operator");
 //ArithmeticException("e");

       if(operator == null) throw new ArithmeticException("Found no Operator!");












      }
      //Error handling


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

    public int greatestCommonDivisor(int a, int b){

    ans = 0;
    return ans;
    }//end greatestCommonDivisor method

    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public int leastCommonMultiple(int a, int b){

    ans = 0;
    return ans;
    }//end leastCommonMultiple

}//end class
