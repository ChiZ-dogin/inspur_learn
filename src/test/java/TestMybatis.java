import org.testng.annotations.Test;
import projtest.mapper.PersonMapper;

import java.io.IOException;
import java.io.InputStream;

/*
测一个对象sqlSession，需要通过sqlSessionFactor（）对象才能创建sqlSession。
sqlSessionFactor（）需要通过sqlSessionFactor（）Builder（）来创建出来。
 */
public class TestMybatis {
    @Test
    public void testHelloWorld() throws IOException {
        //1.通过流的机制获取主配置文件mybatis-config.xml的主要配置信息
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //2.实例化SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.调用builder对象的builder（）方法，获取SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //4.调用factory对象的openSession()方法，获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //5.调用接口的方法
        Integer count = sqlSession.getMapper(PersonMapper.class).findCount();
        //6.输出对应的返回值count
        System.out.println("count:" + count);
        //7.关闭 SqlSession
        sqlSession.close();
    }
}
