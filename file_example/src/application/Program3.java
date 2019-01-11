package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program3 {

    public static void main(String[] args) {

        String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};

        String path = "c:\\temp\\out.txt";

        // If put true in FileWriter parameter, it will not create again the same archive, but it will put the content in the existent file chosen
        try(BufferedWriter bw = new BufferedWriter( new FileWriter(path)) ) {

            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
