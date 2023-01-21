package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterForm extends JFrame implements ActionListener {
  // 선언부

  // ==========사용예정 >_<============
  // LoginForm loginForm = null;
  // DBCon db = null;
  // Connection conn = null;
  // PreparedStatement pstm = null;
  // ResultSet rs = null;
  // DbFunction dbf = null;
  // JLabel jlb_idAvble, jlb_idNotAvble;
  // ==========여기까지 >_<============

  JLabel jlb_name, jlb_id, jlb_pw, jlb_pw2, jlb_birth, jlb_tel, jlb_nickName;
  JTextField jtf_name, jtf_id;
  JPasswordField jtf_pw, jtf_pw2;
  JTextField jtf_birth, jtf_tel, jtf_nickName;
  JButton jbtn_idconfirm, jbtn_join, jbtn_cancel;

  // 생성자
  public RegisterForm() {
  }

  // 화면그리기
  public void initDisplay() {

    jlb_name = new JLabel("이름 : ");
    jlb_id = new JLabel("아이디 : ");
    jlb_pw = new JLabel("비밀번호 : ");
    jlb_pw2 = new JLabel("비밀번호확인 : ");
    jlb_birth = new JLabel("      email : ");
    jlb_tel = new JLabel("전화번호 : ");
    jlb_nickName = new JLabel("닉네임 : ");
    jtf_name = new JTextField(""); // 이름
    jtf_id = new JTextField(""); // 아이디
    jtf_pw = new JPasswordField(""); // 비밀번호
    jtf_pw2 = new JPasswordField(""); // 비밀번호 확인
    jtf_birth = new JTextField(""); // 생년월일
    jtf_tel = new JTextField(""); // 폰번호
    jtf_nickName = new JTextField(""); // 닉네임
    jbtn_idconfirm = new JButton("ID 확인"); // 로그인 버튼
    jbtn_join = new JButton("회원가입");// 회원가입 버튼
    jbtn_cancel = new JButton("취소");// 취소 버튼

    // =======================사용예정 >_<==================
    // jlb_idAvble = new JLabel("사용가능한 아이디 입니다.");
    // jlb_idNotAvble = new JLabel("중복된 아이디 입니다.");
    // ========================여기까지 >_<=================

    this.setLayout(null);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setTitle("성적관리_register");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(600, 420);
    this.setResizable(false);

    // name
    this.add(jlb_name);
    jlb_name.setBounds(180, 50, 200, 35);
    this.add(jtf_name);
    jtf_name.setBounds(220, 50, 180, 35);
    // id
    this.add(jlb_id);
    jlb_id.setBounds(167, 90, 200, 35);
    this.add(jtf_id);
    jtf_id.setBounds(220, 90, 180, 35);

    // id check btn
    this.add(jbtn_idconfirm);
    jbtn_idconfirm.setBounds(405, 90, 90, 35);

    // pw
    this.add(jlb_pw);
    jlb_pw.setBounds(155, 130, 200, 35);
    this.add(jtf_pw);
    jtf_pw.setBounds(220, 130, 180, 35);
    // pw2
    this.add(jlb_pw2);
    jlb_pw2.setBounds(130, 170, 200, 35);
    this.add(jtf_pw2);
    jtf_pw2.setBounds(220, 170, 180, 35);
    // birth
    this.add(jlb_birth);
    jlb_birth.setBounds(155, 210, 200, 35);
    this.add(jtf_birth);
    jtf_birth.setBounds(220, 210, 180, 35);
    // tel
    this.add(jlb_tel);
    jlb_tel.setBounds(155, 250, 200, 35);
    this.add(jtf_tel);
    jtf_tel.setBounds(220, 250, 180, 35);

    // register btn
    jbtn_join.setBounds(170, 300, 110, 35);
    this.add(jbtn_join);
    // cancel btn
    jbtn_cancel.setBounds(290, 300, 110, 35);
    this.add(jbtn_cancel);

    // btn event
    jbtn_idconfirm.addActionListener(this);
    jbtn_join.addActionListener(this);
    jbtn_cancel.addActionListener(this);

  }

  public static void main(String[] args) {
    RegisterForm rs = new RegisterForm();
    rs.initDisplay();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub

  }
}