package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JOptionPane;

import dao.StudentDao;
import dto.GradeVO;
import view_pro.Inputgrade;

public class InputgradeLogic implements ActionListener, ItemListener {

  Inputgrade input = null;
  String student = null;
  String lecture = null; // 사용자가 선택한 강의
  String students[] = null; // DB에서 가져온 학생리스트
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

  @Override
  public void itemStateChanged(ItemEvent ie) {

    Object obj = ie.getSource();

    if (obj == input.jcb_lecture) {
      if (ie.getStateChange() == ItemEvent.SELECTED) {
        // 첫번째 combobox를 선택시 두번째 데이터를 가져온다
        lecture = input.lecture[input.jcb_lecture.getSelectedIndex()];
        students = getStudentList(lecture);
        input.jcb_student.removeAllItems();

        for (int i = 0; i < students.length; i++) {
          input.jcb_student.addItem(students[i]);
        }
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    Object obj = e.getSource();
    if (obj == input.jbtn_input) {
      // 성적 입력
      try {
        // combobox에서 선택한 값으로 dto에 넣는다
        lecture = input.lecture[input.jcb_lecture.getSelectedIndex()];
        student = students[input.jcb_student.getSelectedIndex()];
        grade = Integer.parseInt(input.jtf_grade.getText());
        gVO = new GradeVO(lecture, student, grade);
        result = sd.getgrade(gVO);
        // 결과값이 1일때 성공
        if (result == 1) {
          input.jtf_grade.setText("");
          JOptionPane.showMessageDialog(input, "성적 반영 완료되었습니다.", "Success", 1);
        }

      } catch (Exception ae) {
        JOptionPane.showMessageDialog(input, "강의 및 학생을 선택하세요", "ERROR", 1);
      }

    } else if (obj == input.jbtn_cancel) {
      input.dispose();
    }

  }

  public static void main(String[] args) {
    InputgradeLogic input = new InputgradeLogic();

  }
}
