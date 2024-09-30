package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Readable;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

/**
 * A class that reads binary files. This implementation reads the file byte per byte. It manages the
 * file input stream properly with a try-catch-finally block.
 */
public class BinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
    InputStream fis = null;

    try{
      fis = new FileInputStream(filename);
      while ((fis.read()) != -1) {}
    }catch(IOException e) {
      System.out.println("Exception: " + e);
    }finally{
      try{
        fis.close();
      }catch(IOException e) {
        System.out.println("Exception while closing input stream: " + e);
      }
    }
  }
}
