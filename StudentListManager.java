package RandomlyStudentSelection;

public class StudentListManager {
    public String[] removeStudentFromArray(String[] studentList, int index) {
        if (studentList == null || index < 0 || index >= studentList.length) {
            return studentList;
        }
        String[] newStudentList = new String[studentList.length - 1];
        int j = 0;
        for (int i = 0; i < newStudentList.length; i++) {

            if (i == index) {
                j++;
            }
            newStudentList[i] = studentList[j++];
        }

        return newStudentList;
    }
}
