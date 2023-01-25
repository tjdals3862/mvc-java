package logic;

import java.util.List;

import javax.swing.JOptionPane;

import dao.StudentDao;
import dto.GradeVO;
import view_pro.Inputgrade;

public class InputgradeLogic {

  Inputgrade input = null;
  String student = null;
  String lecture = null; // 사용자가 선택한 강의
  public String students[] = null; // DB에서 가져온 학생리스트
  StudentDao sd = null;
  GradeVO gVO = null;
  int result; // 수정,입력 성공/실패 여부 확인
  int grade;

  public InputgradeLogic() {
  }

  public InputgradeLogic(Inputgrade input) {
    this.input = input;
  }

  public String[] getStudentList(String lecture) {
    sd = new StudentDao();
    List<String> studentList = sd.getstudentList(lecture);
    students = new String[studentList.size()];

    for (int i = 0; i < students.length; i++) {
      students[i] = studentList.get(i);
    }
    return students;
  }

  public void stateChange(String lecture) {
    students = getStudentList(lecture);
    input.jcb_student.removeAllItems();

    for (int i = 0; i < students.length; i++) {
      input.jcb_student.addItem(students[i]);
    }
  }

  public int input(String lecture, String student, int grade) {
    gVO = new GradeVO(lecture, student, grade);
    result = sd.getgrade(gVO);

    return result;
  }

  public static void main(String[] args) {
    InputgradeLogic input = new InputgradeLogic();

  }
}
