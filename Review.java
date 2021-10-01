package com.demo.book.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="reviews")
public class Review {
     
	@Id
	@Column(name="reviewId")
	private int reviewId;
	
	
	
	@Column(name="headline")
	private String headLine;
	
	
	@Column(name="comment")
    private String comment;
	
	@Column(name=" rating")
	private double rating;
	

//	private LocalDate reviewOn;
//	
//    private Book book;
//	
//	private Customer customer;

	
	public  Review () {}

		
		public Review(int reviewId, String headLine, String comment, double rating) {
			super();
			this.reviewId = reviewId;
			this.headLine = headLine;
			this.comment = comment;
			this.rating = rating;
		}
		
		
		public int getReviewId() {
			return reviewId;
		}
		
		
		public void setReviewId(int reviewId) {
			this.reviewId = reviewId;
		}
		
		
		public String getHeadLine() {
			return headLine;
		}
		
		
		public void setHeadLine(String headLine) {
			this.headLine = headLine;
		}
		
		
		public String getComment() {
			return comment;
		}
		
		
		public void setComment(String comment) {
			this.comment = comment;
		}
		
		
		public double getRating() {
			return rating;
		}
		
		
		public void setRating(double rating) {
			this.rating = rating;
		}
		
		
		@Override
		public String toString() {
			return "Review [reviewId=" + reviewId + ", headLine=" + headLine + ", comment=" + comment + ", rating=" + rating
					+ "]";
		}
			

}
