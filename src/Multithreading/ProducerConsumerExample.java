package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
  // Shared buffer
  private static final Queue<Integer> buffer = new LinkedList<>();
  private static final int MAX_SIZE = 10; // Maximum size of the buffer

  public static void main(String[] args) {
    // Create and start producer and consumer threads
    Thread producer = new Thread(new Producer());//  const-sync data  1 0 1 -p  c   p c 1  t 1 t2 -1 o
    Thread consumer = new Thread(new Consumer()); //

    producer.start();
    consumer.start();
  }

  static class Producer implements Runnable {
    @Override
    public void run() {
      while (true) {
        try {
          produce();
          Thread.sleep(1000); // Sleep for a bit
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    }

    private void produce() throws InterruptedException {
      synchronized (buffer) {
        // Wait if buffer is full
        while (buffer.size() == MAX_SIZE) {
          System.out.println("Buffer is full, producer is waiting...");
          buffer.wait();
        }

        // Produce an item
        int item = (int) (Math.random() * 100);
        buffer.add(item);
        System.out.println("Produced: " + item);

        // Notify the consumer that there is an item available
        buffer.notify();
      }
    }
  }

  static class Consumer implements Runnable {
    @Override
    public void run() {
      while (true) {
        try {
          consume();
          Thread.sleep(1000); // Sleep for a bit
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    }

    private void consume() throws InterruptedException {
      synchronized (buffer) {
        // Wait if buffer is empty
        while (buffer.isEmpty()) {
          System.out.println("Buffer is empty, consumer is waiting...");
          buffer.wait();
        }

        // Consume an item
        int item = buffer.poll();
        System.out.println("Consumed: " + item);

        // Notify the producer that space is available
        buffer.notify();
      }
    }
  }
}