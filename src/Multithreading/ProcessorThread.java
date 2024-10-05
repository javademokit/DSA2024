package Multithreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MultiThreadedFileProcessor {

  private static final String FILENAME = "C:/Users/shyyadav/Downloads/spark basic.txt";
  private static final int QUEUE_CAPACITY = 10;
  private static final int NUM_PROCESSORS = 4;

  // Queue to hold data read from the file
  private static BlockingQueue<String> dataQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

  // Reader thread
  static class ReaderThread extends Thread {
    @Override
    public void run() {
      try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
        String line;
        while ((line = reader.readLine()) != null) {
          dataQueue.put(line); // Add line to the queue
        }
      } catch (IOException | InterruptedException e) {
        e.printStackTrace();
      } finally {
        // Signal the end of data
        for (int i = 0; i < NUM_PROCESSORS; i++) {
          try {
            dataQueue.put(null); // Send null to signal end of data
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }

  // Processor thread
  static class ProcessorThread extends Thread {
    private final int id;

    ProcessorThread(int id) {
      this.id = id;
    }

    @Override
    public void run() {
      try {
        while (true) {
          String data = dataQueue.take(); // Get data from the queue
          if (data == null) {
            break; // Exit if null is received
          }
          // Simulate processing the data
          String processedData = data.toUpperCase(); // Example processing
          System.out.printf("Processor %d processed: %s%n", id, processedData);
          Thread.sleep(1000); // Simulate processing time
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public static void main(String[] args) {
    // Start the reader thread
    Thread readerThread = new ReaderThread();
    readerThread.start();

    // Start processor threads
    Thread[] processorThreads = new Thread[NUM_PROCESSORS];
    for (int i = 0; i < NUM_PROCESSORS; i++) {
      processorThreads[i] = new ProcessorThread(i);
      processorThreads[i].start();
    }

    // Wait for the reader thread to finish
    try {
      readerThread.join();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    // Wait for all processor threads to finish
    for (Thread thread : processorThreads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }

    System.out.println("Processing complete.");
  }
}
