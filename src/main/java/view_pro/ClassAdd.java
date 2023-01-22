package view_pro;

// 강의 추가
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.ClassAddLogic;

public class ClassAdd extends JFrame {
  Font f = null;
  JLabel jlb_title = null;
  JLabel jlb_lecture = null;
  JLabel jlb_professor = null;
  JLabel jlb_lectime = null;
  public JTextField jtf_lecture = null;
  public JTextField jtf_professor = null;
  public JTextField jtf_lectime = null;

  public JButton jbtn_add = null;
  public JButton jbtn_cancel = null;

  ClassAddLogic cal = null;

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(null);

    jlb_title = new JLabel("강의 추가");
    f = new Font("굴림체", Font.BOLD, 16);
    jlb_title.setFont(f);

    jlb_lecture = new JLabel("강의명");
    jlb_professor = new JLabel("교수명");
    jlb_lectime = new JLabel("강의시간");
    jtf_lecture = new JTextField();
    jtf_professor = new JTextField();
    jtf_lectime = new JTextField();
    jbtn_add = new JButton("추가");
    jbtn_cancel = new JButton("취소");

    this.add(jlb_title);
    this.add(jlb_lecture);
    this.add(jlb_professor);
    this.add(jlb_lectime);
    this.add(jtf_lecture);
    this.add(jtf_professor);
    this.add(jtf_lectime);
    this.add(jbtn_add);
    this.add(jbtn_cancel);

    cal = new ClassAddLogic(this);
    jbtn_add.addActionListener(cal);
    jbtn_cancel.addActionListener(cal);

    jlb_title.setBounds(125, 15, 100, 30);
    jlb_lecture.setBounds(50, 70, 100, 30);
    jlb_professor.setBounds(50, 120, 100, 30);
    jlb_lectime.setBounds(50, 170, 100, 30);
    jtf_lecture.setBounds(170, 70, 130, 30);
    jtf_professor.setBounds(170, 120, 130, 30);
    jtf_lectime.setBounds(170, 170, 130, 30);
    jbtn_add.setBounds(50, 250, 100, 30);
    jbtn_cancel.setBounds(200, 250, 100, 30);

    this.setTitle("강의 추가");
    this.setLocation(500, 100);
    this.setSize(350, 350);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    ClassAdd ca = new ClassAdd();
    ca.initDisplay();
  }

}
