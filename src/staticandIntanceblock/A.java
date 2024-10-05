package staticandIntanceblock;

import java.util.*;

class A{
  {
    System.out.print("1");
  }
  public static void main(String[] args) {
    C c = new C();  //
  }
}

class B extends A{
  {
    System.out.print("2");
  }
}

class C extends B{
  {
    System.out.print("3");
  }
}