package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dto.SignUpVO;
import dto.SignUpproVO;
import logic.RegisterLogic;

public class RegisterForm extends JFrame implements ActionListener {
  // 선언부

  JLabel jlb_name, jlb_id, jlb_pw, jlb_pw2, jlb_email, jlb_tel, jlb_nickName;
  JTextField jtf_name, jtf_id;
  JPasswordField jtf_pw, jtf_pw2;
  JTextField jtf_email, jtf_tel, jtf_nickName;
  JButton jbtn_idconfirm, jbtn_join, jbtn_cancel;
  JComboBox pro_or_stu = null;
  String pro[] = { "professor", "student" };

  SignUpVO suvo = null;
  SignUpproVO supvo = null;
  RegisterLogic rl = null;
  // 생성자
  public RegisterForm() {
  }

  // 화면그리기
  public void initDisplay() {

    jlb_name = new JLabel("이름 : ");
    jlb_id = new JLabel("아이디 : ");
    jlb_pw = new JLabel("비밀번호 : ");
    jlb_pw2 = new JLabel("비밀번호확인 : ");
    jlb_email = new JLabel("      email : ");
    jlb_tel = new JLabel("전화번호 : ");
    jlb_nickName = new JLabel("닉네임 : ");
    jtf_name = new JTextField(""); // 이름
    jtf_id = new JTextField(""); // 아이디
    jtf_pw = new JPasswordField(""); // 비밀번호
    jtf_pw2 = new JPasswordField(""); // 비밀번호 확인
    jtf_email = new JTextField(""); // email
    jtf_tel = new JTextField(""); // 폰번호
    jtf_nickName = new JTextField(""); // 닉네임
    jbtn_join = new JButton("회원가입");// 회원가입 버튼
    jbtn_cancel = new JButton("취소");// 취소 버튼
    pro_or_stu = new JComboBox<String>(pro);


    this.setLayout(null);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setTitle("성적관리_register");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(600, 420);
    this.setResizable(false);

    // select
    this.add(pro_or_stu);
    pro_or_stu.setBounds(10, 10, 110, 20);

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
    this.add(jlb_email);
    jlb_email.setBounds(155, 210, 200, 35);
    this.add(jtf_email);
    jtf_email.setBounds(220, 210, 180, 35);
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
    Object obj = e.getSource();

    if (obj == jbtn_join) {
      String name = jtf_name.getText();
      String id = jtf_id.getText();
      String pw = jtf_pw.getText();
      String pw2 = jtf_pw2.getText();
      String email = jtf_email.getText();
      String phone = jtf_tel.getText();
      String select = pro[pro_or_stu.getSelectedIndex()];
      rl = new RegisterLogic(this);

      while(true) {

      if (("").equals(name)) {
        JOptionPane.showMessageDialog(this, "이름칸이 비었습니다.");
        break;
      } else if (("").equals(id)) {
        JOptionPane.showMessageDialog(this, "id칸이 비었습니다.");
        break;
      } else if (("").equals(pw)) {
        JOptionPane.showMessageDialog(this, "비밀번호칸이 비었습니다.");
        break;
      } else if (("").equals(pw2)) {
        JOptionPane.showMessageDialog(this, "비밀번호칸이 비었습니다.");
        break;
      } else if (pw.equals(pw2)) {
        JOptionPane.showMessageDialog(this, "비밀번호를 다시 확인해주세요 ");
        break;
      } else if (("").equals(email)) {
        JOptionPane.showMessageDialog(this, "이메일을 입력해주세요. ");
        break;
      } else if (("").equals(phone)) {
        JOptionPane.showMessageDialog(this, "핸드폰번호를 입력해주세요. ");
        break;
      } 

      

        if(select.equals("student")) {
          suvo = new SignUpVO(name, id, pw, email, phone);       
          int result =  rl.studentjoin(suvo);
          if(result == 1) {
            JOptionPane.showMessageDialog(this, "회원가입 완료");
            this.dispose();
          }
        } else if(select.equals("professor")){
          supvo = new SignUpproVO(name, id, pw);
          int result = rl.professorjoin(supvo);
          if(result == 1) {
            JOptionPane.showMessageDialog(this, "회원가입 완료");
            this.dispose();
          }
        }
      }
    }
    if (obj == jbtn_cancel) {
      this.dispose();
    }
  }
}