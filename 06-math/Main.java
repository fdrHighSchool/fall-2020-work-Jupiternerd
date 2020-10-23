import java.util.*;

class Main {

  public static void main(String[] args) {
   int[] xAndy = setup();
   System.out.println("Cartesian method : "+  cart(xAndy));
   System.out.println("Cab method : "+  cab(xAndy));
System.out.println("Max x (of your input) : "+  maxX(xAndy));
System.out.println("Max y (of your input) : "+  maxY(xAndy));
  }

  public static int[] setup() {

    int[] xAndy = new int[4];
    Scanner sc = new Scanner(System.in);


    System.out.println("Give me x for point 1");
    xAndy[0] =  sc.nextInt();
    System.out.println("Give me y for point 1");
    xAndy[1] =  sc.nextInt();
    System.out.println("Give me x for point 2");
    xAndy[2] =  sc.nextInt();
    System.out.println("Give me y for point 2");
    xAndy[3] =  sc.nextInt();


    return xAndy;
  }

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
int a =0;
int b =0;
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
}
