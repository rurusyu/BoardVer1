package org.geass.persistence;

import java.util.List;

import javax.inject.Inject;

import org.geass.domain.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Inject
	private SqlSessionTemplate sess; // 상속빼기
	
	public void insert(BoardVO vo){
		
		sess.insert("org.geass.persistence.BoardDAO.insert", vo);  //파라미터, 리턴타입 다름. 네임스페이스 다름.
		
	}
	
	public List<BoardVO> read(){
		return sess.selectList("org.geass.persistence.BoardDAO.read");

	}
	
	public void update(BoardVO vo){
		
		sess.update("org.geass.persistence.BoardDAO.update", vo);
	}
	
	public void delete(BoardVO vo){
		sess.delete("org.geass.persistence.BoardDAO.delete", vo);
		
	}
}
