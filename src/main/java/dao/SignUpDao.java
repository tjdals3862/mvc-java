package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.LoginVO;
import dto.ProfessorVO;
import dto.SignUpVO;
import dto.StudentVO;
import view.RegisterForm;

import util.MyBatisCommonFactory;

public class SignUpDao {
  MyBatisCommonFactory mcf = new MyBatisCommonFactory();
  SignUpVO suvo = null;

  // 학생 회원가입
  public int signUpStudent(SignUpVO suvo) {
    int result = 0;
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      sqlSession.selectOne("signUpStudent", suvo);
      result = 2; // 회원가입이 됐을 때 result값 2 ....? 오호라
    } catch (Exception e) {
      System.out.println(e.toString());
      result = 0; // 회원가입 오류
    } finally {
      sqlSession.commit();
      sqlSession.close();
    }
    return result;
  }

  // 교수 회원가입 ---- 아직 안건듬
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
    } finally {
      sqlSession.commit();
      sqlSession.close();
    }
    return professor;
  }
}