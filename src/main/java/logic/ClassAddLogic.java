package logic;

import javax.swing.JOptionPane;

import dao.ClassDao;
import dto.LectureVO;
import util.MyBatisCommonFactory;
import view_pro.ClassAdd;

public class ClassAddLogic {

  MyBatisCommonFactory mcf = new MyBatisCommonFactory();
  ClassAdd ca = null;
  ClassDao cd = null;
  LectureVO lvo = null;
  String lecture = null;
  String professor = null;
  String lectime = null;

  public ClassAddLogic() {

  }

  public ClassAddLogic(ClassAdd ca) {
    this.ca = ca;
  }

  // 강의 추가
  public int add(String lecture, String professor, String lectime) {
    cd = new ClassDao();

    // 가져온 데이터를 dto를 통해 생성후 파라미터로 전달
    lvo = new LectureVO(lecture, professor, lectime);
    int result = cd.getinsertlecture(lvo);

    return result;
  }

}
