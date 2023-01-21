package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginForm;
import view.RegisterForm;
import view_pro.MainFormPro;

public class LoginEvent implements ActionListener {

  LoginForm loginForm = null;
  MainFormPro mpf = null;
  RegisterForm rf = null;

  public LoginEvent(LoginForm loginForm) {
    this.loginForm = loginForm;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();

    if (obj == loginForm.jbtn_login) {
      mpf = new MainFormPro();
      // login logic 작성

      mpf.initDisplay();
      loginForm.dispose();
    } else if (obj == loginForm.jbtn_join) {
      rf = new RegisterForm();
      rf.initDisplay();
    }
  }
}
