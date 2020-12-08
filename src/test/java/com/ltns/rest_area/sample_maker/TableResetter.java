package com.ltns.rest_area.sample_maker;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.ltns.rest_area.sample_maker.domain.RefreshTableDAO;

public class TableResetter {
	
	@Test
	public void refreshAllTable() throws SQLException {
		RefreshTableDAO dao=new RefreshTableDAO();
	
		dao.refreshAll();
	}
	
	
}
