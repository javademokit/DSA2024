package Multithreading;

public class newthread extends Thread{


  newthread()
  {
    Thread t = new newthread();
    t.start();

  }

  public static void main(String[] args) {
    new newthread();
    new newthread();

  }

}
