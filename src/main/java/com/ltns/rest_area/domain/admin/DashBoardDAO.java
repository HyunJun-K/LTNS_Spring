package com.ltns.rest_area.domain.admin;

import com.ltns.rest_area.domain.DAO;

public interface DashBoardDAO extends DAO{
	int selectCnts();	
	int select_totalPost();
	int select_todayPost();
	int select_todayReports_post();
	int select_total_coment();
	int select_todayComent();
	
}
