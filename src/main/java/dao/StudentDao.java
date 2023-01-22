package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.GradeVO;
import util.MyBatisCommonFactory;

public class StudentDao {
  MyBatisCommonFactory mcf = new MyBatisCommonFactory();

  // 학생 조회(강의에 해당하는 학생 조회)
  public List<String> getstudentList(String lecture) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    List<String> studentlist = null;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      studentlist = sqlSession.selectList("getstudentList", lecture);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return studentlist;
  }

  // 성적 수정
  // 성공시 1을 return 함
  public int getgrade(GradeVO gVO) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    int id = -1;
    try {
      sqlSessionFactory = mcf.getSqlSessionFactory();
      sqlSession = sqlSessionFactory.openSession();
      id = sqlSession.update("getupdategrade", gVO);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.commit();
      sqlSession.close();
    }
    return id;
  }

  public static void main(String[] args) {
    StudentDao st = new StudentDao();
    List<String> studentlist = st.getstudentList("자바");

    System.out.println(studentlist);
  }
}
