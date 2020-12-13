import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Input how many grades you want");
    int nums = s.nextInt();
    int arr[] = new int[nums]; 
    for (int i = 0; i < nums; i++){
      System.out.println("What are the grades?");
      arr[i] = s.nextInt();
    }
    System.out.println("median: " + median(sta(arr)));
    System.out.println("average: " + getAverage(sta(arr)));
    if(mode(sta(arr)) < 0){
      System.out.println("no mode");
    }
    else{
      System.out.println("mode: "+ mode(sta(arr)));
      }
  }//End of Main method
  public static int[] sta(int[] arr){//Sort The Array
    for (int a = 0; a < arr.length; a++){
      for(int b = 0; b < arr.length; b++){
        int holder = 0;
        //it will grab 1 number and checks the list if that number is bigger than any other number. then it repeats with the next number of the list.
        if(arr[a] > arr[b]){//IF NUMBER[A] IS BIGGER THAN NUMBER[B]
          holder = arr[a];//HOLDER BECOMES NUMBER[A]
          arr[a] = arr[b];//NUMBER[A] BECOMES NUMBER[B]
          arr[b] = holder;//NUMBER[B] BECOMES NUMBER[A](HOLDER)
        }
        //[A] and [B] switch placements and will repeat till arr.length
      }
    }
    return arr;    
  }//end method of Sort The Array
  public static double median(int[] arr){
    System.out.println("array" + Arrays.toString(arr));
    if (arr.length % 2 != 1){//if array even
      return arr[arr.length/2];
    }
  else{
    double right = arr[arr.length / 2];
    double left = arr[arr.length / 2 - 1];
    return (right+left)/2;
    }
  }
  public static double getAverage(int[] arr){
    double sum = 0;
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
    }
    return sum / arr.length;
  }
  public static int mode(int[] arr){
    int maxnum = 0;//to hold count
    int placement = 0;//placement of the array
    for(int a = 0; a < arr.length; a++){
      int count = 0;// reset the count of each number
      for(int b = 0; b < arr.length; b++){
        if(arr[a] == arr[b]){
          count++;// goes through the next number of the array
        }

        if(count > maxnum){
          maxnum = count;
          placement = arr[a];
        }
        
      }
    }
    if(maxnum == 1){
      maxnum = -1;
      return maxnum;
      }
    return placement;
  }
}//end class 