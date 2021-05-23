package test;

import java.sql.Connection;
import java.sql.SQLException;

import com.victer.utils.PropertiesUtils;

public class test {
	public static void main(String[] args) throws SQLException{
		Connection connection = PropertiesUtils.getDataSource().getConnection();
	}

}
