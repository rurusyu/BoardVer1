package org.geass.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Delete;
import org.apache.log4j.Logger;
import org.geass.domain.BoardVO;
import org.geass.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardDAOTest {

	private static Logger logger = Logger.getLogger(BoardDAOTest.class);
	
	@Inject
	BoardDAO dao;
	
	
	@Test
	public void delete(){
		
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		dao.delete(vo);
		
	}
	
	@Test
	public void update(){
		BoardVO vo = new BoardVO();
		vo.setTitle("잘자욧");
		vo.setContent("안녕ㅋㅋ");
		vo.setBno(4);
		
		dao.update(vo);
	}
	
	@Test
	public void insert(){
		
		BoardVO vo = new BoardVO();
		vo.setTitle("잘자라");
		vo.setContent("안녕");
		
		dao.insert(vo);
	
	}
	
	@Test
	public void read(){
		
		List<BoardVO> list = dao.read();
		
		logger.info(list + "=====================================");
	}
}
