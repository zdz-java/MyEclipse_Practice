package com.zdz.mapper;

import java.util.List;

import com.zdz.model.Cart;
import com.zdz.model.Member;
import com.zdz.model.Orders;

public interface OrderMapper {
	public boolean addOrder(Orders order);
//	此重载方法不知道是否正确实现了
	public List browseOrder(Member member);
//	public List browseOrder();
	public List browseOrderMer(Cart cart);			
	public boolean delOrder(Integer id);	
	public Orders loadOrder(Integer id);
	public boolean updateOrder(Orders order);
}
