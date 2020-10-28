import java.util.Scanner;
/*author: Wai Hlaing
  Apcsa work
*/
public class Main {
    public static void main(String[] args) {
        //get two points from the user (x, y)
        //ex: (3, 5)...stored as a String
        Scanner s = new Scanner(System.in);

        System.out.print("Enter point 1: ");
        String point1 = s.nextLine();

        System.out.print("Enter point 2: ");
        String point2 = s.nextLine();


        System.out.printf("The distance between %s and %s is...\n", point1, point2);
        //parse, meaning, get ints from String, the information from the inputs
        //(3, 4) --> x1 = 3, y1 = 4
        int xAndy[] = new int[4];

        xAndy[0] = getX(point1);
        xAndy[1] = getY(point1);
        xAndy[2] = getX(point2);
        xAndy[3] = getY(point2);
        System.out.println("Taxicab Distance: " + cab(xAndy));
        System.out.println("Cartesian Distance: " + cart(xAndy));
        System.out.println("Your max X: " + maxX(xAndy));
        System.out.println("Your max Y: " + maxY(xAndy));


        //send data to methods to calculate distance


        /*
        TEST CASES:
        (0, 0) & (3, 4) --> euclideanDistance = 5, taxicabDistance = 7 (WORKS)
        (0, 0) & (5, 12) --> euclideanDistance = 13, taxicabDistance = 17 (WORKS)
        Do negative coordinates work? If not, how would you go about fixing that? (Should work)

        */

    } //end main


    /*
     * N: euclideanDistance
     * P: determine the distance between any two points on x/y axis (diagonal)
     * I: pass in x1, y1, x2, y2
     * R: the result of the distance formula: sqrt((x2 - x1)^2 + (y2 - y1)^2)
     */
    public static int cart(int[] xAndy) {
        int ans;
        int a;
        int b;



        a = Math.abs(xAndy[3] - xAndy[1]); //y2 - y1 (abs)
        b = Math.abs(xAndy[2] - xAndy[0]); //x2 - x1 (abs)



        ans = (int) Math.hypot(a, b); //Pyth theorem;

        return ans;
    }
    public static int maxX(int[] xAndy) {
        int ans;

        ans = Math.max(xAndy[0], xAndy[2]);

        return ans;
    }
    public static int maxY(int[] xAndy) {
        int ans;

        ans = Math.max(xAndy[1], xAndy[3]);
        return ans;
    }
    public static int cab(int[] xAndy) {
        int ans;
        int a = 0;
        int b = 0;
        int x1 = xAndy[0];
        int x2 = xAndy[2];
        int y1 = xAndy[1];
        int y2 = xAndy[3];
        //a = Mth.abs(xAndy[]);

        while (Math.abs(x1) != Math.abs(x2)) {
            //1 > 3


            if (x1 > x2) {
                b++;
                x2++;
                //System.out.println(x2 + " x2 added | " + b+" b added" );
            }

            //1 < 3
            if (x1 < x2) {
                b++;
                x1++;

                //System.out.println(x1 + " x1 added | " + b+" b added" );
            }
            //System.out.println(b + " B " );
        }

        while (Math.abs(y1) != Math.abs(y2)) {


            //2 > 4
            if (y1 > y2) {
                a++;
                y2++;
                //System.out.println(y2 + " y1 added | " + a+" a added" );
            }
            //2 < 4
            if (y1 < y2) {
                a++;
                y1++;

                //System.out.println(y1 + " y1 added | " + a+" a added" );
            }
            //System.out.println(a + " A " );

        }
        //System.out.println(b + " B  f" );
        //System.out.println(a + " A  f" );
        ans = Math.abs(a + b);

        return ans;
    }


    /*
     * N: taxicabDistance
     * P:
     * I:
     * R:
     */


    public static int getX(String point) {
        //locate the comma
        int comma = point.indexOf(",");

        //we know the x-value in the String starts at index 1
        //we now know where the comma is
        //so, the x-value is from index 1 to the location of the comma
        String x = point.substring(1, comma);
        System.out.println(x);

        return Integer.parseInt(x);
    } //end getX method

    public static int getY(String point) {
        //locate the comma
        int comma = point.indexOf(",");
        int bracket = point.indexOf(")");
        System.out.println("bracket index" + bracket);

        //we know the x-value in the String starts at index 1
        //we now know where the comma is
        //so, the x-value is from index 1 to the location of the comma
        String y = point.substring(comma + 2, bracket);
        System.out.println(y);

        return Integer.parseInt(y);
    } //end getX method

} //end class
