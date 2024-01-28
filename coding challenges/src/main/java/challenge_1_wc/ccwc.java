package challenge_1_wc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ccwc {

    /**
     * A function which prints output for a given specific input
     * @param input
     * @param flag
     */

    public static void executeToStdInput(String input, String flag){
        switch (flag){
            case "-l" -> System.out.println(input.split("\\n").length);
            case "-c" -> System.out.println(input.getBytes().length);
            case "-w" -> System.out.println(input.split("\\s").length);
            case "-m" -> System.out.println(input.length());
            default ->
                    System.out.println(input.split("\n").length + " " + input.split("\\s+").length + " " + input.getBytes().length);
        }
    }

    /**
     * A function which prints output for a given specific filepath
     * @param filePath
     * @param flag
     * @throws IOException
     */
    public static void executeToFile(Path filePath, String flag) throws IOException {
        switch (flag){
            case "-l" -> System.out.println(Files.readAllLines(filePath).size()+" "+filePath);
            case "-c" -> System.out.println(Files.readAllBytes(filePath).length+" "+filePath);
            case "-w" -> System.out.println(Files.readString(filePath).split("\\s+").length+" "+filePath);
            case "-m" -> System.out.println(Files.readString(filePath).length()+" "+filePath);
            default ->
                    System.out.println(Files.readAllLines(filePath).size() + " " + Files.readString(filePath).split("\\s+").length + " " + Files.readAllBytes(filePath).length + " " + filePath);
        }
    }
    public static void main(String[] args) throws IOException{

        if (args.length == 0) { //when only std input is present
            Scanner scanner = new Scanner(System.in);
            String input = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
            executeToStdInput(input, "");
        } else if (args.length == 1) {
            String argValue = args[0];
            Path filePath = Paths.get(argValue); //checking if the args is a file path or an input string

            if (!Files.exists(filePath)) {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                executeToStdInput(input, argValue);
            } else {
                executeToFile(filePath, "");
            }
        } else if (args.length == 2) {
            Path filePath = Paths.get(args[1]);
            executeToFile(filePath, args[0]);
        }
    }
    }

