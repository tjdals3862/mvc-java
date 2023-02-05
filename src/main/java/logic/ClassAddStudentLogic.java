package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import dao.ClassDao;
import dao.GradeCheckDao;
import dto.LectureVO;
import dto.StudentVO;
import view_pro.ClassPro;
import view_st.ClassAddStudent;
import view_st.ClassStudent;

public class ClassAddStudentLogic {

  ClassAddStudent cas = null;
  ClassDao cd = null;
  ClassPro classpro = null;
  String[] leclist = null;
  StudentVO svo = null;
  GradeCheckDao gcd = null;
  ClassStudent classStudent = null;
  // ClassAddStudent classAddStudent = null;
  private String lecture = null;
  private String lectime = null;
  private String professor = null;

  public ClassAddStudentLogic() {

  }

  public ClassAddStudentLogic(ClassAddStudent cas) {
    this.cas = cas;
  }

  public void getTotalLectureList(String lecture) {
    cd = new ClassDao();
    List<LectureVO> gradelist = cd.getLecture2(lecture);

    // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제함
    while (classpro.dtm_grade.getRowCount() > 0) {
      classpro.dtm_grade.removeRow(0);
    }

    // 가져온 데이터를 vector에 담아 한줄씩 넣어준다
    for (int i = 0; i < gradelist.size(); i++) {
      Vector<String> result = new Vector<>();
      LectureVO gpvo = new LectureVO();
      gpvo = gradelist.get(i);
      result.add(gpvo.getLecture());
      result.add(gpvo.getProfessor());
      result.add(gpvo.getLectime());
      // classpro.dtm_grade.addRow(result);
      System.out.println("gpvo ::::: " + gpvo);
      System.out.println(result);
    }
  }

  public String[] getLectureList() {
    gcd = new GradeCheckDao();
    List<String> lectureList = gcd.getLectureList();
    leclist = new String[lectureList.size()];

    for (int i = 0; i < leclist.length; i++) {
      leclist[i] = lectureList.get(i);

    }

    return leclist;
  }

  // 강의 선택해서 담기 ===========수정중
  public void myLectureSelect(ClassStudent classStudent) {

    int row = cas.jtb_grade.getSelectedRow();
    lecture = (String) cas.dtm_grade.getValueAt(row, 0);
    professor = (String) cas.dtm_grade.getValueAt(row, 1);
    lectime = (String) cas.dtm_grade.getValueAt(row, 2);
    Vector<String> mycvo = new Vector<>();
    mycvo.add(lecture);
    mycvo.add(professor);
    mycvo.add(lectime);

    classStudent.addTableRow(mycvo);

    JOptionPane.showMessageDialog(cas, "강의 담기 완료", "Success", 1);
    System.out.println(lecture);

    // }
  }
}
