//GroupMates: Wai Hlaing, Xin Bao Chen

class Main {
  public static void main(String[] args) {
   rect(5, 5);
   System.out.println("====================");
   rect(2, 4);
   System.out.println("====================");
   rowNums(3);
   System.out.println("====================");
   tri();
   System.out.println("====================");
   numberTri();
  }

  public static void rect(int numOfRows, int perRow) {
        for (int row = 0; row < numOfRows; row++){
      for (int col = 0; col < perRow; col++){
        System.out.print("* ");
      }
      System.out.println();
    }
  }

    public static void rowNums(int Maxrows) {
        for (int row = 0; row < Maxrows; row++){
      for (int col = 0; col < 6; col++){
        System.out.printf("%d ", row + 1);
      }
      System.out.println();
    }
  }
public static void tri(){
    for(int row = 0; row < 4; row++){
      for(int col = 0;col <= row; col++){
        System.out.print("*");
      }
      System.out.println();
    }
}


  public static void numberTri(){
    //Coppied this from slack as it was a better
  for (int row = 5; row > 0; row--){
    for (int blanks = 1; blanks < row; blanks++){
      System.out.print(" ");
    }
    for (int num = 0; num < 6 - row; num++){
      System.out.print(6 - row);
    }
    System.out.println();
  }
  }
}
