package com.zdz.am.mapper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zdz.am.model.Employee;
import com.zdz.am.model.Reply;

public class EmployeeMapperTest {
	private String resource;
	private InputStream inputStream;
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void prepare() throws IOException {
		resource = "mybatis-config.xml";
		inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}
	@Test
	public void findReplayByMsgIDTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		
		Employee employee = employeeMapper.findEmployeeById(3052);
		assertEquals(employee.getEmployeeName(), "李俊");
		
		session.commit();
		session.close();
	}
	@Test
	public void addEmployeeAndDleteTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		
		Employee toadd = new Employee();
		toadd.setEmployeeName("zdz");
		employeeMapper.addEmployee(toadd);
		session.commit();
		
		Employee employee = employeeMapper.findEmployeeById(toadd.getEmployeeID());
		assertEquals(employee.getEmployeeName(), "zdz");
		
		employeeMapper.deleteEmployee(toadd.getEmployeeID());
		
		session.commit();
		session.close();
	}
	@Test
	public void findAllEmployeeTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		
		Employee toadd = new Employee();
		toadd.setEmployeeName("zdz");
		employeeMapper.addEmployee(toadd);
		session.commit();
		
		Employee employee = employeeMapper.findEmployeeById(toadd.getEmployeeID());
		assertEquals(employee.getEmployeeName(), "zdz");
		
		employee.setEmployeeName("zdzdz");
		employeeMapper.updateEmployee(employee);
		session.commit();
		
		List<Employee> list = employeeMapper.findAllEmployee();
		assertEquals(list.get(list.size()-1).getEmployeeName(), "zdzdz");
		
		employeeMapper.deleteEmployee(toadd.getEmployeeID());
		
		session.commit();
		session.close();
	}
}
