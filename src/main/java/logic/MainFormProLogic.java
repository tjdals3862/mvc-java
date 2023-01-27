package logic;

import dto.ProfessorVO;
import view.LoginForm;
import view_pro.ClassPro;
import view_pro.GradeCheckPro;
import view_pro.MainFormPro;

public class MainFormProLogic {

  MainFormPro mainFormPro = null;
  LoginForm lf = null;
  GradeCheckPro gcp = null;
  ClassPro cp = null;
  ProfessorVO pvo = null;

  public MainFormProLogic(MainFormPro mainFormPro, ProfessorVO pvo) {
    this.mainFormPro = mainFormPro;
    this.pvo = pvo;
  }

  // 로그아웃
  public void logout() {
    lf = new LoginForm();
    lf.initDisplay();
    mainFormPro.dispose();
  }

  // 성적관리
  public void grade(ProfessorVO pvo) {
    gcp = new GradeCheckPro(pvo);
    gcp.initDisplay();
    mainFormPro.dispose();
  }

  // 수업관리
  public void lecture() {
    cp = new ClassPro(pvo);
    cp.initDisplay();
    mainFormPro.dispose();
  }
}
