package com.example.demo.book;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.cart.CartService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
	private final BookService bookService;
	private final CartService cartService;
	
	// /book/details?id=1
	@GetMapping("/details")
	public String viewBookDetails(@RequestParam("id")long id,Model model) {
		model.addAttribute("book",bookService.findBookById(id));
		return "book/book";
	}
	
	// /book/add-cart?id=1
	@GetMapping("/add-cart")
	public String addToCart(@RequestParam("id")long id) {
		Book book = bookService.findBookById(id);
		cartService.addToCart(book);
		return "redirect:/book/details?id=" + id;
	}
	@ModelAttribute("cartSize")
	public int cartSize() {
		return cartService.getCartItems().size();
	}
	
	@GetMapping("/list-books")
	public String listAllBooks(Model model){
		model.addAttribute("books",bookService.listAllBooks());
		return "book/books";
	}
}
