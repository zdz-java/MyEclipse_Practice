package com.zdz.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zdz.model.Admin;
import com.zdz.model.Cart;
import com.zdz.model.Cartselectedmer;
import com.zdz.model.Member;

public class CartMapperTest {
	private String source = "Configuration.xml";
	private SqlSessionFactory sessionFactory;
	@Before
	public void prepare() throws IOException
	{
		Reader reader = Resources.getResourceAsReader(source); 
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
//	@Test
//	public void loadCartAndOtherTest()
//	{
//		SqlSession sqlSession = sessionFactory.openSession();
//		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
//		
//		Member member = new Member();
//		member.setId(2);
//		Cart cart = cartMapper.loadCart(member);
//		Assert.assertEquals((int)cart.getId(), 2);
//		Assert.assertEquals((int)cart.getMember().getId(), 2);
//		cart.setCartStatus(10);
//		cartMapper.updateCart(cart);
//		Assert.assertEquals((int)cart.getCartStatus(), 10);
//		cart.setCartStatus(1);
//		sqlSession.commit();
//		sqlSession.close();
//	}
//	该方法的单元测试应该配合add方法
	@Test
	public void delCartTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);

		cartMapper.delCart(10);
		Member member = new Member();
		member.setId(100);
		cartMapper.clearCart(member);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void modiCartTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);

		cartMapper.modiCart(20, 9, 3);
		
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void browseCartTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);

		Member member = new Member();
		member.setId(2);
		List<Cart> list = cartMapper.browseCart(member);
		Assert.assertEquals((int)list.get(0).getId(), 2);
		
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void newTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);

		Cart cart = new Cart();
		Member member = new Member();
		member.setId(1000);
		cart.setMember(member);
		cartMapper.newCart(cart);
		cartMapper.delCart(cart.getId());
		
		Cartselectedmer cartselectedmer = new Cartselectedmer();
		cartselectedmer.setCart(cart.getId());
		cartselectedmer.setMerchandise(1000);
		cartselectedmer.setNumber(1000);
		cartselectedmer.setPrice(1000.0);
		cartselectedmer.setMoney(10000.0);
		cartMapper.addCartselectedmer(cartselectedmer);
		
		
		sqlSession.commit();
		sqlSession.close();
	}
}
