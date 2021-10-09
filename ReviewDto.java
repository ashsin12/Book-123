package com.demo.book.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReviewDto {
	//private int reviewId;
	private String headLine;
	private String comment;
	private double rating;
	private int customerId;
	private int bookId;
	private LocalDate reviewOn;
}
