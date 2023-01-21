package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginForm;
import view_pro.ClassPro;
import view_pro.GradeCheckPro;
import view_pro.MainFormPro;

public class MainFormProLogic implements ActionListener {

  MainFormPro mainFormPro = null;
  LoginForm lf = null;
  GradeCheckPro gcp = null;
  ClassPro cp = null;

  public MainFormProLogic(MainFormPro mainFormPro) {
    this.mainFormPro = mainFormPro;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == mainFormPro.jbtn_logout) {
      lf = new LoginForm();
      lf.initDisplay();
      mainFormPro.dispose();
    } else if (obj == mainFormPro.jbtn_grade) {
      gcp = new GradeCheckPro();
      gcp.initDisplay();
      mainFormPro.dispose();
    } else if (obj == mainFormPro.jbtn_leture) {
      cp = new ClassPro();
      cp.initDisplay();
      mainFormPro.dispose();
    }

  }

}
