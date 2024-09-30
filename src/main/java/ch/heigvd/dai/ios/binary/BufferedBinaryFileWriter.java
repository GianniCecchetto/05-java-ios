package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Writable;

import java.io.*;

/**
 * A class that writes binary files. This implementation writes the file using a buffered output
 * stream. It manages the file output stream properly with a try-with-resources block.
 */
public class BufferedBinaryFileWriter implements Writable {

    @Override
    public void write(String filename, int sizeInBytes) {
        try (OutputStream fos = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            int c = 'A';
            for (int i = 0; i < sizeInBytes; i++) {
                bos.write(c);
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
