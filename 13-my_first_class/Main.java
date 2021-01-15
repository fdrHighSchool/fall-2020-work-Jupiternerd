import java.util.*;


class Main {
    
    /**
     * 
     * @param prompt | The str that you want to send before the user answers the question.
     * @return a string response;
     */
    public static String getStrAnswer(String prompt) {

        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        String ret = sc.next();

        sc.close();

        return ret;

    }
    /**
     * 
     * @param args
     * Does | initiates program, asks for character information, age, bio, appearances in shows, etc..
     */
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        String name = "", bio = "", dOb = "", gender = ""; // Name, Biography, Date of birth
        System.out.println("name");
        name = sc.next();

        System.out.println("bio");
        bio = sc.next();

        System.out.println("gender");
        gender =sc.next();

        System.out.println("dob? (MM/DD/YYYY)");
        dOb = sc.next();

        Characters person = new Characters(name, bio, dOb, gender);
        //person.getName();
        System.out.println(person.getAge());

        sc.close();

        
    }
}
