package logic;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import dao.ClassDao;
import dto.ClassVO;
import dto.GradeVO;
import dto.StudentVO;
import view_st.ClassAddStudent;
import view_st.ClassStudent;
import view_st.MainFormStudent;

public class ClassStudentLogic {

  ClassStudent classStudent = null;
  ClassAddStudent classAddStudent = null;
  ClassDao cd = null;
  private String lecture = null;
  private String lectime = null;
  private String professor = null;

  MainFormStudent mainFormStudent = null;
  StudentVO svo = null;

  public ClassStudentLogic() {

  }

  public ClassStudentLogic(ClassStudent classStudent, StudentVO svo) {
    this.classStudent = classStudent;
    this.svo = svo;
  }


  //성적 검색 로직
  public void gradeCheck() {
    cd = new ClassDao();
    List<ClassVO> classList = cd.getclassstuent(svo);
    
    // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제함
    while (classStudent.dtm_grade.getRowCount() > 0) {
      classStudent.dtm_grade.removeRow(0);
    }

    // 가져온 데이터를 vector에 담아 한줄씩 넣어준다
    for (int i = 0; i < classList.size(); i++) {
      Vector<String> result = new Vector<>();
      ClassVO gpvo = new ClassVO();
      gpvo = classList.get(i);
      result.add(gpvo.getLecture());
      result.add(gpvo.getProfessor());
      result.add(gpvo.getLectime());
      classStudent.dtm_grade.addRow(result);
    }
  }

  // 강의 추가로 이동
  public void lectureAddStudent() {
    classAddStudent = new ClassAddStudent(svo);
    classAddStudent.initDisplay();
  }

  // 취소 - 메인으로 돌아가기....
  public void cancel() {
    mainFormStudent = new MainFormStudent(svo);
    mainFormStudent.initDisplay();
  }

  // 삭제 ===========================
  public void myLectureDelete() {
    cd = new ClassDao();
    int row = classStudent.jtb_grade.getSelectedRow();
    lecture = (String) classStudent.dtm_grade.getValueAt(row, 0);
    professor = (String) classStudent.dtm_grade.getValueAt(row, 1);
    lectime = (String) classStudent.dtm_grade.getValueAt(row, 2);

    GradeVO gvo = new GradeVO(lecture, svo.getStudentname());   
    int result = cd.getdellecturestudent(gvo);
    if(result == 1) {
      JOptionPane.showMessageDialog(classStudent, "강의 삭제 완료", "Success", 1);
      classStudent.dtm_grade.removeRow(row);
    } else {
      System.out.println("error");
    }
  }
}
