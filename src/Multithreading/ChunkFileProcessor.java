package Multithreading;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChunkFileProcessor {

  private static final String INPUT_FILE = "C:/Users/shyyadav/Downloads/spark basic.txt";
  private static final String OUTPUT_FILE = "processed_data.txt";
  private static final int CHUNK_SIZE = 1024; // 1 KB

  public static void main(String[] args) {
    try (FileInputStream fis = new FileInputStream(INPUT_FILE);
         FileOutputStream fos = new FileOutputStream(OUTPUT_FILE)) {

      byte[] buffer = new byte[CHUNK_SIZE];
      int bytesRead;

      while ((bytesRead = fis.read(buffer)) != -1) {
        // Process the chunk
        processChunk(buffer, bytesRead);

        // Optionally write processed data to another file
        // fos.write(buffer, 0, bytesRead); // Uncomment to save processed data
      }

      System.out.println("File processed successfully.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void processChunk(byte[] chunk, int length) {
    // Example processing: Convert bytes to a String and print in uppercase
    String data = new String(chunk, 0, length);
    String processedData = data.toUpperCase(); // Example processing

    // Print the processed data
    System.out.println(processedData);
  }
}
