package Multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class AtomicVolatileSynchronizedJava {

  public static void main(String args[]){
    final IntegerCounter counter = new IntegerCounter();
    final CyclicBarrier startingBarrier = new CyclicBarrier(5);
    final CyclicBarrier endingBarrier = new CyclicBarrier(6);

    Runnable task = new Runnable(){
      @Override
      public void run(){
        try {
          startingBarrier.await();
          for (int i = 0; i < 10; i++) {
            int count = counter.getCount();
          }
          endingBarrier.await();

        } catch (InterruptedException ex) { ex.printStackTrace();
        } catch (BrokenBarrierException ex) {ex.printStackTrace();
        }
      }
    };

    Thread T1 = new Thread(task); T1.start();
    Thread T2 = new Thread(task); T2.start();
    Thread T3 = new Thread(task); T3.start();
    Thread T4 = new Thread(task); T4.start();
    Thread T5 = new Thread(task); T5.start();

    try {
      endingBarrier.await();
      System.out.println("Expected count : 5001" + " Actual count : "
        + counter.getCount());
    } catch (InterruptedException ex) { ex.printStackTrace();
    } catch (BrokenBarrierException ex) {ex.printStackTrace();
    }
  }

}
/**
 * A counter, which should return different count each time
 */
class IntegerCounter{
  private int count = 1;

  public int getCount(){
    return count++;
  }
}