

import java.util.regex.Pattern;
import java.util.*;
import java.util.regex.Matcher;


public class FicCharacters {
    String name, bio, dOb, gender;
    Integer age = 0;
    /**
     * 
     * @param name
     * @param bio
     * @param dOb
     * @param gender
     * 
     */

    public FicCharacters(String name, String bio, String dOb, String gender) {
        this.name = name;
        this.bio = bio;
        this.dOb = dOb;
        this.gender = gender;

    }
    /**
     * 
     * @return the name of the character.
     */

    public String getName() {

        return this.name;

    }
    /**
     * 
     * @return the bio str of the character.
     */

    public String getBio() {

        return this.bio;

    }
    /**
     * does | matches the DOB with the pattern, extracts the year, subtracts it with cur year and we get age.
     * @return the age of the character;
     */

    public int getAge() {
        Pattern mdy = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})"); 
        Matcher matcher = mdy.matcher(this.dOb);


        if (matcher.find()) { // if it matches mdy format;
            int year, month, day; 
            int charYear, charMonth, charDay;
            //System.out.println(matcher.group(3));
            //System.out.println(Year.now().getValue());
            
            charYear = Integer.parseInt(matcher.group(3)); //gets our character's age;
            charMonth = Integer.parseInt(matcher.group(1));
            charDay = Integer.parseInt(matcher.group(2));

            Date today = new Date(); // new date object;
            Calendar calInstance = Calendar.getInstance(); // new calendar object;
            calInstance.setTime(today); //set the calendar obj's time to now; (when we made new date above);
           


            year = calInstance.get(Calendar.YEAR); //gets our current year format;
            month = calInstance.get(Calendar.MONTH);
            day = calInstance.get(Calendar.DAY_OF_MONTH);

            

            age = year - charYear; //character age subtracted by our year = age;
            if (month <= charMonth) {
                //System.out.println("This month is less than or equal to character's age");
                //System.out.println(day + " < - today | char - > " + charDay);
                
                if (day <= charDay) age--;

            }; //minus to age if they havent pased their birthday yet.



        } 


        return age;
        
    }
    /**
     * does | sets age of the object;
     * @param age
     */

    public void setAge(int age) {
        this.age = age;
    }



    
    
}