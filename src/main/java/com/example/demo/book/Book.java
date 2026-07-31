package com.example.demo.book;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.author.Author;
import com.example.demo.category.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(columnDefinition = "text")
	private String description;
	private String imageUrl;
	private int stocks;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="year_puplished")
	private LocalDate yearPuplished;
	private double price;
	@JoinColumn(name="category_id")
	@ManyToOne
	private Category category;
	@JoinColumn(name="author_id")
	@ManyToOne
	private Author author;
}
