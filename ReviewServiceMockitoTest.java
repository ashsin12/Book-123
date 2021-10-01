package com.demo.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.book.dao.IReviewDao;
import com.demo.book.entity.Address;
import com.demo.book.entity.Review;
import com.demo.book.exception.ReviewNotFoundException;

@ExtendWith(SpringExtension.class)
public class ReviewServiceMockitoTest {

	@InjectMocks
	ReviewServiceImpl reviewService;

	// @MockBean - Creates Mock of a class or interface

	@MockBean
	IReviewDao reviewDao;

	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetReviewByReviewId() throws ReviewNotFoundException {
		Review review = new Review();
		review.setReviewId(68888);
		review.setComment("qwerbbbbbbbbb");
		review.setHeadLine("as");
		review.setRating(5);
		Mockito.when(reviewDao.findById(68888)).thenReturn(Optional.of(review));
		Review rev= reviewService.getReviewByReviewId(68888);
		assertEquals(68888, rev.getReviewId());
		assertEquals("qwerbbbbbbbbb", rev.getComment());
		assertEquals("as", rev.getHeadLine());
		assertEquals(5, rev.getRating());
	}
	
	@Test
	void testGetAllReview() {
		Review review= new Review();
		review.setReviewId(68888);
		review.setComment("qwerbbbbbbbbb");
		review.setHeadLine("as");
		review.setRating(5);
		Review review2= new Review();
		review2.setReviewId(6);
		review2.setComment("bbbbbb");
		review2.setHeadLine("as");
		review2.setRating(4);
		List<Review> studentList = new ArrayList<>();
		studentList.add(review);
		
		studentList.add(review2);
		Mockito.when(reviewDao.findAll()).thenReturn(studentList);
		List<Review> Review = reviewService.listAllReviews();
		assertEquals(2, Review.size());
		assertEquals("qwerbbbbbbbbb", Review.get(0).getComment());
		assertEquals("as", Review.get(0).getHeadLine());
		assertEquals(5, Review.get(0).getRating());
		assertEquals("bbbbbb", Review.get(1).getComment());
		assertEquals("as", Review.get(1).getHeadLine());
		assertEquals(4, Review.get(1).getRating());
	}
	
	@Test
	void testAddReview() {
		Review review = new Review();
		review.setReviewId(68888);
		review.setComment("qwerbbbbbbbbb");
		review.setHeadLine("as");
		review.setRating(5);
		Mockito.when(reviewDao.save(review)).thenReturn(review);
		Review rev = reviewService.addReview(review);
		assertEquals("qwerbbbbbbbbb", rev.getComment());
		assertEquals("as", rev.getHeadLine());
		assertEquals(5, rev.getRating());
	}
	
	/*
	 * Verify update review by roll no method
	 */
	@Test
	void testUpdateReview() {
		Review review = new Review();
		review.setReviewId(6);
		review.setComment("qwerbbbbbbbbb");
		review.setHeadLine("as");
		review.setRating(5);
		Mockito.when(reviewDao.findById(6)).thenReturn(Optional.of(review));
		Mockito.when(reviewDao.save(review)).thenReturn(review);
		Review rev = reviewService.updateReview(6, review);
		assertEquals("qwerbbbbbbbbb", rev.getComment());
		assertEquals("as", rev.getHeadLine());
		assertEquals(5, rev.getRating());
	}
	/*
	 * Verify delete student by roll no.
	 */
	@Test
	void testDeleteReview() {
		Review review = new Review();
		review.setReviewId(6);
		review.setComment("qwerbbbbbbbbb");
		review.setHeadLine("as");
		review.setRating(5);
		Mockito.when(reviewDao.findById(6)).thenReturn(Optional.of(review));
		reviewDao.deleteById(6);
		Review rev = reviewService.deleteReviewByReview(6);
		assertEquals("qwerbbbbbbbbb", rev.getComment());
		assertEquals("as", rev.getHeadLine());
		assertEquals(5, rev.getRating());
	}
}
