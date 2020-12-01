import java.util.*;
import java.io.*;

public class One {
    public static void main(String[] args) {
        final int year = 2020;

        try {

        Scanner sc = new Scanner(new File("data.txt"));
        ArrayList<Integer> storage = new ArrayList();

            
           while(sc.hasNext()) {
               int i = sc.nextInt();
               storage.add(i);

           }
           int i = 0;

           for (int item : storage) {
               int findInt = (year - item);
               int index = storage.indexOf(findInt);
               boolean hasBool = (index == -1 ? false : true);
               if (hasBool) {
                   System.out.println("Here are the two numbers, along with the index."); 
                   System.out.println("1 : " + storage.get(index) + " With index of " + index);
                   System.out.println("2 : " + item + " With index of " + i);
                   System.out.println("Multiplied = " + storage.get(index) * item);
                   System.exit(0);
                };
               System.out.println(hasBool);
               i++;

               
           }


           

        } catch (Exception e) {
            System.out.print(e);


        }

        

    }
    
}
