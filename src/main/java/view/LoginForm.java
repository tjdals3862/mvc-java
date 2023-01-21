package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import logic.LoginEvent;

public class LoginForm extends JFrame {
  // 선언부
  JLabel jlb_id, jlb_pw, jlb_find = null;
  JTextField jtf_id = null;
  JPasswordField jpf_pw = null;
  public JButton jbtn_join = null;
  public JButton jbtn_login = null;;
  JComboBox pro_or_stu = null;
  LoginEvent loginEvent = null;

  // 생성자
  public LoginForm() {
    loginEvent = new LoginEvent(this);
  }

  // 화면그리기
  public void initDisplay() {
    jlb_id = new JLabel("                   ID : ");
    jlb_pw = new JLabel("PASSWORD : ");
    jtf_id = new JTextField();
    jpf_pw = new JPasswordField();
    jbtn_join = new JButton("회원가입");
    jbtn_login = new JButton("로그인");
    jlb_find = new JLabel("ID찾기/비밀번호찾기");
    String pro[] = { "professor", "student" };
    pro_or_stu = new JComboBox<String>(pro);
    this.setLayout(null);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setTitle("성적관리_login");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(410, 300);
    this.setResizable(false);

    // select

    this.add(pro_or_stu);
    pro_or_stu.setBounds(10, 10, 80, 20);

    // id label
    this.add(jlb_id);
    jlb_id.setBounds(70, 50, 80, 40);

    // id txtfield
    this.add(jtf_id);
    jtf_id.setBounds(150, 50, 170, 40);

    // pw label
    this.add(jlb_pw);
    jlb_pw.setBounds(70, 110, 80, 40);

    // pw txtfield
    this.add(jpf_pw);
    jpf_pw.setBounds(150, 110, 170, 40);

    // btn log-in
    this.add(jbtn_login);
    jbtn_login.setBounds(70, 190, 120, 40);

    // btb register
    this.add(jbtn_join);
    jbtn_join.setBounds(200, 190, 120, 40);

    // find id/pwd
    this.add(jlb_find);
    jlb_find.setBounds(205, 220, 120, 40);
    jlb_find.setForeground(Color.gray);

    // btn for action
    jbtn_join.addActionListener(loginEvent);
    jbtn_login.addActionListener(loginEvent);

  }

  public static void main(String[] args) {
    LoginForm lf = new LoginForm();
    lf.initDisplay();
  }

}