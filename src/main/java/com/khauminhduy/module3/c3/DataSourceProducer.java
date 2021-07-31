package com.khauminhduy.module3.c3;

import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceProducer {

	public MysqlDataSource mySqldataSource = null;

	@Produces
	@MySqlDataSource
	public DataSource produceDataSource() {
		// read properties from somewhere here

		if (mySqldataSource == null) {
			mySqldataSource = new MysqlDataSource();
			mySqldataSource.setPassword("Aa123456!");
			mySqldataSource.setUser("root");
			mySqldataSource.setURL("jdbc:mysql://localhost:3306/classicmodels");
		}
		return mySqldataSource;
	}
}
