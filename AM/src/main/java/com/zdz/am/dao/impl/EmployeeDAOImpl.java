package com.zdz.am.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.am.dao.EmployeeDAO;
import com.zdz.am.mapper.EmployeeMapper;
import com.zdz.am.model.Employee;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public void addEmployee(Employee employee) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		
		employeeMapper.addEmployee(employee);
		
		sqlSession.commit();
		sqlSession.close();
	}

	public void deleteEmployee(int employeeID) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		
		employeeMapper.deleteEmployee(employeeID);
		
		sqlSession.commit();
		sqlSession.close();
	}

	public List<Employee> findAllEmployee() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		
		List list = employeeMapper.findAllEmployee();
		
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	public Employee findEmployeeById(int employeeID) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		
		Employee employee = employeeMapper.findEmployeeById(employeeID);
		
		sqlSession.commit();
		sqlSession.close();
		return employee;
	}
	public void updateEmployee(Employee employee) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		
		employeeMapper.updateEmployee(employee);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
}
