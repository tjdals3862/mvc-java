package view_st;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.ClassDao;
import dto.ClassVO;
import dto.StudentVO;
import logic.ClassAddStudentLogic;
import logic.ClassStudentLogic;
import logic.GradeCheckProLogic;

public class ClassStudent extends JFrame implements ActionListener {
  JLabel jlb_title = null;
  JLabel jlb_semititle = null;
  public JButton jbtn_lectureadd = null;
  public JButton jbtn_lecturedel = null;
  public JButton jbtn_cancel = null;
  public JButton jbtn_search = null;

  Font f = null;
  ClassDao cd = null;
  String totals[] = { "전체" };

  String myLecture[] = null;

  String[] cols = { "수업명", "교수", "시간" };
  String[][] data = new String[0][0];
  public String[] lecturelist = null; // db에서 가져온 강의목록
  public DefaultTableModel dtm_grade = null;
  public JTable jtb_grade = null;
  JTableHeader jth_grade = null;
  JScrollPane jsp_grade = null;

  GradeCheckProLogic gsl = null;
  ClassStudentLogic csl = null;
  ClassAddStudentLogic casl = null;
  MainFormStudent mfs = null;

  StudentVO svo = null;
  Boolean tmp = false;

  public ClassStudent(StudentVO svo) {
    this.svo = svo;
  }

  public void initDisplay() {
    tmp = true;
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(null);

    dtm_grade = new DefaultTableModel(data, cols);
    jtb_grade = new JTable(dtm_grade);
    jth_grade = jtb_grade.getTableHeader();
    jsp_grade = new JScrollPane(jtb_grade, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    jlb_title = new JLabel("수업 관리");
    jlb_semititle = new JLabel("수업");
    jbtn_lectureadd = new JButton("수강신청");
    jbtn_lecturedel = new JButton("강의취소");
    jbtn_cancel = new JButton("취소");
    jbtn_search = new JButton("검색");

    csl = new ClassStudentLogic(this, svo);
    // =======================================여기....==============================
    gsl = new GradeCheckProLogic();
    casl = new ClassAddStudentLogic();
    //lecturelist = gsl.getLectureList();

    f = new Font("굴림체", Font.BOLD, 16);

    jlb_title.setFont(f);
    jlb_semititle.setFont(f);

    this.add(jsp_grade);
    this.add(jlb_semititle);
    this.add(jlb_title);
    this.add(jbtn_lectureadd);
    this.add(jbtn_lecturedel);
    this.add(jbtn_cancel);
    this.add(jbtn_search);

    jbtn_lectureadd.addActionListener(this);
    jbtn_lecturedel.addActionListener(this);
    jbtn_cancel.addActionListener(this);
    jbtn_search.addActionListener(this);

    jsp_grade.setBounds(0, 50, 490, 400);
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

  // public void addTableRow(Vector mycvo) {
  //   if (!tmp) {
  //     this.initDisplay();
  //   } else if (tmp) {
  //   }
  //   dtm_grade.addRow(mycvo);

    // // 가져온 데이터를 vector에 담아 한줄씩 넣어준다
    // for (int i = 0; i < mycvo.size(); i++) {
    // Vector<String> result = new Vector<>();
    // LectureVO gpvo = new LectureVO();
    // gpvo = mycvo.get(i);
    // result.add(gpvo.getLecture());
    // result.add(gpvo.getProfessor());
    // result.add(gpvo.getLectime());
    // classpro.dtm_grade.addRow(result);

  //}

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();

    if(obj == jbtn_search) {
      // 성적 검색 로직
       csl.gradeCheck();
      


    } else if (obj == jbtn_lectureadd) {
      // 수강신청으로 이동
      csl.lectureAddStudent();
      this.dispose();

    } else if (obj == jbtn_lecturedel) {
      // 수강 취소 로직
      // 테이블 선택시 선택한 과목 삭제
      csl.myLectureDelete();

    } else if (obj == jbtn_cancel) {
      // 취소 로직
      csl.cancel();
      mfs = new MainFormStudent(svo);
      mfs.initDisplay();
      this.dispose();
    }
  } 
}
