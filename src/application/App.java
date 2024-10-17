package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            Map<String, Integer> map = new LinkedHashMap<>();
            String line = bf.readLine();

            while (line != null) {
                String[] split = line.split(",");
                String candidate = split[0];
                int votes = Integer.parseInt(split[1]);

                // Adiciona ou soma os votos
                map.put(candidate, map.getOrDefault(candidate, 0) + votes);

                line = bf.readLine();
            }

            for (String key : map.keySet()) {
                System.out.println(key + ": " + map.get(key));
            }
        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
        }

        sc.close();
    }
}
