package view_st;

// 성적확인
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import logic.GradeCheckLogic;
import logic.GradeCheckProLogic;
import dao.ClassDao;
import dao.GradeCheckDao;
import dto.LectureVO;

public class GradeCheck extends JFrame implements ActionListener {
  JLabel jlb_title = null;
  JLabel jlb_semititle = null;
  JComboBox jcb_lecture = null;
  public JButton jbtn_search = null;
  public JButton jbtn_add = null;
  public JButton jbtn_cancle = null;
  Font f = null;
  ClassDao cd = null;
  GradeCheckDao gcd = null;
  GradeCheckProLogic gsl = null;

  String totals[] = { "전체" };
  public String[] lecturelist = null; // db에서 가져온 강의목록

  String[] cols = { "수업명", "교수", "시간", "성적" };
  String[][] data = new String[3][3];
  DefaultTableModel dtm_grade = null;
  JTable jtb_grade = null;
  JTableHeader jth_grade = null;
  JScrollPane jsp_grade = null;
  GradeCheckLogic gsc = null;

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

    // 여기...................................
    gsl = new GradeCheckProLogic();
    lecturelist = gsl.getLectureList();
    jcb_lecture = new JComboBox(lecturelist);

    // jcb_lecture = new JComboBox(totals);

    //////////////////////////////////////////////

    // jbtn_search = new JButton("검색");
    // jbtn_add = new JButton("추가");
    jbtn_cancle = new JButton("취소");

    this.add(jsp_grade);
    this.add(jlb_title);
    this.add(jlb_semititle);
    this.add(jcb_lecture);
    // this.add(jbtn_search);
    // this.add(jbtn_add);
    this.add(jbtn_cancle);

    jsp_grade.setBounds(0, 100, 490, 350);
    jlb_title.setBounds(250, 15, 250, 35);
    jlb_semititle.setBounds(150, 60, 100, 30);
    jcb_lecture.setBounds(245, 60, 245, 30);
    // jbtn_search.setBounds(500, 60, 100, 30);
    // jbtn_add.setBounds(500, 130, 100, 30);
    jbtn_cancle.setBounds(500, 200, 100, 30);

    this.setTitle("학사관리 프로그램");
    this.setLocation(500, 100);
    this.setSize(630, 400);
    this.setVisible(true);
    this.setResizable(false);

    // jbtn_search.addActionListener(this);
    jbtn_cancle.addActionListener(this);
    jcb_lecture.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cd = new ClassDao();
        gcd = new GradeCheckDao();
        List<LectureVO> gradelist = gcd.getLectureList2(jcb_lecture.getSelectedItem().toString());

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
          result.add(gpvo.getCredit());

          dtm_grade.addRow(result);
        }
      }
    });
  }

  public static void main(String[] args) {
    GradeCheck gc = new GradeCheck();
    gc.initDisplay();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();

    if (obj == jbtn_search) {
      // 검색 로직
      // 과목에 대한 성적을 출력하며
      // 전체 과목일시 해당 학생의 전체 성적 출력하도록 설정
    } else if (obj == jbtn_cancle) {
      this.dispose();

    }
  }
}
