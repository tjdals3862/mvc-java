package logic;

import dao.LoginDao;
import dto.LoginVO;
import dto.ProfessorVO;
import dto.StudentVO;
import view.LoginForm;
import view.RegisterForm;
import view_pro.MainFormPro;

public class LoginLogic {

  LoginForm loginForm = null;
  // LoginDao logindao = null;
  MainFormPro mpf = null;
  RegisterForm rf = null;
  StudentVO svo = null;
  ProfessorVO pvo = null;

  public LoginLogic(LoginForm loginForm) {
    this.loginForm = loginForm;
  }

  public StudentVO Studentlogin(LoginVO lvo) {
    LoginDao logindao = new LoginDao();
    svo = logindao.loginstudent(lvo);
    return svo;
  }

  public ProfessorVO Professorlogin(LoginVO lvo) {
    LoginDao logindao = new LoginDao();
    pvo = logindao.loginprofessor(lvo);

    return pvo;
  }

  public int StudentLoginCheck(StudentVO svo, String id) {
    int result = 0;
    try {
      if (id.equals(svo.getSt_id())) {
        result = 2;
      }
    } catch (NullPointerException e) {
      result = 0;
    }
    return result;
  }

  public int ProfessorLoginCheck(ProfessorVO pvo, String id) {
    int result = 0;
    try {
      if (id.equals(pvo.getPr_id())) {
        result = 1;
      }
    } catch (NullPointerException e) {
      result = 0;
    }
    return result;
  }

}
