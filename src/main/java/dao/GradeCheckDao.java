package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.GradeCheckVO;
import dto.GradeProVO;
import dto.LectureVO;
import util.MyBatisCommonFactory;

public class GradeCheckDao {
  MyBatisCommonFactory mcf = new MyBatisCommonFactory();

  // 강의 조회(전체 강의)
  public List<String> getLectureList() {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    List<String> lecList = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      lecList = sqlSession.selectList("getLectureList");
      // System.out.println(memList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return lecList;
  }

  // 교수 조회
  public List<String> getProList() {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    List<String> proList = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      proList = sqlSession.selectList("getProList");
      // System.out.println(memList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return proList;
  }



  // 강의 성적 조회(교수)
  public List<GradeProVO> getgradeproList(String lecture) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    List<GradeProVO> gradeList = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      gradeList = sqlSession.selectList("getgradeproList", lecture);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return gradeList;
  }

  // 성적조회 -- 수정중
  public List<LectureVO> getLectureList2(GradeCheckVO gcvo) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    List<LectureVO> lecList = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      lecList = sqlSession.selectList("getMyGrade", gcvo);
      System.out.println(lecList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return lecList;
  }

}
