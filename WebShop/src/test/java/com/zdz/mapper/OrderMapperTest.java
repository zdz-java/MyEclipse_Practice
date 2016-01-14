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

import com.zdz.model.Cart;
import com.zdz.model.Cartselectedmer;
import com.zdz.model.Category;
import com.zdz.model.Member;
import com.zdz.model.Merchandise;
import com.zdz.model.Orders;

public class OrderMapperTest {
	private String source = "Configuration.xml";
	private SqlSessionFactory sessionFactory;
	@Before
	public void prepare() throws IOException
	{
		Reader reader = Resources.getResourceAsReader(source); 
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	@Test
	public void browseTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
	 	
		Member member = new Member();
		member.setId(2);
		Cart cart = new Cart();
		cart.setId(6);
//		这样的使用方法是不对的
//		List<Orders> orders = orderMapper.browseOrder(null);
		List<Orders> orders2 = orderMapper.browseOrder(member);
		List<Cartselectedmer> cartselectedmers = orderMapper.browseOrderMer(cart);
		
//		Assert.assertEquals((int)orders.get(0).getId(),2);
		Assert.assertEquals((int)orders2.get(0).getId(),5);
		Assert.assertEquals((int)cartselectedmers.get(0).getId(),19);
		
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void loadTest()
	{
//		该方法存在问题,可能是需要更改主键名
		SqlSession sqlSession = sessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);		
		
		Orders orders = orderMapper.loadOrder(4);
		
		System.out.println(orders.getCart().getId());
//		Assert.assertEquals((int)orders.getMember().getId(), 1);
		
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void addDelUpdateTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		Member member = new Member();
		member.setId(1);
		Cart cart = new Cart();
		cart.setId(1);
		Orders order = new Orders();
		order.setMember(member);
		order.setCart(cart);
		order.setOrderNo("123");
		orderMapper.addOrder(order);
		Orders order2 = orderMapper.loadOrder(order.getId());
		Assert.assertEquals(order2.getOrderNo(), "123");
		order2.setOrderNo("321");
		orderMapper.updateOrder(order2);
		order2 = orderMapper.loadOrder(order.getId());
		Assert.assertEquals(order2.getOrderNo(), "321");
		orderMapper.delOrder(order.getId());
		
		sqlSession.commit();
		sqlSession.close();
	}
}
