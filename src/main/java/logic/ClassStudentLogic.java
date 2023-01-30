package logic;

import view_st.ClassStudent;
import view_st.MainFormStudent;
import view.LoginForm;
import dto.StudentVO;
import view_st.MainFormStudent;
import view_st.ClassAddStudent;

public class ClassStudentLogic {

  ClassStudent classStudent = null;
  ClassAddStudent classAddStudent = null;

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

}
