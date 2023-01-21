package util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisCommonFactory {

  public SqlSessionFactory sqlSessionFactory = null;

  public void init() {
    try {
      String resource = "config/MyBatisConfig.xml";
      Reader reader = Resources.getResourceAsReader(resource);

      if (sqlSessionFactory == null) {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
      }
    } catch (Exception e) {
    }
  } // end of init

  public SqlSessionFactory getSqlSessionFactory() {
    init();
    return sqlSessionFactory;
  }
}
