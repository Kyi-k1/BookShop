package com.example.demo.cart;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.book.Book;

@Service
@SessionScope
public class CartService {
	private Set<CartItem> cartItems=new HashSet<>();
	
	public void addToCart(Book book) {
		cartItems.add(toCartItem(book));
	}
	
	public void clearCart() {
		cartItems.clear();
	}
	
	public Set<CartItem> getCartItems() {
		return cartItems;
	}
	
	public void remove(long id) {
		this.cartItems=cartItems.stream()
		.filter(item -> item.getId() != id)
		.collect(Collectors.toCollection(HashSet::new));
	}
	
	private CartItem toCartItem(Book book) {
		return new CartItem(
				book.getId(), 
				book.getImageUrl(), 
				book.getTitle(), 
				book.getPrice(), 
				"%s %s"
				.formatted(book.getAuthor().getFirstName(),
							book.getAuthor().getLastName()),
				book.getCategory().getCategoryName());
	}
}
