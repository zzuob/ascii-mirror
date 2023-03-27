package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    static Scanner scan = new Scanner(System.in);

    public static String[] getLines(File file, int lines) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        String[] data = new String[lines];
        for (int i = 0; i < lines; i++) {
            data[i] = fileReader.nextLine();
        }
        return data;
    }
    public static int countLines(File file){
        Scanner fileReader;
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return 0;
        }
        int total = 0;
        while (fileReader.hasNextLine()){
            total++;
            fileReader.nextLine();
        }
        return total;

    }
    public static void checkFile() throws FileNotFoundException {
        System.out.println("Input the file path:");
        String pathToFile = scan.nextLine();
        File animalFile = new File(pathToFile);
        int lines = countLines(animalFile);
        Picture animal;
        if (lines > 0){
            animal = new Picture(getLines(animalFile, lines));
            animal.mirrorLines();
            animal.printLines();
        }
    }
}
