package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.LectureVO;
import util.MyBatisCommonFactory;

public class ClassDao {
  MyBatisCommonFactory mcf = new MyBatisCommonFactory();

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

}
