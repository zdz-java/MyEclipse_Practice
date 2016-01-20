package com.zdz.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.mapper.AdminMapper;
import com.zdz.mapper.CartMapper;
import com.zdz.model.Admin;
import com.zdz.model.Cart;
import com.zdz.model.Cartselectedmer;
import com.zdz.model.Member;
import com.zdz.model.Merchandise;
@Component
public class CartServiceImpl implements CartService {
private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public boolean addCart(Cart cart)
			{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		boolean b = cartMapper.newCart(cart);

		sqlSession.commit();
		sqlSession.close();

		return b;
	}

	@Override
	public List browseCart(Member member) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		List list = cartMapper.browseCart(member);
		
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public boolean clearCart(Member member) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		boolean b = cartMapper.clearCart(member);
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean modiCart(Integer id, int number){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		boolean b = cartMapper.modiCart(id, number);
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean delCart(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		boolean b = cartMapper.delCart(id);
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public Cart loadCart(Member member){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		Cart cart = cartMapper.loadCart(member);
		
		sqlSession.commit();
		sqlSession.close();
		return cart;
	}

	@Override
	public boolean updateCart(Cart cart){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		boolean b = cartMapper.updateCart(cart);
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}
	@Override
	public void addCartselectedmer(Cartselectedmer cartselectedmer) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		cartMapper.addCartselectedmer(cartselectedmer);
		
		sqlSession.commit();
		sqlSession.close();
		
	}
	
}
