package view_pro;

// 수업관리/교수
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

import dto.ProfessorVO;
import logic.ClassProLogic;

public class ClassPro extends JFrame implements ActionListener {

  private JLabel jlb_title = null;
  private JLabel jlb_semititle = null;
  private JButton jbtn_search = null;
  private JButton jbtn_lectureadd = null;
  private JButton jbtn_lecturedel = null;
  private JButton jbtn_cancel = null;
  private JComboBox jcb_professor = null;
  Font f = null;

  private String totals[] = { "전체" };
  private String[] cols = { "수업명", "교수", "시간" };
  private String[][] data = new String[0][0];

  public String[] prolist = null; // db에서 가져온 강의목록
  public DefaultTableModel dtm_grade = null;
  public JTable jtb_grade = null;
  JTableHeader jth_grade = null;
  JScrollPane jsp_grade = null;

  ClassProLogic cpl = null;
  ProfessorVO pvo = null;

  public ClassPro(ProfessorVO pvo) {
    this.pvo = pvo;
  }

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(null);

    dtm_grade = new DefaultTableModel(data, cols);
    jtb_grade = new JTable(dtm_grade);
    jth_grade = jtb_grade.getTableHeader();
    jsp_grade = new JScrollPane(jtb_grade, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    jbtn_search = new JButton("검색");
    jlb_title = new JLabel("수업 관리");
    jlb_semititle = new JLabel("수업");
    jbtn_lectureadd = new JButton("강의추가");
    jbtn_lecturedel = new JButton("강의삭제");
    jbtn_cancel = new JButton("취소");

    cpl = new ClassProLogic(this, pvo);
    prolist = cpl.getProList();
    jcb_professor = new JComboBox(prolist);
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

    this.setTitle("수업 관리/교수");
    this.setLocation(500, 100);
    this.setSize(630, 400);
    this.setVisible(true);
    this.setResizable(false);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();

    if (obj == jbtn_search) {
      // 검색 로직
      String professor = prolist[jcb_professor.getSelectedIndex()];
      cpl.getProfessor(professor);
    } else if (obj == jbtn_lectureadd) {
      // 강의 추가
      cpl.lectureadd();
    } else if (obj == jbtn_cancel) {
      // 강의 취소(이전페이지로 이동)
      cpl.cancel();
    } else if (obj == jbtn_lecturedel) {
      // 강의 삭제
      cpl.lecturedel();
    }
  }

}
