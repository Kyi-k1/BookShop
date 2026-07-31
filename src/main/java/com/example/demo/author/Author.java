package com.example.demo.author;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.book.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String nationality;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	@OneToMany(mappedBy = "author")
	private List<Book> books =
			new ArrayList<>();
}
