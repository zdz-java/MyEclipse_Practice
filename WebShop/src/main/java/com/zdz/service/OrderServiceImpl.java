package com.zdz.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zdz.mapper.MerMapper;
import com.zdz.mapper.OrderMapper;
import com.zdz.model.Cart;
import com.zdz.model.Member;
import com.zdz.model.Orders;

public class OrderServiceImpl implements OrderService {
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public boolean addOrder(Orders order) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		boolean b = orderMapper.addOrder(order);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public List browseOrder(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		List list = orderMapper.browseOrder(member);

		sqlSession.commit();
		sqlSession.close();
		return list;
	}
//未实现
	@Override
	public List browseOrder() throws Exception {
		return null;
	}

	@Override
	public List browseOrderMer(Cart cart) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		List list = orderMapper.browseOrderMer(cart);

		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public boolean delOrder(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		boolean b = orderMapper.delOrder(id);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public Orders loadOrder(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		Orders order = orderMapper.loadOrder(id);

		sqlSession.commit();
		sqlSession.close();
		return order;
	}

	@Override
	public boolean updateOrder(Orders order) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		boolean b = orderMapper.updateOrder(order);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

}
