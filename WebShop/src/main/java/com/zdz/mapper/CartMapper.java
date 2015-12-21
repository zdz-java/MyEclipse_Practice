package com.zdz.mapper;

import java.util.List;

import com.zdz.model.Cart;
import com.zdz.model.Member;
import com.zdz.model.Merchandise;

public interface CartMapper {
//	未完成
	public boolean addCart(Member member,Merchandise mer,int number);
	/** �鿴���ﳵ�е�ѡ����Ʒ */
	public List browseCart(Member member);		
	/** ��չ��ﳵ */	
	public boolean clearCart(Member member);		
//正确性存疑
	public boolean modiCart(Integer id,int number);	
//是否这两个方法都需要先删除关联表中的内容
	public boolean delCart(Integer id);
	/** װ��ָ����Ա�Ĺ��ﳵ */	
	public Cart loadCart(Member member);
	/** ���¹��ﳵ */	
	public boolean updateCart(Cart cart);
}
