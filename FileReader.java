package RandomlyStudentSelection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public String[] readStudentListFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int numlines = 0;
        while (sc.hasNextLine()) {
            numlines++;
            sc.nextLine();
        }
        String[] studentList = new String[numlines];
        sc = new Scanner(file);

        for (int i = 0; i < numlines; i++) {
            studentList[i] = sc.nextLine();
        }

        return studentList;
    }
}
