package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ProfessorVO;
import dto.SignUpVO;
import dto.SignUpproVO;
import util.MyBatisCommonFactory;

public class SignUpDao {
  MyBatisCommonFactory mcf = new MyBatisCommonFactory();

  // 학생 회원가입
  public int signUpStudent(SignUpVO suvo) {    
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    int result = -1;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      result = sqlSession.insert("signUpStudent", suvo);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.commit();
      sqlSession.close();
    }
    return result;
  }

  // 교수 회원가입 
  public int signUpProfessor(SignUpproVO supvo) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    int result = -1;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      result = sqlSession.insert("signUpProfessor", supvo);
      System.out.println("======================");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.commit();
      sqlSession.close();
    }
    return result;
  }
}