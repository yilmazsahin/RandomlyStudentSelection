package RandomlyStudentSelection;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        StudentListManager studentListManager = new StudentListManager();
        Scanner sc = new Scanner(System.in);
        System.out.println(" Kaç öğrenci seçmek istiyorsunuz? : ");
        int numStudents = sc.nextInt();
        String[] studentList = fileReader.readStudentListFromFile("C:\\Users\\sahin\\Desktop\\JAVA\\Shapes\\src\\RandomlyStudentSelection\\students.txt");
        if (studentList == null || studentList.length == 0) {
            System.out.println("Öğrenci listesi boş.");
            return;
        }
        Random random = new Random();
        System.out.println("Seçilem " + numStudents + " öğrenciler: ");
        for (int i = 0; i < numStudents; i++) {
            int index = random.nextInt(studentList.length);
            String randomStudent = studentList[index];
            Gender gender = getGenderByLastCharacter(randomStudent);
            randomStudent = randomStudent.substring(0, randomStudent.length() - 2);
            System.out.println((i + 1) + " - " + randomStudent + " " + gender.getPostFix());
            studentList = studentListManager.removeStudentFromArray(studentList,index);

        }
    }
    private static Gender getGenderByLastCharacter(String studentName) {
        char lastCharacter = studentName.charAt(studentName.length() - 1);
        return Character.toLowerCase(lastCharacter) == 'e' ? Gender.MALE : Gender.FEMALE;
    }
}
