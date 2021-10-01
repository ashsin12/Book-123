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
	

      LocalDate  reviewOn;
    
    private Customer customer;

    

//  private Book book;

	
	public  Review () {}



public Review(int reviewId, String headLine, String comment, double rating, LocalDate reviewOn, Customer customer) {
	super();
	this.reviewId = reviewId;
	this.headLine = headLine;
	this.comment = comment;
	this.rating = rating;
	this.reviewOn = reviewOn;
	this.customer = customer;
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



public LocalDate getReviewOn() {
	return reviewOn;
}



public void setReviewOn(LocalDate reviewOn) {
	this.reviewOn = reviewOn;
}



public Customer getCustomer() {
	return customer;
}



public void setCustomer(Customer customer) {
	this.customer = customer;
}



@Override
public String toString() {
	return "Review [reviewId=" + reviewId + ", headLine=" + headLine + ", comment=" + comment + ", rating=" + rating
			+ ", reviewOn=" + reviewOn + ", customer=" + customer + "]";
}

}



		