package ch.fhnw.mada.tools;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void writeFile(String filePath, String content) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
