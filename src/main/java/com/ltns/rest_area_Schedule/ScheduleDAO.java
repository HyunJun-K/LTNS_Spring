package com.ltns.rest_area_Schedule;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.ltns.rest_area_Schedule.ScheduleDAO";
	
	
	public List<ScheduleDTO> showSchedule(){
		return sqlSession.selectList(namespace + ".showSchedule");
		
	}
	
	public void addSchedule(ScheduleDTO dto) {
		sqlSession.insert(namespace + ".addSchedule",dto);
	}
		
	
}
