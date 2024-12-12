// Advent of Code 2024 Day 4 Solution

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/input.txt");
            Scanner scanner = new Scanner(inputFile);

            int xmasCount = 0;
            int masCount = 0;

            ArrayList<ArrayList<Character>> matrix = new ArrayList<>(new ArrayList<>());


            // Convert to matrix
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<Character> row = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    row.add(line.charAt(i));
                }
                matrix.add(row);
            }

            // Display
            for (ArrayList<Character> cArray : matrix) {
                System.out.println(cArray);
            }

            // For each column
            for (int r = 0; r < matrix.size(); r++) {

                // For each row
                for (int c = 0; c < matrix.get(r).size(); c++) {

                    // Check Adjacent
                    if (matrix.get(r).get(c) == 'X') {
                        xmasCount += checkAdjacent(r, c, matrix);
                    }

                    if (matrix.get(r).get(c) == 'A') {
                        masCount += checkMasAdjacent(r, c, matrix);
                    }

                }
            }

            System.out.println("XMAS COUNT: " + xmasCount);
            System.out.println("MAS COUNT: " + masCount);

        } catch (Exception e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }


    public static int checkMasAdjacent(int r, int c, ArrayList<ArrayList<Character>> matrix) {

        int count = 0;

        // Check from left
        // must have: 1 above, 1 below, one to the left, one to the right
        if (r >= 1 && r < matrix.size() - 1 && c >= 1 && c < matrix.get(r).size() - 1) {
            // Check topleft to botright
            if ((matrix.get(r - 1).get(c - 1) == 'M' && matrix.get(r + 1).get(c + 1) == 'S') || (matrix.get(r - 1).get(c - 1) == 'S' && matrix.get(r + 1).get(c + 1) == 'M')) {
                // Check botleft to topright
                if ((matrix.get(r + 1).get(c - 1) == 'M' && matrix.get(r - 1).get(c + 1) == 'S') || (matrix.get(r + 1).get(c - 1) == 'S' && matrix.get(r - 1).get(c + 1) == 'M')) {
                    count++;
                }
            }


        }

        return count;
    }


    public static int checkAdjacent(int r, int c, ArrayList<ArrayList<Character>> matrix) {

        int count = 0;

        // Check forward
        // Must have at least 3 char after
        if (c < matrix.get(r).size() - 3) {
            if (matrix.get(r).get(c + 1) == 'M' &&  matrix.get(r).get(c + 2) == 'A' && matrix.get(r).get(c + 3) == 'S') {
                count++;
            }
        }

        // Check backwards
        // Must have at least 3 char before
        if (c >= 3) {
            if (matrix.get(r).get(c - 1) == 'M' && matrix.get(r).get(c - 2) == 'A' && matrix.get(r).get(c - 3) == 'S') {
                count++;
            }
        }

        // Check downwards
        // Must have at least 3 char below
        if (r < matrix.size() - 3) {

            // Check vertical down
            if (matrix.get(r + 1).get(c) == 'M' && matrix.get(r + 2).get(c) == 'A' && matrix.get(r + 3).get(c) == 'S') {
                count++;
            }

            // Check vertical down left
            // Must have at least 3 before
            if (c >= 3) {
                if (matrix.get(r + 1).get(c - 1) == 'M' && matrix.get(r + 2).get(c - 2) == 'A' && matrix.get(r + 3).get(c - 3) == 'S') {
                    count++;
                }
            }

            // Check vertical down right
            // Must have at least 3 after
            if (c < matrix.get(r).size() - 3) {
                if (matrix.get(r + 1).get(c + 1) == 'M' && matrix.get(r + 2).get(c + 2) == 'A' && matrix.get(r + 3).get(c + 3) == 'S') {
                    count++;
                }
            }
        }

        // Check upwards
        // Must have at least 3 char above
        if (r >= 3) {

            // Check vertical up
            if (matrix.get(r - 1).get(c) == 'M' && matrix.get(r - 2).get(c) == 'A' && matrix.get(r - 3).get(c) == 'S') {
                count++;
            }

            // check vertical up left
            // Must have at least 3 before
            if (c >= 3) {



                if (matrix.get(r - 1).get(c - 1) == 'M' && matrix.get(r - 2).get(c - 2) == 'A' && matrix.get(r - 3).get(c - 3) == 'S') {
                    count++;
                }
            }

            // Check vertical up right
            // Must have at least 3 after
            if (c < matrix.get(r).size() - 3) {
                if (matrix.get(r - 1).get(c + 1) == 'M' && matrix.get(r - 2).get(c + 2) == 'A' && matrix.get(r - 3).get(c + 3) == 'S') {
                    count++;
                }
            }
        }

        return count;
    }


}
