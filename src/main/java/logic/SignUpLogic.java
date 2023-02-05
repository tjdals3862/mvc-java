package logic;

import javax.swing.JOptionPane;

import dao.ClassDao;
import dao.SignUpDao;
import dto.LectureVO;
import dto.SignUpVO;
import util.MyBatisCommonFactory;
import view.RegisterForm;

public class SignUpLogic {

  MyBatisCommonFactory mcf = new MyBatisCommonFactory();
  RegisterForm rf = null;
  SignUpDao sud = null;
  SignUpVO svo = null;
  String lecture = null;
  String professor = null;
  String lectime = null;

  public SignUpLogic() {

  }

  public SignUpLogic(RegisterForm rf) {
    this.rf = rf;
  }

}
