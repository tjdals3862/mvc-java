package view_pro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// 성적입력
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dto.GradeVO;
import logic.GradeCheckProLogic;
import logic.InputgradeLogic;

public class Inputgrade extends JFrame implements ActionListener, ItemListener {

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
  // String students[] = null; // DB에서 가져온 학생리스트
  int grade;
  // String lecture[] = { "강의" };
  String total[] = { "전체" };
  private String[] students;

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(null);

    gcpl = new GradeCheckProLogic();
    lecture = gcpl.getLectureList();
    jcb_lecture = new JComboBox(lecture);

    jcb_lecture.addItemListener(this);
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

    jbtn_input.addActionListener(this);
    jbtn_cancel.addActionListener(this);

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
    this.setResizable(false);

  }

  @Override
  public void itemStateChanged(ItemEvent ie) {
    Object obj = ie.getSource();

    if (obj == jcb_lecture) {
      if (ie.getStateChange() == ItemEvent.SELECTED) {
        // 첫번째 combobox를 선택시 두번째 데이터를 가져온다
        String lecture = this.lecture[jcb_lecture.getSelectedIndex()];
        inputlogic.stateChange(lecture);
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn_input) {
      // 성적 입력
      try {
        // combobox에서 선택한 값으로 dto에 넣는다
        String lecture = this.lecture[jcb_lecture.getSelectedIndex()];
        String student = inputlogic.students[jcb_student.getSelectedIndex()];
        grade = Integer.parseInt(jtf_grade.getText());

        int result = inputlogic.input(lecture, student, grade);
        // 결과값이 1일때 성공
        if (result == 1) {
          jtf_grade.setText("");
          JOptionPane.showMessageDialog(this, "성적 반영 완료되었습니다.", "Success", 1);
        }

      } catch (Exception ae) {
        JOptionPane.showMessageDialog(this, "강의 및 학생을 선택하세요", "ERROR", 1);
        ae.printStackTrace();
      }

    } else if (obj == jbtn_cancel) {
      this.dispose();
    }
  }
}
