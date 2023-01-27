package logic;

import java.util.List;
import java.util.Vector;

import dao.GradeCheckDao;
import dto.GradeProVO;
import dto.ProfessorVO;
import view_pro.GradeCheckPro;
import view_pro.Inputgrade;
import view_pro.MainFormPro;

public class GradeCheckProLogic {

  String[] gradearr = null;
  String[] leclist = null;
  GradeCheckDao gcd = null;
  GradeCheckPro gcp = null;
  Inputgrade input = null;
  MainFormPro main = null;
  String lecture = null;
  ProfessorVO pvo = null;

  public GradeCheckProLogic() {

  }

  public GradeCheckProLogic(GradeCheckPro gradecheckPro, ProfessorVO pvo) {
    this.gcp = gradecheckPro;
    this.pvo = pvo;
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

  // 성적 입력 버튼
  public void add() {
    input = new Inputgrade();
    input.initDisplay();
  }

  // 취소 버튼
  public void cancel() {
    main = new MainFormPro(pvo);
    main.initDisplay();
  }

}
