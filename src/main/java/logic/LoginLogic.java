package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginForm;
import view.RegisterForm;
import view_pro.MainFormPro;

public class LoginLogic {

  LoginForm loginForm = null;
  MainFormPro mpf = null;
  RegisterForm rf = null;

  public LoginLogic(LoginForm loginForm) {
    this.loginForm = loginForm;
  }

}
