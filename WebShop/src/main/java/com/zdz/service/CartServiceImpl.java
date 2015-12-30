package com.zdz.service;

import java.util.List;

import com.zdz.mapper.CartMapper;
import com.zdz.model.Cart;
import com.zdz.model.Cartselectedmer;
import com.zdz.model.Member;
import com.zdz.model.Merchandise;

public class CartServiceImpl implements CartService {
	private CartMapper cartMapper;

	public CartMapper getCartMapper() {
		return cartMapper;
	}

	public void setCartMapper(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}

	@Override
	public boolean addCart(Member member, Merchandise mer, int number)
			throws Exception {
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
		return cartMapper.addCartselectedmer(cartselectedmer);
	}

	@Override
	public List browseCart(Member member) throws Exception {
		return cartMapper.browseCart(member);
	}

	@Override
	public boolean clearCart(Member member) throws Exception {
		return cartMapper.clearCart(member);
	}

	@Override
	public boolean modiCart(Integer id, int number) throws Exception {
		return cartMapper.modiCart(id, number);
	}

	@Override
	public boolean delCart(Integer id) throws Exception {
		return cartMapper.delCart(id);
	}

	@Override
	public Cart loadCart(Member member) throws Exception {
		return cartMapper.loadCart(member);
	}

	@Override
	public boolean updateCart(Cart cart) throws Exception {
		return cartMapper.updateCart(cart);
	}
	
}
