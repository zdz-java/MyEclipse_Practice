package com.zdz.service;

import java.util.*;

import com.zdz.model.Cart;
import com.zdz.model.Cartselectedmer;
import com.zdz.model.Member;
import com.zdz.model.Merchandise;

public interface CartService {
	/** ѡ����Ʒ */	
	public boolean addCart(Cart cart);
	/** �鿴���ﳵ�е�ѡ����Ʒ */
	public List browseCart(Member member);		
	/** ��չ��ﳵ */	
	public boolean clearCart(Member member);		
	/** ����ѡ����Ʒ������ */	
	public boolean modiCart(Integer id,int number);	
	/** ɾ����ѡ����Ʒ */	
	public boolean delCart(Integer id);
	/** װ��ָ����Ա�Ĺ��ﳵ */	
	public Cart loadCart(Member member);
	/** ���¹��ﳵ */	
	public boolean updateCart(Cart cart);
	public void addCartselectedmer(Cartselectedmer cartselectedmer);
}
