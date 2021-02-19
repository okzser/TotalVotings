package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String path = sc.nextLine();
        Map<String,Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String fields[] = line.split(", ");
                String name = fields[0];
                int votes = Integer.parseInt(fields[1]);

                if (map.containsKey(name)) {
                    int sum = map.get(name);
                    map.put(name, votes + sum);
                } else {
                    map.put(name, votes);
                }
                line = br.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        for(String candidate : map.keySet()) {
            System.out.println(candidate + "- " + map.get(candidate));
        }

    }
}
