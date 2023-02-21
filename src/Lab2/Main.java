package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter the input file name:");
        File fileIn = new File(scanString());
        System.out.println("Enter the output file name:");
        File fileOut = new File(scanString());

        String string = "";
        String upperString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerString = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put(upperString.charAt(i), 0);
            map.put(lowerString.charAt(i), 0);
        }

        try (PrintWriter printWriter = new PrintWriter(fileOut)) {

            Scanner scanner = new Scanner(fileIn);
            while (scanner.hasNextLine()){
                string = string.concat(scanner.nextLine());
            }
            for (char el : string.toCharArray()){
                if (map.containsKey(el)) { map.put(el, map.get(el) + 1); }
            }

            if (fileOut.createNewFile()){
                for (Map.Entry<Character, Integer> entry : map.entrySet()){
                    printWriter.println("The number of symbols " + entry.getKey() + " = " + entry.getValue());
                }
            } else if (fileOut.exists()){
                for (Map.Entry<Character, Integer> entry : map.entrySet()){
                    printWriter.println("The number of symbols " + entry.getKey() + " = " + entry.getValue());
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File '" + fileIn + "' not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String scanString() {
        return new Scanner(System.in).nextLine();
    }
}
