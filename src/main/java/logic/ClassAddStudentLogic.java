package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view_st.ClassAddStudent;

public class ClassAddStudentLogic implements ActionListener {

  ClassAddStudent cas = null;

  public ClassAddStudentLogic() {

  }

  public ClassAddStudentLogic(ClassAddStudent cas) {
    this.cas = cas;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == cas.jbtn_search) {
      // 검색기능 로직
      // 교수선택후 검색시 해당 교수의 과목이 나오도록 설정

    } else if (obj == cas.jbtn_lectureadd) {
      // 수강신청
      // 선택한 과목을 추가
      // 이미 추가한 과목일시 error message

    } else if (obj == cas.jbtn_cancel) {
      // 취소버튼 => 이전 페이지로 이동
    }
  }

}
