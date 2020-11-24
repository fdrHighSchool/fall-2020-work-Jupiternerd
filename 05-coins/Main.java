//Maksim Garcia & Joshua Siganur & Wai Hlaing

import java.util.*;
//import java.util.Random;

class Main {

  public static void main(String[] args) {
     //init random method

    int money = 100; //starting money is 100
    System.out.println("hello you have " + money + " money"); //Log that they have x amount of money.

    //we have our loop that goes for as long as the user plays
    for(;;){
      System.out.println("If you want to play type 1, if you want to shop type 2, and if you want to quit type 3");
      Scanner input = new Scanner(System.in); //initialize Scanner method
      int choice = input.nextInt(); //get input

      switch(choice){
      case 1:
        money += playgame(money); //gets a random number from playgame method and get
        System.out.println(money);
        break;

      case 2:
        money -= shop(money);
        break;

      case 3:
        System.exit(0);

        break;
      default:
        money += playgame(money);
        System.out.println(money);
      break;
      }

    }
  }


    public static int playgame(int x){
      Random rand = new Random();
      int gain = rand.nextInt(100);
      x += gain;
      System.out.println("You played game and gained "+ gain );
      return gain;
    }

    public static int shop(int x){
      if (x <= 0){ //<= less than equal to
        System.out.println("You have no money.");


        //break;
      }
      else{
      System.out.println("Welcome to shop o'cram, we have a variety of cram. Type 1 if you would like to buy Mixed Berry Cram, type 2 if you would like to buy Very Berry Cram, and type 3 if you would like to buy Raspberry Cram.");
      Scanner shop = new Scanner(System.in);
      int buy = shop.nextInt();
        if (buy == 1){
          x-=50;
          System.out.println("You bought Mixed Berry Cram. You have "+x+" money.");
        }
        if (buy == 2){
          x-=100;
          System.out.println("You bought Very Berry Cram. You have "+x+" money.");
        }
        if (buy == 3){
          x-=500;
          System.out.println("You bought Raspberry Cram. You have "+x+" money.");
        }
      }
        return x;
      }

    // in the loop, present the user with a menu of options that asks the      user what they want to do:
    // 1. play
    // 2. shop
    // 3. quit
    // (feel free to add more options to this if you're inspired)

    // based on their entry, call the method to perform that behavior
    // at all times, keep updating the user's bank balance


  //end main method


  /*
   * Name: play
   * Purpose: simulate a round of the game, award the user a random
              amount of coins for playing
   * Input: ???
   * Return: a random number of coins the user won that round
   */





  /*
   * Name: shop
   * Purpose: allow the player to spend coins
   * Input: amount of coins user currently has
   * Return: how many coins spent/updated balance
   */

}//end class
