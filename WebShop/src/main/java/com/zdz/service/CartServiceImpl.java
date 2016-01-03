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
	public boolean addCart(Member member, Merchandise mer, int number)
			throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		Cart cart = new Cart();
		cart.setMember(member);
		cart.getMerchandises().add(mer);
		cartMapper.newCart(cart);
		Cartselectedmer cartselectedmer = new Cartselectedmer();
		cartselectedmer.setMerchandise(mer.getId());
		cartselectedmer.setCart(cart.getId());
		cartselectedmer.setNumber(number);
		cartselectedmer.setPrice(100.0);// price应该是从数据库中取出才对
		cartselectedmer.setMoney(number*100.0);

		sqlSession.commit();
		sqlSession.close();

		return cartMapper.addCartselectedmer(cartselectedmer);
	}

	@Override
	public List browseCart(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		List list = cartMapper.browseCart(member);
		
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public boolean clearCart(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		boolean b = cartMapper.clearCart(member);
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean modiCart(Integer id, int number) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		boolean b = cartMapper.modiCart(id, number);
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean delCart(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		boolean b = cartMapper.delCart(id);
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public Cart loadCart(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		Cart cart = cartMapper.loadCart(member);
		
		sqlSession.commit();
		sqlSession.close();
		return cart;
	}

	@Override
	public boolean updateCart(Cart cart) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		
		boolean b = cartMapper.updateCart(cart);
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}
	
}
