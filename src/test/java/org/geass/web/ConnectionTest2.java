package org.geass.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.geass.persistence.TimeDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ConnectionTest2 {

 private static Logger logger = Logger.getLogger(ConnectionTest2.class);

 
 
 	@Autowired
 	private DataSource ds;
 
 	
 	@Inject
 	ApplicationContext ctx;
 	
 	@Inject
 	SqlSessionFactory sqlFactory;
 	
 	@Inject
 	TimeDAO dao;
 	
 	@Test
	public void testGetTime(){
		logger.info("=========================================================");
		logger.info(dao.getTime());
		logger.info("=========================================================");
	}
 	
 	
 	@Test
 	public void testSession(){
 		
 		SqlSession sess = sqlFactory.openSession();
 		
 		logger.info(sess + "++++++++++++++++++++++");
 		String time = sess.selectOne("org.geass.TimeMapper.getTime");
 		logger.info("=======================");
		logger.info(time);
		logger.info("=======================");
		
		sess.close();
 		
 	}
 	
 	@Test
 	public void testCtx(){
 		logger.info(ctx);
 		
 		Object obj = ctx.getBean("sqlSessionFactory");
 		
 	}	
 	
 	
 	@Test
 	public void testLoading(){
 		
 		logger.info("test loading");
 		logger.info(ds);
 		
 		try(Connection con = ds.getConnection()){
 			
 			logger.info(con);
 		}catch (Exception e) {
			
		}	
 	}
	
}
