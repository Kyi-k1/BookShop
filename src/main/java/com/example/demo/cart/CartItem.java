package com.example.demo.cart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class CartItem {
	private long id;
	private String imageUrl;
	private String title;
	private double price;
	private String authorName;
	private String categoryName;
}
