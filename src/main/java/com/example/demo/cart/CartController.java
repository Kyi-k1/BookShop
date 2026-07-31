package com.example.demo.cart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
	private final CartService cartService;
	
	// /cart/view-cart
	@GetMapping("/view-cart")
	public String viewCart(Model model) {
		model.addAttribute("cartItems",cartService.getCartItems());
		return "cart/cartView";
	}
	
	public String clearCart() {
		cartService.clearCart();
		return "cart/cartView";
	}
	
	// /cart/remove?id=1
	@GetMapping("/remove")
	public String removeFromCart(@RequestParam("id")long id) {
		cartService.remove(id);
		return "redirect:/cart/view-cart";
	}
	@ModelAttribute("totalPrice")
	public double totalPrice() {
		return cartService.getCartItems()
				.stream()
				.map(item -> item.getPrice())
				.mapToDouble(Double::doubleValue)
				.sum();
	}
}
