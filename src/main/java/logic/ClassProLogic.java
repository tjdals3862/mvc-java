package logic;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.ClassDao;
import dao.GradeCheckDao;
import dto.LectureVO;
import dto.ProfessorVO;
import util.MyBatisCommonFactory;
import view_pro.ClassAdd;
import view_pro.ClassPro;
import view_pro.MainFormPro;

public class ClassProLogic {

  MyBatisCommonFactory mcf = new MyBatisCommonFactory();
  ClassPro classpro = null;
  String[] proarr = null;
  GradeCheckDao gcd = null;
  ClassDao cd = null;

  private String professor = null;
  private String lecture = null;
  private String lectime = null;
  ProfessorVO pvo = null;

  public ClassProLogic() {

  }

  public ClassProLogic(ClassPro classpro, ProfessorVO pvo) {
    this.classpro = classpro;
    this.pvo = pvo;
  }

  public String[] getProList() {
    gcd = new GradeCheckDao();
    List<String> prolist = gcd.getProList();
    proarr = new String[prolist.size()];

    // list로 가져온 결과를 배열로 초기화
    for (int i = 0; i < proarr.length; i++) {
      proarr[i] = prolist.get(i);
    }
    return proarr;
  }

  public List<LectureVO> getgradeproList(String professor) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    List<LectureVO> LectureList = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      LectureList = sqlSession.selectList("getLecture", professor);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return LectureList;
  }

  public void getProfessor(String professor) {
    cd = new ClassDao();
    List<LectureVO> gradelist = cd.getLecture(professor);

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
      classpro.dtm_grade.addRow(result);
    }
  }

  // 선택한 강의 삭제
  public void lecturedel() {
    cd = new ClassDao();
    int row = classpro.jtb_grade.getSelectedRow();
    lecture = (String) classpro.dtm_grade.getValueAt(row, 0);
    professor = (String) classpro.dtm_grade.getValueAt(row, 1);
    lectime = (String) classpro.dtm_grade.getValueAt(row, 2);
    LectureVO gpvo = new LectureVO(lecture, professor, lectime);
    int result = cd.getdellecture(gpvo);
    if (result == 1) {
      JOptionPane.showMessageDialog(classpro, "강의 삭제 완료", "Success", 1);
      classpro.dtm_grade.removeRow(row);
    }

  }

  public void lectureadd() {
    ClassAdd cal = new ClassAdd();
    cal.initDisplay();
  }

  public void cancel() {
    MainFormPro main = new MainFormPro(pvo);
    main.initDisplay();
    classpro.dispose();
  }

}
