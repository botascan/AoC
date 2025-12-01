import java.io.*;
import java.util.*;


public class Puzzle12 {
    
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
            int move = Integer.parseInt(rotation.substring(1));

            if (rotation.charAt(0) == 'L') {

                while (move != 0) {
                    dial = (dial - 1 + 100) % 100;
                    move--;
                    if (dial == 0) password++;
                }
            }

            if (rotation.charAt(0) == 'R') {

                while (move != 0) {
                    dial = (dial + 1) % 100;
                    move--;
                    if (dial == 0) password++;
                }
            }
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
