package view_st;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logic.ClassAddStudentLogic;
import logic.ClassStudentLogic;

public class ClassAddStudent extends JFrame implements ActionListener {
  JLabel jlb_title = null;
  JLabel jlb_semititle = null;
  JButton jbtn_search = null;
  JButton jbtn_lectureadd = null;
  JButton jbtn_cancel = null;
  JComboBox jcb_professor = null;
  Font f = null;

  String totals[] = { "전체" };
  String[] cols = { "수업명", "교수", "시간" };
  String[][] data = new String[0][0];
  public String[] prolist = null; // db에서 가져온 강의목록
  public DefaultTableModel dtm_grade = null;
  public JTable jtb_grade = null;
  JTableHeader jth_grade = null;
  JScrollPane jsp_grade = null;

  ClassAddStudentLogic casl = null;

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(null);

    dtm_grade = new DefaultTableModel(data, cols);
    jtb_grade = new JTable(dtm_grade);
    jth_grade = jtb_grade.getTableHeader();
    jsp_grade = new JScrollPane(jtb_grade, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    jbtn_search = new JButton("검색");
    jlb_title = new JLabel("수강 신청");
    jlb_semititle = new JLabel("교수");
    jbtn_lectureadd = new JButton("수강신청");
    jbtn_cancel = new JButton("취소");

    casl = new ClassAddStudentLogic(this);
    // prolist = gsl.getProList();
    // totals 대신 db에서 가져온값을 담아 줘야함 53처럼 값을 가져와 아래 totals대신 추가
    jcb_professor = new JComboBox(totals);
    f = new Font("굴림체", Font.BOLD, 16);

    jlb_title.setFont(f);
    jlb_semititle.setFont(f);

    this.add(jsp_grade);
    this.add(jlb_semititle);
    this.add(jlb_title);
    this.add(jbtn_search);
    this.add(jbtn_lectureadd);
    this.add(jbtn_cancel);
    this.add(jcb_professor);

    jbtn_search.addActionListener(this);
    jbtn_lectureadd.addActionListener(this);
    jbtn_cancel.addActionListener(this);

    jcb_professor.setBounds(245, 60, 240, 30);
    jsp_grade.setBounds(0, 100, 490, 350);
    jlb_title.setBounds(250, 10, 250, 30);
    jlb_semititle.setBounds(150, 60, 100, 30);
    jbtn_search.setBounds(500, 60, 100, 30);
    jbtn_lectureadd.setBounds(500, 130, 100, 30);
    jbtn_cancel.setBounds(500, 200, 100, 30);

    this.setTitle("수강 신청/학생");
    this.setLocation(500, 100);
    this.setSize(630, 400);
    this.setVisible(true);
    this.setResizable(false);

  }

  public static void main(String[] args) {
    ClassAddStudent cas = new ClassAddStudent();
    cas.initDisplay();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn_search) {
      // 검색기능 로직
      // 교수선택후 검색시 해당 교수의 과목이 나오도록 설정

    } else if (obj == jbtn_lectureadd) {
      // 수강신청
      // 선택한 과목을 추가
      // 이미 추가한 과목일시 error message

    } else if (obj == jbtn_cancel) {
      // 취소버튼 => 이전 페이지로 이동
    }
  }
}
