package com.zdz.mapper;

import java.util.List;

import com.zdz.model.Cart;
import com.zdz.model.Member;
import com.zdz.model.Orders;

public interface OrderMapper {
	public boolean addOrder(Orders order);
	/** ���ĳ��Ա�����ж��� */
	public List browseOrder(Member member);
	/** ������ж��� */
	public List browseOrder();
	/** ���ĳ������������Ʒ��¼ */
	public List browseOrderMer(Cart cart);			
	public boolean delOrder(Integer id);	
	public Orders loadOrder(Integer id);
	public boolean updateOrder(Orders order);
}
