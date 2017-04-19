package org.geass.persistence;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TimeDAO {

	@Inject
	private SqlSessionTemplate sess;
	
	public String getTime(){
		return sess.selectOne("org.geass.TimeMapper.getTime");
	
	} 
	
	
	
}
