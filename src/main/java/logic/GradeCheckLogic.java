package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view_st.GradeCheck;

public class GradeCheckLogic implements ActionListener {

  GradeCheck gc = null;

  public GradeCheckLogic(GradeCheck gc) {
    this.gc = gc;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();

    if (obj == gc.jbtn_search) {
      // 검색 로직
      // 과목에 대한 성적을 출력하며
      // 전체 과목일시 해당 학생의 전체 성적 출력하도록 설정
    } else if (obj == gc.jbtn_cancle) {

    }
  }

}
