package view_st;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logic.ClassProLogic;
import dao.ClassDao;
import dto.LectureVO;
import dto.StudentVO;
import logic.ClassAddStudentLogic;

public class ClassAddStudent extends JFrame implements ActionListener {
  JLabel jlb_title = null;
  JLabel jlb_semititle = null;
  JButton jbtn_search = null;
  JButton jbtn_lectureadd = null;
  JButton jbtn_cancel = null;
  JComboBox jcb_lecture = null;
  Font f = null;
  ClassDao cd = null;
  ClassProLogic cpl = null;

  String totals[] = { "전체" };
  String[] cols = { "수업명", "교수", "시간" };
  String[][] data = new String[0][0];
  public String[] lecturelist = null; // db에서 가져온 강의목록

  public String[] prolist = null; // db에서 가져온 강의목록

  public DefaultTableModel dtm_grade = null;
  public JTable jtb_grade = null;
  JTableHeader jth_grade = null;
  JScrollPane jsp_grade = null;

  ClassAddStudentLogic casl = null;
  StudentVO svo = null;

  public ClassAddStudent(StudentVO svo) {
    this.svo = svo;
  }

  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(null);

    dtm_grade = new DefaultTableModel(data, cols);
    jtb_grade = new JTable(dtm_grade);
    jth_grade = jtb_grade.getTableHeader();
    jsp_grade = new JScrollPane(jtb_grade, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    jbtn_search = new JButton("나는 장식");
    jlb_title = new JLabel("수강 신청");
    jlb_semititle = new JLabel("교수");
    jbtn_lectureadd = new JButton("수강신청");
    jbtn_cancel = new JButton("취소");

    casl = new ClassAddStudentLogic(this);
    // prolist = gsl.getProList();
    // totals 대신 db에서 가져온값을 담아 줘야함 53처럼 값을 가져와 아래 totals대신 추가
    // jcb_professor = new JComboBox(totals);
    f = new Font("굴림체", Font.BOLD, 16);

    // casl = new ClassAddStudentLogic();
    // lecturelist = casl.getLectureList();
    cpl = new ClassProLogic();
    prolist = cpl.getProList();

    jcb_lecture = new JComboBox(prolist);
    jlb_title.setFont(f);
    jlb_semititle.setFont(f);

    this.add(jsp_grade);
    this.add(jlb_semititle);
    this.add(jlb_title);
    this.add(jbtn_search);
    this.add(jbtn_lectureadd);
    this.add(jbtn_cancel);
    this.add(jcb_lecture);

    jbtn_search.addActionListener(this);
    jbtn_lectureadd.addActionListener(this);
    jbtn_cancel.addActionListener(this);
    jcb_lecture.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cd = new ClassDao();
        List<LectureVO> gradelist = cd.getLecture3(jcb_lecture.getSelectedItem().toString());

        // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제함
        while (dtm_grade.getRowCount() > 0) {
          dtm_grade.removeRow(0);
        }

        // 가져온 데이터를 vector에 담아 한줄씩 넣어준다
        for (int i = 0; i < gradelist.size(); i++) {
          Vector<String> result = new Vector<>();
          LectureVO gpvo = new LectureVO();
          gpvo = gradelist.get(i);
          result.add(gpvo.getLecture());
          result.add(gpvo.getProfessor());
          result.add(gpvo.getLectime());
          dtm_grade.addRow(result);
        }
      }
    });

    // =========================여기건드는중================
    // int row = dtm_grade.getSelectedRow();
    // int col = dtm_grade.getSelectedColumn();
    // Object value = dtm_grade.getValueAt(row, col);

    // =========================여기건드는중================

    jcb_lecture.setBounds(245, 60, 240, 30);
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

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn_search) {
      // 위에 jcb에 익명클래스로 붙임.....

    } else if (obj == jbtn_lectureadd) {
      // 수강신청
      // 선택한 과목을 추가

      // 이미 추가한 과목일시 error message
      casl.myLectureSelect();
    } else if (obj == jbtn_cancel) {
      // 취소버튼 => 이전 페이지로 이동
      this.dispose();
    }
  }
}
