import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by taky2 on 2/1/16.
 */
public class Verifier {


    public static void main(String args[]) {

        String originalFile;
        String outputFile;

        File file1;
        File file2;

        Scanner console = new Scanner(System.in);
        System.out.println("Check for files automatically? [y/N]\n" +
                           "\n[  format:  striptest-13a-clean.txt      ]" +
                           "\n[           striptest-13a-processed.txt  ]");
        String response = console.nextLine();
        response = response.toLowerCase();

        if ( (response.equals("y")) || (response.equals("yes")) ) {

            originalFile = "striptest-13a-processed.txt";
            outputFile = "striptest-13a-clean.txt";

            file1 = new File(originalFile);
            file2 = new File(outputFile);

            System.out.println("\nResults for 13a files:");
            compareTwoFiles(file1, file2);



            originalFile = "striptest-13b-processed.txt";
            outputFile = "striptest-13b-clean.txt";

            file1 = new File(originalFile);
            file2 = new File(outputFile);

            System.out.println("\nResults for 13b files:");
            compareTwoFiles(file1, file2);



            originalFile = "striptest-13c-processed.txt";
            outputFile = "striptest-13c-clean.txt";

            file1 = new File(originalFile);
            file2 = new File(outputFile);

            System.out.println("\nResults for 13c files:");
            compareTwoFiles(file1, file2);

            System.out.println("\nTesting finished");
        }//end automatic file testing case

        else if ( (response.equals("no") ) ||  (response.equals("n") ) ) { //ask for filenames
            System.out.print("Full filename of clean test-key file: ");
            originalFile = console.nextLine();
            System.out.print("Full filename of output file to test: ");
            outputFile = console.nextLine();
            System.out.println();
            file1 = new File(originalFile);
            file2 = new File(outputFile);
            compareTwoFiles(file1, file2);
        }

        else {
            System.out.println("Error: unknown response.");
        }

    }//end main

    private static void compareTwoFiles(File file1, File file2) {
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));

            StringBuilder stringBuilder1 = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();

            String lineFromFile1 = "";
            String lineFromFile2 = "";

            lineFromFile1 = reader1.readLine();
            lineFromFile2 = reader2.readLine();

            while(lineFromFile1 != null) {
                if ( !lineFromFile1.isEmpty()){
                    stringBuilder1.append(lineFromFile1);
                    stringBuilder1.append(System.lineSeparator());
                }
                lineFromFile1 = reader1.readLine();
            }//end while loop

            while(lineFromFile2 != null) {
                if ( !lineFromFile2.isEmpty()){
                    stringBuilder2.append(lineFromFile2);
                    stringBuilder2.append(System.lineSeparator());
                }
                lineFromFile2 = reader2.readLine();
            }//end while loop

            if (stringBuilder1.length() != stringBuilder2.length()){
                System.out.println("FAIL: The two files do not match! Your program still needs work.");
                return;
            } else {
                for (int i = 0; i < stringBuilder1.length(); i++){
                    if (stringBuilder1.charAt(i) != stringBuilder2.charAt(i)){
                        System.out.println("FAIL: The two files do not match! Your program still needs work.");
                        return;
                    }
                }
                System.out.println("PASS: Character comparison complete, files are identical.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }//end compareTwoFiles
}//end verifier class
