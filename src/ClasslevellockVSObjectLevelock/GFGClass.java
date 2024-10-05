package ClasslevellockVSObjectLevelock;




// java program to illustrate Class Level Lock Concept

// Importing required packages
import java.io.*;
import java.util.*;

// Class 1
// Helper Class
// Consist of synchronized method wish
class Display1 {

  // Declaring static wish method
  public static void wish(String name)
  {

    // synchronizing wish method
    // and getting the lock of display class
    synchronized (Display.class)
    {

      for (int i = 1; i <= 10; i++) {

        // Display message only
        System.out.print("Good Morning: ");

        // Try block to check for exceptions
        try {
          // Putting thread on sleep for specified
          // time
          // using the sleep() method
          Thread.sleep(1000);
        }

        // Catch block to handle the exception
        catch (InterruptedException e) {

          // Throwing exception
          System.out.println(e);
        }
        // Display message
        System.out.println(name);
      }
    }
  }
}

// C;asss 2
// Helper Class (extends the Thread class)
// myThread with override the run method
// as per our requirements it also consists
// of parameterized constructor
class myThread1 extends Thread {
  // Member variables of this class
  Display1 d;
  String name;

  // Constructor of this class
  myThread1(Display1 d, String name)
  {

    // This keyword refers to current object itself
    this.d = d;
    this.name = name;
  }

  // run method for thread/s
  public void run()
  {

    // Calling wish method of display class
    d.wish(name);
  }
}

// Class 3
// Main Class
class GFGClass {

  // Main driver method
  public static void main(String[] args)
  {

    // Creating Display class(Class 1) object
    // in the main() method
    Display1 d = new Display1();

    // Creating a thread objects
    myThread1 t1 = new myThread1(d, "Dhoni");
    myThread1 t2 = new myThread1(d, "Yuvraj");

    // Starting the threads using start() method
    t1.start();
    t2.start();
  }
}
