package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginForm;
import view_st.MainFormStudent;

public class MainFormStudentLogic implements ActionListener {

  MainFormStudent mfs = null;
  LoginForm lf = null;

  public MainFormStudentLogic(MainFormStudent mfs) {
    this.mfs = mfs;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    Object obj = new Object();
    if (obj == mfs.jbtn_logout) {
      // 로그아웃 로직
    } else if (obj == mfs.jbtn_grade) {
      // 성적확인 로직
    } else if (obj == mfs.jbtn_leture) {
      // 강의확인 로직
    }

  }

}
