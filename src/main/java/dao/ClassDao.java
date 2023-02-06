package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ClassVO;
import dto.GradeVO;
import dto.LectureVO;
import dto.StudentVO;
import util.MyBatisCommonFactory;

public class ClassDao {
  MyBatisCommonFactory mcf = new MyBatisCommonFactory();

    // 강의  조회(학생)
    public List<ClassVO> getclassstuent(StudentVO svo) {
      SqlSessionFactory sqlSessionFactory = null;
      SqlSession sqlSession = null;
      List<ClassVO> classList = null;
      try {
        sqlSessionFactory = mcf.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        classList = sqlSession.selectList("getclassstuent", svo);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return classList;
    }  

    // 강의 신청시 학생 중복 체크
    public int studentdepulicatecheck(GradeVO gvo) {
      int result = -1;
      SqlSessionFactory sqlSessionFactory = null;
      SqlSession sqlSession = null;
      List<GradeVO> classList = null;
      try {
        sqlSessionFactory = mcf.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        classList = sqlSession.selectList("studentdepulicatecheck", gvo);
      } catch (Exception e) {
        e.printStackTrace();
      }
      result = classList.size();
      return result;
    }  



  // 강의 목록 조회(교수에 해당하는 강의 조회)
  public List<LectureVO> getLecture(String Professor) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    List<LectureVO> gradeList = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      gradeList = sqlSession.selectList("getLecture", Professor);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return gradeList;
  }

  // 강의 목록 조회(강의명.....에 해당하는 강의 조회)
  public List<LectureVO> getLecture2(String lecture) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    List<LectureVO> totalLectureList = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      totalLectureList = sqlSession.selectList("getTotalLecture", lecture);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return totalLectureList;
  }


  // 강의 목록 조회(교수별 강의 조회)
  public List<LectureVO> getLecture3(String lecture) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    List<LectureVO> totalLectureList = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      totalLectureList = sqlSession.selectList("getProTotalLecture", lecture);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return totalLectureList;
  }

  // 강의 추가(교수)
  // 성공시 1을 return 함
  public int getinsertlecture(LectureVO lVO) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    int id = -1;

    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      id = sqlSession.insert("getinsertlecture", lVO);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.commit();
      sqlSession.close();
    }
    return id;
  }

  // 수강 신청 (학생)
    // 성공시 1을 return 함
  public int getinsertlecturestudent(GradeVO GVO) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    int id = -1;

    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      id = sqlSession.insert("getinsertlecturestudent", GVO);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.commit();
      sqlSession.close();
    }
    return id;
  }



  // 강의 추가(삭제)
  // 성공시 1을 return 함
  public int getdellecture(LectureVO lVO) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    int id = -1;

    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      id = sqlSession.delete("getdellecture", lVO);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.commit();
      sqlSession.close();
    }
    return id;
  }

    // 강의 삭제 학생
  // 성공시 1을 return 함
  public int getdellecturestudent(GradeVO GVO) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    int id = -1;

    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      id = sqlSession.delete("getdellecturestudent", GVO);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.commit();
      sqlSession.close();
    }
    return id;
  }
}
