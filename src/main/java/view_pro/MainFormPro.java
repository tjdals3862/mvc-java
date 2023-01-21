package view_pro;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.MainFormProLogic;

import java.awt.Font;

public class MainFormPro extends JFrame {
  JLabel jlb_title = null;
  JLabel jlb_id = null;
  JLabel jlb_pw = null;
  JLabel jlb_id2 = null;
  JLabel jlb_pw2 = null;

  public JButton jbtn_logout = null;
  public JButton jbtn_grade = null;
  public JButton jbtn_leture = null;

  String id = null;
  String pw = null;
  Font f = null;
  MainFormProLogic mfpl = null;

  public MainFormPro() {

  }

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    f = new Font("굴림체", Font.BOLD, 18);

    jlb_title = new JLabel("교수용 학사 관리 프로그램");
    jlb_title.setFont(f);

    jlb_id = new JLabel("교수번호 : ");
    jlb_pw = new JLabel("이름 : ");
    jlb_id2 = new JLabel(id);
    jlb_pw2 = new JLabel(pw);

    jbtn_logout = new JButton("로그아웃");
    jbtn_grade = new JButton("성적관리");
    jbtn_leture = new JButton("수업관리");

    this.add(jlb_title);
    this.add(jlb_id);
    this.add(jlb_pw);
    this.add(jlb_id2);
    this.add(jlb_pw2);
    this.add(jbtn_logout);
    this.add(jbtn_grade);
    this.add(jbtn_leture);

    mfpl = new MainFormProLogic(this);
    jbtn_logout.addActionListener(mfpl);
    jbtn_grade.addActionListener(mfpl);
    jbtn_leture.addActionListener(mfpl);

    jlb_title.setBounds(100, 25, 250, 35);
    jlb_id.setBounds(45, 105, 200, 35);
    jlb_pw.setBounds(45, 135, 200, 35);
    jlb_id2.setBounds(90, 105, 200, 35);
    jlb_pw2.setBounds(90, 135, 200, 35);
    jbtn_logout.setBounds(245, 105, 130, 35);
    jbtn_grade.setBounds(45, 235, 130, 35);
    jbtn_leture.setBounds(245, 235, 130, 35);

    this.setTitle("학사관리 프로그램");
    this.setLocation(500, 100);
    this.setSize(450, 350);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    MainFormPro mainFormPro = new MainFormPro();
    mainFormPro.initDisplay();

  }
}
