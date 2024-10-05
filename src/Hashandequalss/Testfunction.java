package Hashandequalss;

@FunctionalInterface
interface  A
{
  void show();

  default void doIt(){
    System.out.println("Do it now A");
  }
  static void im()
  {
    System.out.println("static A");
  }

}


@FunctionalInterface
interface  B {
  void show();

  default void doIt() {
    System.out.println("Do it now B");
  }

  static void im() {
    System.out.println("static B");
  }
}
public class Testfunction implements  A,B{

  @Override
  public void show() {
    System.out.println("aaaaa");
  }

  @Override
  public void doIt() {
    A.super.doIt();
  } // amitgty

  public static void main(String[] args) {
    Testfunction ls = new Testfunction();
    ls.show();
    ls.doIt();
    A.im();
    B.im();

  }
}