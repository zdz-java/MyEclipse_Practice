package com.zdz.mapper;

import java.util.List;

import com.zdz.model.Cart;
import com.zdz.model.Cartselectedmer;
import com.zdz.model.Member;
import com.zdz.model.Merchandise;

public interface CartMapper {
//	addCart好像应该分解为两个方法
//	public boolean addCart(Member member,Merchandise mer,int number);
	public boolean addCartselectedmer(Cartselectedmer cartselectedmer);
//在实现的时候应该存完后再计算价钱后进行更新
	public boolean newCart(Cart cart);
	/** �鿴���ﳵ�е�ѡ����Ʒ */
	public List browseCart(Member member);		
	/** ��չ��ﳵ */	
	public boolean clearCart(Member member);		
//正确性存疑
	public boolean modiCart(Integer id,int number);	
//是否这两个方法都需要先删除关联表中的内容
	public boolean delCart(Integer id);
//	该方法与browseCart方法是否为重复了
	public Cart loadCart(Member member);
	/** ���¹��ﳵ */	
	public boolean updateCart(Cart cart);
}
