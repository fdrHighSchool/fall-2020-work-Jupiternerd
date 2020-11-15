/**
 * @author Wai Hlaing,
 * Fraction Project
 */

import java.util.*;
import java.util.regex.*;

import javax.management.RuntimeErrorException;


class Main extends Helpers {

    /**
     * Main Method, takes in lines from console and logs them inside an Array until "quit" is logged.
     */

    public static void main(String[] args) {
        System.out.println("=========================");
        System.out.println("Input any equation.");
        System.out.println("Fully supports PEMDAS, multiple operations and calling past answer from the equation before.");
        System.out.println("=========================");
        Scanner sc = new Scanner(System.in); //Initialize Scanner with input of System.in.
        String userInput; 
        boolean isItQuit = false; //when true will quit the loop below.


        ArrayList < String > equationsArray = new ArrayList < > (); //An arraylist of strings. ex: ["2 + 5 * 9", "2 + 3", "1 + 1"]

        while (isItQuit == false) { //While it is false;
            userInput = sc.nextLine();
            equationsArray.add(userInput); //Adds into the arraylist;

            if (userInput.equalsIgnoreCase("quit")) {
                isItQuit = true;
                int Equationindex = equationsArray.size() - 1;
                equationsArray.remove(Equationindex); //Trims "quit"
                //System.out.println(produceAnswer(equationsArray) + " <- ANS");
                int i = 1; //To keep count of how many equations have been inputted in.

                for (Object equations: equationsArray) {

                    String equationStringified = equations.toString();

                    System.out.println("\nEquation #" + i + " Answer: " + produceAnswer(equationStringified));
                    i++;
                }

                System.out.println("\nAgain? (ans is already cached, reuse with keyword ans)\n[y] Yes [Any] No");
                String YorN = sc.next();
                if (YorN.equalsIgnoreCase("y")) main(null); //Calls back
                System.exit(0);


                //String[] args = new String[0];



            }

        }



        sc.close();

    } //end main method
    

    /**
     * @param equation | an arraylist of equation is needed to indexOf operator, operand and the operation symbol (+, -, /, *);
     * @return back the equation to be looped back onto again.
     * EXAMPLE: 
     * [module1, +, module2, * module3]; //THIS IS LOOP 1; 
     * [module1, +, module4]; //Module 2 and 3 got deleted and a new module takes place of the operation sign, the operation is based on the operation symbol;  
     * [module5]; //FINAL module, no more other operation to do;
     */
    public static ArrayList solver(ArrayList equation) {
        //System.out.println("WHAT " + i);
        Module operand, operator, mod;
        int num, denom;

        int markIndex;
        

        if (equation.contains("*") && equation.contains("/")) { //IF IT IS BOTH then this runs;

            int multiplyIndex = equation.indexOf("*");
            int divideIndex = equation.indexOf("/");
            if (multiplyIndex < divideIndex) { //execute multiply
                markIndex = multiplyIndex;
                operator = (Module) equation.get(markIndex - 1);

                //System.out.println(markIndex + "DID IT CHANGE");
                operand = (Module) equation.get(markIndex + 1);


                mod = (Module) multiplyFractions(operator, operand);

                equation.set(markIndex, mod);

                equation.remove(markIndex - 1);
                markIndex--;
                equation.remove(markIndex + 1);
                markIndex--;



                return equation;

            }

            if (multiplyIndex > divideIndex) { //execute divide
                markIndex = divideIndex;

                operator = (Module) equation.get(markIndex - 1);
                operand = (Module) equation.get(markIndex + 1);

                mod = (Module) divideFractions(operator, operand);




                equation.set(markIndex, mod);
                equation.remove(markIndex - 1);
                markIndex--;
                equation.remove(markIndex + 1);
                markIndex--;

                return equation;


            }




        }

        if (equation.contains("/")) {
            markIndex = equation.indexOf("/");

            operator = (Module) equation.get(markIndex - 1);
            operand = (Module) equation.get(markIndex + 1);

            mod = (Module) divideFractions(operator, operand);

            equation.set(markIndex, mod);
            equation.remove(markIndex - 1);
            markIndex--;
            equation.remove(markIndex + 1);
            markIndex--;

            return equation;

        }

        if (equation.contains("*")) {

            markIndex = equation.indexOf("*");
            operator = (Module) equation.get(markIndex - 1);

            //            System.out.println(markIndex + "DID IT CHANGE");
            operand = (Module) equation.get(markIndex + 1);

            mod = (Module) multiplyFractions(operator, operand);


            equation.set(markIndex, mod);

            equation.remove(markIndex - 1);
            markIndex--;
            equation.remove(markIndex + 1);
            markIndex--;



            return equation;

        }
        if (equation.contains("+") && equation.contains("-")) {


            int plusIndex = equation.indexOf("+");
            int minusIndex = equation.indexOf("-");
            if (plusIndex < minusIndex) { //execute minus 
                markIndex = minusIndex;

                operator = (Module) equation.get(markIndex - 1);
                operand = (Module) equation.get(markIndex + 1);

                mod = (Module) minusFractions(operator, operand);

                equation.set(markIndex, mod);
                equation.remove(markIndex - 1);
                markIndex--;
                equation.remove(markIndex + 1);
                markIndex--;

                return equation;

            }

            if (plusIndex > minusIndex) { //execute plus
                markIndex = plusIndex;

                operator = (Module) equation.get(markIndex - 1);
                operand = (Module) equation.get(markIndex + 1);

                mod = (Module) addFractions(operator, operand);

                equation.set(markIndex, mod);
                equation.remove(markIndex - 1);
                markIndex--;
                equation.remove(markIndex + 1);
                markIndex--;

                return equation;


            }




            return equation;
        }

        if (equation.contains("+")) {


            markIndex = equation.indexOf("+");
            operator = (Module) equation.get(markIndex - 1);
            operand = (Module) equation.get(markIndex + 1);

            mod = (Module) addFractions(operator, operand);

            equation.set(markIndex, mod);
            equation.remove(markIndex - 1);
            markIndex--;
            equation.remove(markIndex + 1);
            markIndex--;



            return equation;

        }
        if (equation.contains("-")) {


            markIndex = equation.indexOf("-");
            operator = (Module) equation.get(markIndex - 1);
            operand = (Module) equation.get(markIndex + 1);

            mod = (Module) minusFractions(operator, operand);

            equation.set(markIndex, mod);
            equation.remove(markIndex - 1);
            markIndex--;
            equation.remove(markIndex + 1);
            markIndex--;



            return equation;


        }
        return equation;
    }


    /**
     * @param equationArray An array of equations to be parsed, ex: ["1 + 2", "2 * 3 + 5"];
     * @return Answer to the equation.
     * 
     * @see getBackType() 
     */
    public static String produceAnswer(String equationStringified) {
        ArrayList finalEquation;



        String parsedEquation[] = equationStringified.split(" ");
        finalEquation = resolveType(parsedEquation);


        /*
        Iterator<Object> iter = finalEquation.iterator();
        while(iter.hasNext()) {
            if (!(iter.next() instanceof Module)) {  
                solver(finalEquation, iter, i);
                i--;
                System.out.println(i);
                }
                //System.out.println(i);
            
        i++;

        }   
        */
        //System.out.println(finalEquation + "FINAL ");


        int size = finalEquation.size();
        //int i = 0; 


        for (int i = size - 1; i >= 0; i--) {
            if (!(finalEquation.get(i) instanceof Module)) {
                finalEquation = solver(finalEquation);

                //i--;
            }
        }
        Module fin = (Module) finalEquation.get(0);
        pastAns = fin;
        if (fin.denominator == 1) return (Integer.toString(fin.numerator));
        if (fin.numerator > fin.denominator) {

            return mixedFrac(fin);

        }
        return (fin.numerator + "/" + fin.denominator);


    } //end produceAnswer


    /**
     * @param parsedEquation gets a single String of equation to parse using regex.
     * @return ArrayList;
     * 
     * 
     */
    public static ArrayList resolveType(String[] parsedEquation) {
        Pattern wholeWithFractionP, justFractionP, unoDigitP, operatorP, bracesP, bracesCP, ansP;
        //System.out.println(parsedEquation);

        ArrayList < Pattern > bigRegex = new ArrayList < > ();
        ArrayList finalEquationArrayList = new ArrayList < > ();

        wholeWithFractionP = Pattern.compile("(-?[1-9]+)_(-?[0-9]+)\\/(-?[0-9]+)"); //([1-9])*_([1-9][0-9])*\\/([1-9][0-9])*
        justFractionP = Pattern.compile("(-?[0-9]+)\\/(-?[0-9]+)"); //([1-9][0-9])*\\/([1-9][0-9])*
        unoDigitP = Pattern.compile("(-?[\\d]+)");
        operatorP = Pattern.compile("([*]|[-]|[+]|[/])"); //dont use / yet
        ansP = Pattern.compile("(ans)");

        bigRegex.add(wholeWithFractionP); //0
        bigRegex.add(justFractionP); //1
        bigRegex.add(unoDigitP); //2
        bigRegex.add(operatorP); //3
        bigRegex.add(ansP); //4
        //System.out.println(bigRegex);


        Module mod;


        for (Object chunks: parsedEquation) {
            //System.out.println(parsedEquation[1]);
            String toCheck;
            toCheck = (String) chunks;

            int whole, nom, denom;
            String op;
            Matcher matcher;
            int patternCount = 0;
            for (Pattern pattern: bigRegex) {

                matcher = pattern.matcher(toCheck);
                if (matcher.matches()) {
                    //System.out.println(matcher.group(1).replace("-", "a"));
                    

                    switch (patternCount) {


                        case 0: //0 is Whole numbers + fractions;

                            whole = Integer.parseInt(matcher.group(1)); 
                            nom = Integer.parseInt(matcher.group(2));
                            denom = Integer.parseInt(matcher.group(3));

                            if (whole < 0)  { nom = -1 * Math.abs(nom + Math.abs(denom * whole));
                            System.out.println("neg");} else {

                                nom = nom + (denom * whole);

                            }

                            

                            
                            
                            
                            System.out.println(nom + "/"+ denom + " : WHOLE NUMER AND FRAc");
                            mod = new Module("fractions");
                            mod.setFraction(nom, denom);

                            finalEquationArrayList.add(mod);



                            break;

                        case 1: // 1 is just a fraction

                            nom = Integer.parseInt(matcher.group(1));
                            denom = Integer.parseInt(matcher.group(2));

                            System.out.println(toCheck + " : FRACTION");

                            mod = new Module("fractions");
                            mod.setFraction(nom, denom);
                            finalEquationArrayList.add(mod);




                            break;
                        case 2: // 1 is just a digit

                            whole = Integer.parseInt(matcher.group(1));
                            mod = new Module("fractions");
                            mod.setFraction(whole, 1);
                            finalEquationArrayList.add(mod);
                            break;

                        case 3: // 3 is operater

                            finalEquationArrayList.add(matcher.group(1));
                            break;

                        case 4: //4 is the past ans

                            mod = pastAns;
                            if (mod == null) throw new RuntimeException("ERROR: past answer is not cached externally. Only use it after an equation before it.");
                            //if (!pastAns) throw Exception("Error past answer is not cached externally. Only use it after an equation before it.")

                            finalEquationArrayList.add(mod);

                            break;

                        default:

                            throw new RuntimeException("ERROR: Found no Nothing! shouldnt show since we usin regex");

                    }

                }


                patternCount++;




            }
        }



        return finalEquationArrayList; //switch to final or something
        //return operators;
    }
}

/**
 * Module Class, stores the numerator and denominator of fractions.
 */
class Module {
    int numerator, denominator;
    String type;


    /**
     * @param ty | type; 
     * Constructor for a new Module; Could have just replaced this with setFraction's code.
     */
    public Module(String ty) {
        type = ty;

    }

    /**
     * @param num | Numerator;
     * @param deno | Denominator;
     * 
     * Sets a new Module object as a fraction.
     */

    public void setFraction(int num, int deno) {
        numerator = num;
        if (deno == 0) {
            throw new RuntimeException("ERROR: 0 Should not be a denominator!");
        }
        denominator = deno;

    }


}

/**
 * Helper Class | Has all the helper methods;
 */
class Helpers {
    static Module pastAns = null;

    /**
     * AddFractions | Add two fractions;
     * @see Module class for return and params;
     * @param oper | Fractiong operating;
     * @param opped | Fraction getting operated;
     * @return Module
     */
    public static Module addFractions(Module oper, Module opped) {
        int opNum = oper.numerator;
        int opDe = oper.denominator;

        int oppedNum = opped.numerator;
        int oppedDe = opped.denominator;

    
        int numFin = opNum*oppedDe + oppedNum*opDe;
        int denomFin = opDe * oppedDe;

        Module mod = new Module("fractions");
        mod.setFraction(numFin, denomFin);

        mod = (Module) simplify(mod);



        return mod;








    } //end adding
    /**
     * minusFractions | Subtracts two fractions;
     * @see Module class for return and params;
     * @param oper | Fractiong operating;
     * @param opped | Fraction getting operated;
     * @return Module
     */
    public static Module minusFractions(Module oper, Module opped) {
        int opNum = oper.numerator;
        int opDe = oper.denominator;

        int oppedNum = opped.numerator;
        int oppedDe = opped.denominator;

        int numFin = opNum*oppedDe - oppedNum*opDe;
        
        int denomFin = opDe * oppedDe;

        Module mod = new Module("fractions");
        mod.setFraction(numFin, denomFin);

        mod = (Module) simplify(mod);




        return mod;

    } //end subtracting
    /**
     * multiplyFractions | multiply two fractions;    
     * @see Module class for return and params;
     * @param oper | Fractiong operating;
     * @param opped | Fraction getting operated;
     * @return Module
     */
    public static Module multiplyFractions(Module oper, Module opped) {

        int opNum = oper.numerator;
        int opDe = oper.denominator;

        int oppedNum = opped.numerator;
        int oppedDe = opped.denominator;


        int numFin = opNum * oppedNum;
        int denomFin = opDe * oppedDe;

        //System.out.println(numFin);

        Module mod = new Module("fractions");
        mod.setFraction(numFin, denomFin);

        mod = (Module) simplify(mod);

        return mod;
    }
     /**
     * divideFractions | divide two fractions;
     * @see Module class for return and params;
     * @param oper | Fractiong operating;
     * @param opped | Fraction getting operated;
     * @return Module
     */
    public static Module divideFractions(Module oper, Module opped) {

        int opNum = oper.numerator;
        int opDe = oper.denominator;

        int oppedNum = opped.numerator;
        int oppedDe = opped.denominator;




        int numFin = opNum * oppedDe;
        int denomFin = opDe * oppedNum;

        System.out.println(numFin);
        System.out.println(denomFin);

        Module mod = new Module("fractions");
        mod.setFraction(numFin, denomFin);

        mod = (Module) simplify(mod);

        return mod;
    }

    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */

    public static int greatestCommonDivisor(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            //System.out.println(a);
            return greatestCommonDivisor(b % a, a);
        }
    } //end greatestCommonDivisor method

    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */

    public static int leastCommonMultiple(int a, int b) {
        int ans = (a * b / greatestCommonDivisor(a, b));
        return ans;
    }


    public static Module simplify(Module A) {
        int num;
        num = A.numerator;
        int denom;
        denom = A.denominator;

        int gcdOfA = greatestCommonDivisor(num, denom);

        num = num / gcdOfA;
        denom = denom / gcdOfA;


        Module mod = new Module("fractions");
        mod.setFraction(num, denom);

        return mod;


    }


    public static String mixedFrac(Module A) {
        String ansString;
        int num, denom, whole;
        num = A.numerator;
        denom = A.denominator;

        whole = num / denom;
        num = num % denom;


        ansString = whole + "_" + num + "/" + Math.abs(denom);



        return ansString;


    }



}