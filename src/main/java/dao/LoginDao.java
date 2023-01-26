package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.LoginVO;
import dto.ProfessorVO;
import dto.StudentVO;
import util.MyBatisCommonFactory;

public class LoginDao {
  MyBatisCommonFactory mcf = new MyBatisCommonFactory();

  // 학생 로그인 체크
  public StudentVO loginstudent(LoginVO lvo) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    StudentVO student = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      student = sqlSession.selectOne("loginstudent", lvo);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return student;
  }

  // 교수 로그인 체크
  public ProfessorVO loginprofessor(LoginVO lvo) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    ProfessorVO professor = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      professor = sqlSession.selectOne("loginprofessor", lvo);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return professor;
  }

}
