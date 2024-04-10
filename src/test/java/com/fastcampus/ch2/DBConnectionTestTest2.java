package com.fastcampus.ch2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.*;
import java.sql.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBConnectionTestTest2 {
//
//	@Autowired
//	ApplicationContext ac; 

	@Autowired
	DataSource ds;
	
	@Test
	public void test() throws SQLException {
		//fail("Not yet implemented");
		
////		   ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
//	        DataSource ds = ac.getBean(DataSource.class);

	        Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.

	        System.out.println("conn = " + conn);
	        assertTrue(conn!=null);
	}

}
