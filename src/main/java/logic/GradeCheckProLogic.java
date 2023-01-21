package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import dao.GradeCheckDao;
import dto.GradeProVO;
import view_pro.GradeCheckPro;
import view_pro.Inputgrade;
import view_pro.MainFormPro;

public class GradeCheckProLogic implements ActionListener {

  String[] gradearr = null;
  String[] leclist = null;
  GradeCheckDao gcd = null;
  GradeCheckPro gcp = null;
  Inputgrade input = null;
  MainFormPro main = null;
  String lecture = null;

  public GradeCheckProLogic() {

  }

  public GradeCheckProLogic(GradeCheckPro gradecheckPro) {
    this.gcp = gradecheckPro;
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

  public void getLecture(String lecture) {
    List<GradeProVO> gradelist = gcd.getgradeproList(lecture);

    // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제함
    while (gcp.dtm_grade.getRowCount() > 0) {
      gcp.dtm_grade.removeRow(0);
    }

    for (int i = 0; i < gradelist.size(); i++) {
      Vector<String> result = new Vector<>();
      GradeProVO gpvo = new GradeProVO();
      gpvo = gradelist.get(i);
      result.add(gpvo.getLecture());
      result.add(gpvo.getProfessor());
      result.add(gpvo.getStudentName());
      result.add(gpvo.getLectime());
      result.add(Integer.toString(gpvo.getCredit()));
      gcp.dtm_grade.addRow(result);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();

    if (obj == gcp.jbtn_search) {
      // 검색 logic 작성
      lecture = gcp.lecture[gcp.jcb_lecture.getSelectedIndex()];
      getLecture(lecture);
    } else if (obj == gcp.jbtn_add) {
      input = new Inputgrade();
      input.initDisplay();
    } else if (obj == gcp.jbtn_cancle) {
      main = new MainFormPro();
      main.initDisplay();
      gcp.dispose();
    }
  }
}
