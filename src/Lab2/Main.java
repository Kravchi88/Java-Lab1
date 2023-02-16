package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File fileIn = new File("input.txt");
        File fileOut = new File("output.txt");
        String string = "";
        int countUpperCase = 0, countLowerCase = 0;
        try (PrintWriter printWriter = new PrintWriter(fileOut)) {
            Scanner scanner = new Scanner(fileIn);
            while (scanner.hasNextLine()){
                string = string.concat(scanner.nextLine());
            }
            for (char el : string.toCharArray()){
                if (Character.isAlphabetic(el)){
                    if (Character.isUpperCase(el)) { countUpperCase++; }
                    else if (Character.isLowerCase(el)) { countLowerCase++; }
                }
            }
            printWriter.println("Upper Case: " + countUpperCase);
            printWriter.println("Lower Case: " + countLowerCase);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
