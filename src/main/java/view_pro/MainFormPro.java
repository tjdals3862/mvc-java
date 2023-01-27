package view_pro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dto.ProfessorVO;
import logic.MainFormProLogic;

import java.awt.Font;

public class MainFormPro extends JFrame implements ActionListener {
  JLabel jlb_title = null;
  JLabel jlb_id = null;
  JLabel jlb_name = null;
  JLabel jlb_id2 = null;
  JLabel jlb_pw2 = null;

  JButton jbtn_logout = null;
  JButton jbtn_grade = null;
  JButton jbtn_leture = null;

  String id = null;
  String name = null;
  Font f = null;
  MainFormProLogic mfpl = null;
  ProfessorVO pvo = null;

  public MainFormPro() {

  }

  public MainFormPro(ProfessorVO pvo) {
    this.pvo = pvo;
    this.id = pvo.getPr_id();
    this.name = pvo.getPro_name();

  }

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    f = new Font("굴림체", Font.BOLD, 18);

    jlb_title = new JLabel("교수용 학사 관리 프로그램");
    jlb_title.setFont(f);

    jlb_id = new JLabel("교수번호 : " + id);
    jlb_name = new JLabel("이름 : " + name);

    jbtn_logout = new JButton("로그아웃");
    jbtn_grade = new JButton("성적관리");
    jbtn_leture = new JButton("수업관리");

    this.add(jlb_title);
    this.add(jlb_id);
    this.add(jlb_name);
    this.add(jbtn_logout);
    this.add(jbtn_grade);
    this.add(jbtn_leture);

    jbtn_logout.addActionListener(this);
    jbtn_grade.addActionListener(this);
    jbtn_leture.addActionListener(this);

    jlb_title.setBounds(100, 25, 250, 35);
    jlb_id.setBounds(45, 105, 200, 35);
    jlb_name.setBounds(45, 135, 200, 35);
    jbtn_logout.setBounds(245, 105, 130, 35);
    jbtn_grade.setBounds(45, 235, 130, 35);
    jbtn_leture.setBounds(245, 235, 130, 35);

    this.setTitle("학사관리 프로그램");
    this.setLocation(500, 100);
    this.setSize(450, 350);
    this.setVisible(true);
    this.setResizable(false);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    mfpl = new MainFormProLogic(this, pvo);
    if (obj == jbtn_logout) {
      mfpl.logout();
    } else if (obj == jbtn_grade) {
      mfpl.grade(pvo);
    } else if (obj == jbtn_leture) {
      mfpl.lecture();
    }
  }
}
