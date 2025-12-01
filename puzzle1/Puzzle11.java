import java.io.*;
import java.util.*;

public class Puzzle11 {
    
    public static void main(String[] args) {
        
        File rotations = new File("puzzle1/Puzzle1.txt");
        List<String> rotationlist = read(rotations);
        int password = getPassword(rotationlist);
        System.out.println(password);

    }

    public static int getPassword(List<String> rotations) {
        if (rotations == null) return -1;
        int password = 0;
        int dial = 50;

        for (String rotation : rotations) {
            if (rotation.charAt(0) == 'L') {
                int move = Integer.valueOf(rotation.substring(1));

                if (move > dial) {
                    dial = (dial - move + 100) % 100;
                }
                else dial -= move;
            } 
                
            if (rotation.charAt(0) == 'R') {
                int move = Integer.valueOf(rotation.substring(1));

                if (move + dial >= 100) {
                    dial = (move + dial) % 100;
                }
                else dial += move;
            }

            if (dial == 0) password++;
        }

        return password;
    }
    public static List<String> read(File file2read) {
        List<String> file = new ArrayList<>(); 

        try (Scanner reader = new Scanner(file2read)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                file.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not read");
            e.printStackTrace();
        }
        return file;
    }
}
