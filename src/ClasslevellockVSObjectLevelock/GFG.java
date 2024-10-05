package ClasslevellockVSObjectLevelock;

// Java program to illustrate Object Level Lock Concept

// Import required packages
import java.io.*;
import java.util.*;

// Class 1
// Helper Class 1
// Consists of synchronized method wish
class Display {

  // Declaring Non-static wish method
  public void wish(String name)
  {

    // synchronizing wish method
    // and getting the lock of current object
    synchronized (this)
    {

      for (int i = 1; i <= 10; i++) {

        // display message only
        System.out.print("Good Morning: ");

        // Try block to check. for exceptions
        try {

          // Putting thread on sleep for specified
          // time
          // using the sleep() method
          Thread.sleep(1000);
        }

        // Catch block to handle the exceptions
        catch (InterruptedException e) {

          // Print the occurred exception/s
          System.out.println(e);
        }
        // Display message only
        System.out.println(name);
      }
    }
  }
}

// Class 2
// Helper Class 2 (extending main Thread Class)
// myThread with override the run method and
// consists of parameterized constructor
class myThread extends Thread {
  // member variable of this class
  Display d;
  String name;

  // Constructor(Parameterized) of this class
  myThread(Display d, String name)
  {

    // this keyword refers to current object itself
    this.d = d;
    this.name = name;
  }

  // run() method for thread
  public void run()
  {

    // Calling wish method of display class
    d.wish(name);
  }
}

// Class 3
// Main Class
class GFG {

  // Main driver method
  public static void main(String[] args)
  {

    // Creating display class(Class 1) object
    // in the main() method
    Display d = new Display();

    // Creating thread objects in main method()
    myThread t1 = new myThread(d, "Dhoni");
    myThread t2 = new myThread(d, "Yuvraj");

    // Starting the threads using the start() method
    t1.start();
    t2.start();
  }
}
