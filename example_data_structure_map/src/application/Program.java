package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> candidates = new TreeMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader( new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {

                String[] fields = line.split(",");
                String candidate = fields[0];
                int votes = Integer.parseInt(fields[1]);

                if (candidates.containsKey(candidate)) {

                    votes += candidates.get(candidate);
                    candidates.put(candidate, votes);

                } else {

                    candidates.put(candidate, votes);

                }

                candidates.put(candidate, votes);

                line = br.readLine();

            }

            for (String key : candidates.keySet()) {

                System.out.println(key + ": " + candidates.get(key));

            }

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            sc.close();

        }

    }

}
