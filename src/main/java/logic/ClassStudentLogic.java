package logic;

import view_st.ClassStudent;
import view_st.MainFormStudent;
import view.LoginForm;
import dto.StudentVO;
import view_st.MainFormStudent;
import view_st.ClassAddStudent;

import javax.swing.JOptionPane;

import dao.ClassDao;
import dto.LectureVO;

public class ClassStudentLogic {

  ClassStudent classStudent = null;
  ClassAddStudent classAddStudent = null;
  ClassDao cd = null;
  private String lecture = null;
  private String lectime = null;
  private String professor = null;

  MainFormStudent mainFormStudent = null;
  StudentVO svo = null;

  public ClassStudentLogic() {

  }

  public ClassStudentLogic(ClassStudent classStudent, StudentVO svo) {
    this.classStudent = classStudent;
    this.svo = svo;
  }

  public ClassStudentLogic(ClassStudent classStudent) {
    this.classStudent = classStudent;

  }

  public void lectureAddStudent() {
    ClassAddStudent classAddStudent = new ClassAddStudent(svo);
    classAddStudent.initDisplay();

  }

  // 취소 - 메인으로 돌아가기....
  public void cancel() {
    MainFormStudent main = new MainFormStudent(svo);
    main.initDisplay();
    classStudent.dispose();
  }

  //삭제 ===========================수정해야함
  public void lectureDelete() {
    cd = new ClassDao();
    int row = classAddStudent.jtb_grade.getSelectedRow();
    lecture = (String) classAddStudent.dtm_grade.getValueAt(row, 0);
    professor = (String) classAddStudent.dtm_grade.getValueAt(row, 1);
    lectime = (String) classAddStudent.dtm_grade.getValueAt(row, 2);
    LectureVO gpvo = new LectureVO(lecture, professor, lectime);
    int result = cd.getdellecture(gpvo);
    if (result == 1) {
      JOptionPane.showMessageDialog(classAddStudent, "강의 삭제 완료", "Success", 1);
      classAddStudent.dtm_grade.removeRow(row);

    }
  }

}
