package logic;

import view.LoginForm;
import view_pro.ClassPro;
import view_pro.GradeCheckPro;
import view_pro.MainFormPro;

public class MainFormProLogic {

  MainFormPro mainFormPro = null;
  LoginForm lf = null;
  GradeCheckPro gcp = null;
  ClassPro cp = null;

  public MainFormProLogic(MainFormPro mainFormPro) {
    this.mainFormPro = mainFormPro;
  }

  // 로그아웃
  public void logout() {
    lf = new LoginForm();
    lf.initDisplay();
    mainFormPro.dispose();
  }

  // 성적관리
  public void grade() {
    gcp = new GradeCheckPro();
    gcp.initDisplay();
    mainFormPro.dispose();
  }

  // 수업관리
  public void lecture() {
    cp = new ClassPro();
    cp.initDisplay();
    mainFormPro.dispose();
  }
}
