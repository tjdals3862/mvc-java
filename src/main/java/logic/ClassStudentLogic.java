package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view_st.ClassStudent;

public class ClassStudentLogic implements ActionListener {

  ClassStudent cs = null;

  public ClassStudentLogic() {

  }

  public ClassStudentLogic(ClassStudent cs) {
    this.cs = cs;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == cs.jbtn_search) {
      // 새로고침로직
      // 새로고침시 테이블 초기화

    } else if (obj == cs.jbtn_lectureadd) {
      // 강의 추가 로직

    } else if (obj == cs.jbtn_lecturedel) {
      // 수강 취소 로직
      // 테이블 선택시 선택한 과목 삭제

    } else if (obj == cs.jbtn_cancel) {
      // 취소 로직
    }

  }

}
