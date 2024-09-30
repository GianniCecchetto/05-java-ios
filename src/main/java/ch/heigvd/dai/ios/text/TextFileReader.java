package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Readable;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

/**
 * A class that reads text files. This implementation reads the file byte per byte. It manages the
 * file reader properly with a try-catch-finally block.
 */
public class TextFileReader implements Readable {

  @Override
  public void read(String filename) {
    Reader reader = null;

    try {
      reader = new FileReader(filename);

      while(reader.read() != -1) {}
    } catch (IOException e) {
      System.out.println("Exception: " + e);
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          System.out.println("Exception in close reader: " + e);
        }
      }
    }
  }
}
