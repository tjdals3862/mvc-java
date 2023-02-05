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

  // 학생 회원가입
  public int signUpStudent() {
    int result = 0;
    // SqlSessionFactory sqlSessionFactory = null;
    // SqlSession sqlSession = null;
    // int result = 0;

    // try {
    // System.out.println("TEST!!!!");
    // sqlSessionFactory = mcf.getSqlSessionFactory();
    // sqlSession = sqlSessionFactory.openSession();
    // sqlSession.selectOne("signUpStudent", suvo);
    // result = 2;
    // } catch (Exception e) {
    // System.out.println("TEST@@@@");
    // result = 0;
    // }
    // System.out.println("RESULTS :::::: :: " + result);
    return result;
  }

  // 교수 회원가입
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
