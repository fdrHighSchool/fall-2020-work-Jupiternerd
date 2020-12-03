import java.util.*;
import java.io.*;
import java.util.regex.*;


public class TwoP2 {
    public static void main(String[] args) {
        Pattern reg = Pattern.compile("(\\d+)-(\\d+)\s(\\w):\s([a-z]+)");
        Matcher matcher;
        Scanner sc;

        ArrayList<PasswordObj> storage = new ArrayList();
        long numberOfDuds = 0;
        try {
            /**
             * Parses a txt file from ./data/
             */

            sc = new Scanner(new File("./data/two.txt"));

            /**
             * while sc still has a line to read, do the function below.
             * 
             * 1. match regex
             * 2. get the necesasry information from the groupped regex and perform logical beep and bops
             * 3. add it to the storage arraylist as a object.
             */

            int most, least;
            char single;
            String pass;


            while (sc.hasNext()) { 
                String piece = sc.nextLine();
                matcher = reg.matcher(piece);
               // System.out.println(piece);
                boolean bool;

                if (matcher.matches()) {
                    //System.out.println(matcher.group(1));
                    least = (int) Integer.parseInt(matcher.group(1));
                    most = (int) Integer.parseInt(matcher.group(2));
                    single = (char) matcher.group(3).charAt(0);
                    pass = (String) matcher.group(4).toString();

                    PasswordObj passObj = new PasswordObj(least, most, single, pass);

                    bool = performLogic(passObj);
                    if (bool) {
                        storage.add(passObj);   

                    } else {
                        numberOfDuds++;
                    }

                };
                
            }

    
    
            } catch (Exception e) {
                System.out.print(e);
    
            } finally {
                System.out.println("All Finished! Here are the results : ");
                System.out.println("Total Sorted : " + storage.size() + numberOfDuds);
                System.out.println("Total that are valid passwords : " + storage.size());
                System.out.println("Total that are not valid : " + numberOfDuds);
                System.out.println("=============Do you want to see individual valid ones? [0 = yes | anything else]==============");


                sc = new Scanner(System.in);
                int input = sc.nextInt();
                if (input == 0) {

                    for (PasswordObj items : storage) {
                        System.out.print("min : " + items.getLeast());
                        System.out.print("max : " + items.getMost());
                        System.out.print("character : " + items.getSingle());
                        System.out.print("password : " + items.getPass());
                        System.out.println();
    
                    }

                } else {
                    System.exit(0);

                }


                


            }

            sc.close();
        
        
    }//end class

    private static boolean performLogic(PasswordObj obj) {
        boolean bool;
        boolean pos1 = false;
        boolean pos2 = false;
        String pass = obj.getPass();
        int most = obj.getMost();
        int least = obj.getLeast();
        char character = obj.getSingle();
        char currentChar;

        //Since they dont use 0 as starting policy then we go with 1;
        int z = 1;

        for (int i = 0; i < pass.length(); i++) {
            currentChar = pass.charAt(i);

            /**
             * This method from character returns 0 is its true.
             * -1 if a < b (currentChar < character) and 
             * 1 if a > b ^^
             */
            if (Character.compare(currentChar, character) == 0) {
                if (z == most) pos2 = true;
                if (z == least) pos1 = true;

                System.out.println(currentChar + "< current == for " + pass + " ==== " + least + " === " + most + "=====" + i);
                System.out.println(pos1 + "<- pos1 pos2 ->" + pos2);

            }

            //if (Character.compare(currentChar, character) == 0) count++;
            //System.out.println(Character.compare(currentChar, character) == 0);
            z++;
    
        }

        if (pos1 || pos2) {
            if (pos2 && pos1) {
                bool = false;
            } else {
                bool = true;
            }
            

        } else {
            bool = false;
        }


        /**I cant thinkrn */
        

        return bool;
    }
    
}

class PasswordObj {
    private String pass;
    private char single;
    private int most, least;

    public PasswordObj(int least, int most, char single, String pass) {
        this.pass = pass;
        this.single = single;
        this.least = least;
        this.most = most;

    }

    public int getLeast() {
        return this.least;

    }

    public int getMost() {
        return this.most;

    }
    public char getSingle() {
        return this.single;

    }
    public String getPass() {
        return this.pass;

    }


}
