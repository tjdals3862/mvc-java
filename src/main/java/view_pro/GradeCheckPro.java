package view_pro;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logic.GradeCheckProLogic;

public class GradeCheckPro extends JFrame {
  JLabel jlb_title = null;
  JLabel jlb_semititle = null;
  public JComboBox jcb_lecture = null;
  public JButton jbtn_search = null;
  public JButton jbtn_add = null;
  public JButton jbtn_cancle = null;
  Font f = null;

  String totals[] = { "전체" };
  String[] cols = { "수업명", "교수", "학생명", "시간", "성적" };
  String[][] data = new String[0][0];
  public String[] lecture = null; // db에서 가져온 강의목록
  public DefaultTableModel dtm_grade = null;
  JTable jtb_grade = null;
  JTableHeader jth_grade = null;
  JScrollPane jsp_grade = null;

  GradeCheckProLogic gcpl = null;

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(null);

    dtm_grade = new DefaultTableModel(data, cols);
    jtb_grade = new JTable(dtm_grade);
    jth_grade = jtb_grade.getTableHeader();
    jsp_grade = new JScrollPane(jtb_grade, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    jlb_title = new JLabel("성적확인");
    jlb_semititle = new JLabel("수업");
    f = new Font("굴림체", Font.BOLD, 16);

    jlb_title.setFont(f);
    jlb_semititle.setFont(f);

    gcpl = new GradeCheckProLogic(this);
    lecture = gcpl.getLectureList();
    jcb_lecture = new JComboBox(lecture);

    jbtn_search = new JButton("검색");
    jbtn_add = new JButton("성적입력");
    jbtn_cancle = new JButton("취소");

    this.add(jsp_grade);
    this.add(jlb_title);
    this.add(jlb_semititle);
    this.add(jcb_lecture);
    this.add(jbtn_search);
    this.add(jbtn_add);
    this.add(jbtn_cancle);

    jbtn_search.addActionListener(gcpl);
    jbtn_add.addActionListener(gcpl);
    jbtn_cancle.addActionListener(gcpl);

    jsp_grade.setBounds(0, 100, 490, 350);
    jlb_title.setBounds(250, 15, 250, 35);
    jlb_semititle.setBounds(150, 60, 100, 30);
    jcb_lecture.setBounds(245, 60, 245, 30);
    jbtn_search.setBounds(500, 60, 100, 30);
    jbtn_add.setBounds(500, 130, 100, 30);
    jbtn_cancle.setBounds(500, 200, 100, 30);

    this.setTitle("학사관리 프로그램");
    this.setLocation(500, 100);
    this.setSize(630, 400);
    this.setVisible(true);

  }

  public static void main(String[] args) {
    GradeCheckPro gcp = new GradeCheckPro();

    gcp.initDisplay();
  }
}