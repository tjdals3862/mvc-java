package view_st;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logic.ClassProLogic;
import logic.ClassStudentLogic;
import view_pro.ClassPro;

public class ClassStudent extends JFrame implements ActionListener {
  JLabel jlb_title = null;
  JLabel jlb_semititle = null;
  public JButton jbtn_search = null;
  public JButton jbtn_lectureadd = null;
  public JButton jbtn_lecturedel = null;
  public JButton jbtn_cancel = null;
  public JComboBox jcb_professor = null;
  Font f = null;

  String totals[] = { "전체" };
  String[] cols = { "수업명", "교수", "시간" };
  String[][] data = new String[0][0];
  public String[] prolist = null; // db에서 가져온 강의목록
  public DefaultTableModel dtm_grade = null;
  public JTable jtb_grade = null;
  JTableHeader jth_grade = null;
  JScrollPane jsp_grade = null;

  ClassStudentLogic gsl = null;

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(null);

    dtm_grade = new DefaultTableModel(data, cols);
    jtb_grade = new JTable(dtm_grade);
    jth_grade = jtb_grade.getTableHeader();
    jsp_grade = new JScrollPane(jtb_grade, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    jbtn_search = new JButton("새로고침");
    jlb_title = new JLabel("수업 관리");
    jlb_semititle = new JLabel("수업");
    jbtn_lectureadd = new JButton("수강신청");
    jbtn_lecturedel = new JButton("강의취소");
    jbtn_cancel = new JButton("취소");

    gsl = new ClassStudentLogic(this);
    // prolist = gsl.getProList();
    jcb_professor = new JComboBox(totals);
    f = new Font("굴림체", Font.BOLD, 16);

    jlb_title.setFont(f);
    jlb_semititle.setFont(f);

    this.add(jsp_grade);
    this.add(jlb_semititle);
    this.add(jlb_title);
    this.add(jbtn_search);
    this.add(jbtn_lectureadd);
    this.add(jbtn_lecturedel);
    this.add(jbtn_cancel);
    this.add(jcb_professor);

    jbtn_search.addActionListener(this);
    jbtn_lectureadd.addActionListener(this);
    jbtn_lecturedel.addActionListener(this);
    jbtn_cancel.addActionListener(this);

    jcb_professor.setBounds(245, 60, 240, 30);
    jsp_grade.setBounds(0, 100, 490, 350);
    jlb_title.setBounds(250, 10, 250, 30);
    jlb_semititle.setBounds(150, 60, 100, 30);
    jbtn_search.setBounds(500, 60, 100, 30);
    jbtn_lectureadd.setBounds(500, 130, 100, 30);
    jbtn_lecturedel.setBounds(500, 200, 100, 30);
    jbtn_cancel.setBounds(500, 270, 100, 30);

    this.setTitle("수업 관리/학생");
    this.setLocation(500, 100);
    this.setSize(630, 400);
    this.setVisible(true);
    this.setResizable(false);

  }

  public static void main(String[] args) {
    ClassStudent cs = new ClassStudent();
    cs.initDisplay();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn_search) {
      // 새로고침로직
      // 새로고침시 테이블 초기화

    } else if (obj == jbtn_lectureadd) {
      // 강의 추가 로직

    } else if (obj == jbtn_lecturedel) {
      // 수강 취소 로직
      // 테이블 선택시 선택한 과목 삭제

    } else if (obj == jbtn_cancel) {
      // 취소 로직
    }

  }
}
