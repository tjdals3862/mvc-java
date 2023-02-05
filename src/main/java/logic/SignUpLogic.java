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

  // // 강의 추가
  // public SignUpVO add(String name, String id, String pw, String email, String
  // phone) {
  // sud = new SignUpDao();

  // // 가져온 데이터를 dto를 통해 생성후 파라미터로 전달
  // svo = new SignUpVO(name, id, pw, email, phone);
  // int result = sud.signUpStudent(svo);

  // return result;
  // }

}
