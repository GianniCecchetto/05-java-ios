package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Writable;

import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

/**
 * A class that writes text files. This implementation write the file byte per byte. It manages the
 * file writer properly with a try-catch-finally block.
 */
public class TextFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    Writer writer = null;

    try {
      writer = new FileWriter(filename);

      int c = 'A';
      for (int i = 0; i < sizeInBytes; i++){
        writer.write(c);
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          System.out.println("Exception in close writer: " + e);
        }
      }
    }
  }
}
