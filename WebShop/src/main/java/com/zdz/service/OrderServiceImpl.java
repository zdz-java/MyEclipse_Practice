package com.zdz.service;

import java.util.List;

import com.zdz.mapper.OrderMapper;
import com.zdz.model.Cart;
import com.zdz.model.Member;
import com.zdz.model.Orders;

public class OrderServiceImpl implements OrderService {
	private OrderMapper orderMapper;
	
	public OrderMapper getOrderMapper() {
		return orderMapper;
	}

	public void setOrderMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@Override
	public boolean addOrder(Orders order) throws Exception {
		return orderMapper.addOrder(order);
	}

	@Override
	public List browseOrder(Member member) throws Exception {
		return orderMapper.browseOrder(member);
	}
//未实现
	@Override
	public List browseOrder() throws Exception {
		return null;
	}

	@Override
	public List browseOrderMer(Cart cart) throws Exception {
		return orderMapper.browseOrderMer(cart);
	}

	@Override
	public boolean delOrder(Integer id) throws Exception {
		return orderMapper.delOrder(id);
	}

	@Override
	public Orders loadOrder(Integer id) throws Exception {
		return orderMapper.loadOrder(id);
	}

	@Override
	public boolean updateOrder(Orders order) throws Exception {
		return orderMapper.updateOrder(order);
	}

}
