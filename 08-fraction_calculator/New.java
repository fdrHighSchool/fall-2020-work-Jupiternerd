import java.util.*;
import java.util.regex.*;

import javax.management.RuntimeErrorException;

/**
 * @author Wai Hlaing,
 * Fraction Project
 */
class New extends Helpers {
    Module pastAns;

    /**
     * Main Method, takes in lines from console and logs them inside an Array until "quit" is logged.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Initialize Scanner with input of System.in.
        String userInput;
        boolean isItQuit = false;
        
        
        ArrayList<String> equationsArray = new ArrayList<>(); 
        
        while(isItQuit == false) {
            userInput = sc.nextLine();
            equationsArray.add(userInput);

            if (userInput.equalsIgnoreCase("quit")) {
                isItQuit = true;
                int Equationindex = equationsArray.size() - 1;
                equationsArray.remove(Equationindex); //Trims "quit"
                System.out.println(produceAnswer(equationsArray));
            }
        }
  
        

        sc.close();
          
      }//end main method
      

    public static ArrayList solver(ArrayList equation) {
        //System.out.println("WHAT " + i);
        Module operand, operator, mod;
        int num, denom;

        int markIndex;

        if (equation.contains("*")) {
            
            markIndex = equation.indexOf("*");
            System.out.println(markIndex + " ITS WHERE * IS");

            operator = (Module) equation.get(markIndex - 1);

//            System.out.println(markIndex + "DID IT CHANGE");
            operand = (Module) equation.get(markIndex + 1);

            
            System.out.println("THIS IS NUM FOR OPERAT" + operator.numerator);
            System.out.println("THIS IS NUM FOR OPERAND" + operand.numerator);




            num = operator.numerator * operand.numerator;
            denom = operator.denominator * operator.denominator;
            
            mod = new Module("fraction");
            mod.setFraction(num, denom);

            equation.set(markIndex, mod);

            equation.remove(markIndex - 1);
            markIndex--;
            equation.remove(markIndex + 1);
            markIndex--;
            
            Module x = (Module) equation.get(0);
            System.out.println(x.numerator + " X");
            
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

        System.out.println(" I AM ADDING " );

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

    
    public static String produceAnswer(ArrayList equationsArray){
        ArrayList finalEquation;

        
        
        for(Object equations : equationsArray) {
            String equationStringified = equations.toString();
    
            String parsedEquation[] = equationStringified.split(" ");
            finalEquation = getBackType(parsedEquation);
            System.out.println(finalEquation);
        
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
                    System.out.println(finalEquation + " | " + i);
                    //i--;
    
                    }
            }
            
            
            /*
            int i = 0;
            int z = 0;
            
            

            while (z < size ) {
                //Object x = finalEquation.get(i);
                if (!(finalEquation.get(i) instanceof Module)) {
                finalEquation = solver(finalEquation, i);
               // System.out.println(finalEquation + " | " + i + " / " + size);
                
                

                }
            z++;


                //System.out.println(x);


            }
            */
            
            /*
            for (Object modules : finalEquation) {
                if (!(modules instanceof Module)) {  
            solver(finalEquation, modules, i);
                } 
            
            i++;
            }
            */
            
            //Module convertee = (Module) modules; NOT APRAT
            

        
            
          }


        
        return "";
        
      }//end produceAnswer


    /**
     * @param parsedEquation gets a single String of equation to parse using regex.
     * @return Array 
     */

    public static ArrayList getBackType(String[] parsedEquation) {
        Pattern wholeWithFractionP, justFractionP, unoDigitP, operatorP, bracesP, bracesCP, ansP;

        ArrayList < Pattern > bigRegex = new ArrayList < > ();
        ArrayList finalEquationArrayList = new ArrayList < > ();
        //ArrayList < String > operators = new ArrayList < > (); //add from right to left then flip the whole thing then parse the whole equation into little chunks then after chunking them read THIS arraylist first then for example the equation chunk is

        wholeWithFractionP = Pattern.compile("(-?[1-9]*)_(-?[0-9]*)\\/(-?[0-9]*)"); //([1-9])*_([1-9][0-9])*\\/([1-9][0-9])*
        justFractionP = Pattern.compile("(-?[0-9]*)\\/(-?[0-9]*)"); //([1-9][0-9])*\\/([1-9][0-9])*
        unoDigitP = Pattern.compile("(-?[0-9]*)");
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
            String toCheck;
            toCheck = (String) chunks;
            int whole, nom, denom;
            char op;
            Matcher matcher;
            int patternCount = 0;
            for (Pattern pattern: bigRegex) {
                try {
                    matcher = pattern.matcher(toCheck);
                    if (matcher.matches()) {
                        switch (patternCount) {

                            case 0: //0 is Whole numbers + fractions;

                                whole = Integer.parseInt(matcher.group(1));
                                nom = Integer.parseInt(matcher.group(2));
                                denom = Integer.parseInt(matcher.group(3));

                                nom = nom + (denom * whole);

                                mod = new Module("fraction");
                                mod.setFraction(nom, denom);


                                
                                finalEquationArrayList.add(mod);
                                System.out.println(finalEquationArrayList);

                                System.out.println("is whole + frac" + whole + "  and with frac of " + nom + "/" + denom);

                                break;

                            case 1: // 1 is just a fraction

                                nom = Integer.parseInt(matcher.group(1));
                                denom = Integer.parseInt(matcher.group(2));

                                mod = new Module("fraction");
                                mod.setFraction(nom, denom);
                                finalEquationArrayList.add(mod);
                                System.out.println("isjust  frac" + "  of " + nom + "/" + denom);


                                break;

                            case 2: //2 i just a num (22, 1, etc digit is name only not actual)

                                whole = Integer.parseInt(matcher.group(1));
                                System.out.println("is just num " + whole);

                                mod = new Module("fraction");
                                mod.setFraction(whole, 1);
                                
                                finalEquationArrayList.add(mod);

                                break;

                            case 3: // 3 is operater
                                
                                System.out.println("is just op ");
    
                                op = matcher.group(1).charAt(0);
         
                                System.out.println(op);


                                finalEquationArrayList.add(op);


                                break;

                            case 4: //4 is the past ans

                                System.out.println("its just ans");
                                //if (!pastAns) throw Exception("Error past answer is not cached externally. Only use it after an equation before it.")

                                finalEquationArrayList.add("ans");

                                break;

                            default:

                                throw new RuntimeException("Found no Nothing! shouldnt show since we usin regex");

                        }

                    }


                    patternCount++;
                } catch (Exception e) {
                    System.out.print(e);

                }

                




            }
        }



        System.out.println(finalEquationArrayList + "FINAL");
        return finalEquationArrayList; //switch to final or something
        //return operators;
    }   
}

class Module {
    int numerator, denominator;
    String type;



    public Module(String ty) {
        type = ty;

    }

    public void setFraction(int num, int deno) {
        numerator = num;
        if (deno == 0)  { 
            throw new RuntimeException("0 Should not be a denominator!"); 
        }
        denominator = deno;

    }


}


 /**
  * @param type, String
  * @param operand Array, 
  * @param sign chat,
  * @param operator Array,
  * @param 
  */





class Helpers {
    
  

    public static Module addFractions(Module oper, Module opped) {
        int opNum = oper.numerator;
        int opDe = oper.denominator;

        int oppedNum = opped.numerator;
        int oppedDe = opped.denominator;

        //int numFin = (opNum)*(denomFin/opDe)+(oppedNum)*(denomFin/oppedDe);//2/5 - 5/10 // 2 * ( 10/5 )+  
        int numFin = (opNum * oppedDe) + (oppedNum * opDe);
        int denomFin = opDe * oppedDe;        

        Module mod = new Module("fractions");
        mod.setFraction(numFin, denomFin);

        mod = (Module) simplify(mod);

        System.out.println(mod.numerator + " bb / bb " + mod.denominator);

        return mod;


        


        


    } //end adding

    public static Module minusFractions(Module oper, Module opped) {
        int opNum = oper.numerator;
        int opDe = oper.denominator;

        int oppedNum = opped.numerator;
        int oppedDe = opped.denominator;



      
        return oper;

    } //end subtracting

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

    public static int leastCommonMultiple(int a, int b){
        int ans = (a * b / greatestCommonDivisor(a, b)); 
      return ans;
      }


    public static Module simplify(Module A) {
        int num;
        num = A.numerator;
        int denom;
        denom = A.denominator;

        int gcdOfA = greatestCommonDivisor(num, denom);

        num = num/gcdOfA;
        denom = denom/gcdOfA;

        

        Module mod = new Module("fraction");
        mod.setFraction(num, denom);

        return mod;


    }


}




