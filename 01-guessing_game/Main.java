/*Author@Wai Hlaing*/


import java.util.*;
import java.util.function.Function;
import java.lang.*;

class Main {
    public static void main(String[] args) {

        Setup();
    }
    public static void Begin(String FnL, Integer fInt, Integer cInt, Integer truth) {
        Scanner sc = new Scanner(System.in);
        int shotInt = 0;
        int tries = 0;
        while (shotInt != truth) {
            System.out.println("[ computer ] Take your shot!");

            shotInt = sc.nextInt();
            if (shotInt == truth) {
                tries += 1;
                System.out.println("[ computer ] You got it!\nThe answer was: " + truth + "\nTook you: " + "[" + tries + "]" + " tries!\n =========Play again? [y]=========");

                String retryO = sc.next();

                if (retryO.equalsIgnoreCase("y")) Setup();

            } else {

                System.out.println("[ computer ] Nope, hint: ");

                if (truth % 2 == 0) {
                    System.out.println("[ computer ] its even.");
                } else {
                    System.out.println("[ computer ] its odd.");
                }
                tries += 1;
            }
            //System.out.println(shotInt);
        }
        /*

        System.out.println("Take a shot!" + fInt+" - "+cInt);

        Integer shots = sc.nextInt();

          System.out.println("Workds" + truth);
          */
    }

    public static void Setup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[ computer ] Hello, input your nick name.");
        String FnL = sc.next(); //Gets name.

        System.out.println("[ computer ] Hey " + FnL + ", Choose the # floor of the game.");
        Integer fInt = sc.nextInt();
        System.out.println("[ computer ] Now choose the # ceiling of the game.");
        Integer cInt = sc.nextInt();
        System.out.println("[ computer ] Great " + FnL + ", heres your range:  " + fInt + " - " + cInt);

        System.out.println("[y/n]");

        String resetO = sc.next();

        if (resetO.equalsIgnoreCase("y")) {
            Integer truth = (int)(Math.random() * (cInt - fInt + 1) + fInt);
            Begin(FnL, fInt, cInt, truth);
        } else {
            Setup();
        }


    }
}
