package view_pro;

// 성적입력
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.GradeCheckProLogic;
import logic.InputgradeLogic;

public class Inputgrade extends JFrame {

  JLabel jlb_grade = null;
  JLabel jlb_lecture = null;
  JLabel jlb_student = null;

  public JComboBox jcb_lecture = null;
  public JComboBox jcb_student = null;
  public JButton jbtn_input = null;
  public JButton jbtn_cancel = null;

  public JTextField jtf_grade = null;
  InputgradeLogic inputlogic = new InputgradeLogic(this);
  GradeCheckProLogic gcpl = null;

  public String[] lecture = null; // db에서 가져온 강의목록
  String[] student = null;
  // String lecture[] = { "강의" };
  String total[] = { "전체" };

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(null);

    gcpl = new GradeCheckProLogic();
    lecture = gcpl.getLectureList();
    jcb_lecture = new JComboBox(lecture);

    jcb_lecture.addItemListener(inputlogic);
    jcb_student = new JComboBox(total);

    jlb_grade = new JLabel("성적");
    jlb_lecture = new JLabel("강의");
    jlb_student = new JLabel("학생");
    jtf_grade = new JTextField();
    jbtn_input = new JButton("입력/수정");
    jbtn_cancel = new JButton("취소");

    this.add(jcb_lecture);
    this.add(jcb_student);
    this.add(jlb_grade);
    this.add(jlb_lecture);
    this.add(jlb_student);
    this.add(jtf_grade);
    this.add(jbtn_input);
    this.add(jbtn_cancel);

    jbtn_input.addActionListener(inputlogic);
    jbtn_cancel.addActionListener(inputlogic);

    jlb_lecture.setBounds(0, 0, 30, 30);
    jlb_student.setBounds(240, 0, 30, 30);
    jcb_lecture.setBounds(30, 0, 200, 30);
    jcb_student.setBounds(270, 0, 100, 30);
    jlb_grade.setBounds(100, 100, 100, 30);
    jtf_grade.setBounds(190, 100, 100, 30);
    jbtn_input.setBounds(150, 220, 100, 30);
    jbtn_cancel.setBounds(270, 220, 100, 30);

    this.setTitle("성적 입력");
    this.setLocation(500, 100);
    this.setSize(400, 300);
    this.setVisible(true);

  }

  public static void main(String[] args) {
    Inputgrade ig = new Inputgrade();
    ig.initDisplay();
  }
}
