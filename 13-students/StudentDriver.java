public class StudentDriver {
  public static void main(String[] args) {
    Student student1 = new Student("Hans", "123456789");
    System.out.println(student1);

    student1.setName("Joshua");
    student1.addGrade(20);
    System.out.println(student1.calculateAverage());
    System.out.println(student1);
  }//end main method

}//end class
