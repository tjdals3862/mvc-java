package logic;

import view.LoginForm;
import dto.StudentVO;
import view_st.MainFormStudent;
import view_st.ClassStudent;
import view_st.GradeCheck;

public class MainFormStudentLogic {

  MainFormStudent mainFormStudent = null;
  LoginForm lf = null;
  StudentVO svo = null;
  ClassStudent cs = null;
  GradeCheck gc = null;

  public MainFormStudentLogic(MainFormStudent mainFormStudent, StudentVO svo) {
    this.mainFormStudent = mainFormStudent;
    this.svo = svo;

  }

  public void logout() {
    lf = new LoginForm();
    lf.initDisplay();
    mainFormStudent.dispose();
  }

  // class student 관리
  public void lecture() {
    cs = new ClassStudent(svo);
    cs.initDisplay();
    mainFormStudent.dispose();
  }

  // gradecheck
  public void gradeCheckView(StudentVO svo) {
    gc = new GradeCheck(svo);
    gc.initDisplay();
    
  }

}
