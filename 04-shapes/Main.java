import java.util.*;
//import java.util.Scanner;
public class Main{

  public static void circle(Scanner sc) {
          System.out.println("Enter your circle radius: ");
          double radius = sc.nextDouble();
          double area = radius * radius * 3.14;
          System.out.println("The area of the circle is:" +area);
  }

  public static void square(Scanner sc) {
          System.out.println ("Enter your square Length: ");
          double side = sc.nextDouble();
          double area = side * side;
          System.out.println ("The Area of the square is:"+area);
  }
    public static void tri(Scanner sc) {
          System.out.println ("Enter your triangle height: ");
          double height = sc.nextDouble();
          System.out.println ("Enter your triangle base length: ");
          double length = sc.nextDouble();
          double area = height * length * 0.5;
          System.out.println ("The area of the triangle is:" +area);
  }
    public static void rect(Scanner sc) {
          System.out.println("Enter your rectangle width: ");
          double width = sc.nextDouble();
          System.out.println ("Enter your rectangle length: ");
          double length = sc.nextDouble();
          double area = width * length;
          System.out.println("The area of the rectangle is:" +area);
  }
    public static void cylinder(Scanner sc) {
          System.out.println("Enter your cylinder height: ");
          double height = sc.nextDouble();
          System.out.println("Enter your cylinder radius: ");
          double radius = sc.nextDouble();
          double volume = 3.14 * radius * radius * height;
          System.out.println("The volume of the cylinder is:" +volume);
  }
    public static void sphere(Scanner sc) {
          System.out.println("Enter your sphere radius:");
          double radius = sc.nextDouble();
          double volume = 1.33 * 3.14 * radius * radius * radius;
          System.out.println("The volume of the sphere is:" +volume);
  }
    public static void cube(Scanner sc) {
          System.out.println("Enter your cube Side length: ");
          double side = sc.nextDouble();
          double volume = side * side * side;
          System.out.println("The volume of the cube is:" +volume);
  }
    public static void prism(Scanner sc) {

          System.out.println("Enter your Prism width: ");
          double width = sc.nextDouble();
          System.out.println("Enter your Prism Length: ");
          double length = sc.nextDouble();
          System.out.println("Enter your Rect Prism Height: ");
          double height = sc.nextDouble();
          double volume = width * length * height;
          System.out.println("The volume of the Prism is:" +volume);
  }


  public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
     System.out.println("1 = circle, 2 = square, 3 = triangle, 4 = rectangle, 5 = cylinder, 6 = Sphere, 7 = Cube, 8 == RectangularPrism");
        int in = sc.nextInt();

        switch(in) {
          case 1:
          circle(sc);

          break;

          case 2:
          square(sc);
          break;

          case 3:
          tri(sc);
          break;

          case 4:
          rect(sc);

          break;

          case 5:
          cylinder(sc);
          break;

          case 6:
          sphere(sc);

          break;

          case 7:
          cube(sc);

          break;

          case 8:
          prism(sc);

          break;

          default:
          System.out.println("Retry!");
          break;

        }

  }//end main
}// end class
