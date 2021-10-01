package com.demo.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.book.entity.Review;



	@SpringBootTest
	public class ReviewServiceTest {
		
		@Autowired
		IReviewService reviewService;
		
		@Test
		@Disabled
		void testGetAllReview() {
			Review std1 = new Review();
			std1.setReviewId(68888);
			std1.setComment("qwerbbbbbbbbb");
			std1.setHeadLine("as");
			std1.setRating(5);
			
			
			Review std2 = new Review();
			std2.setReviewId(68888);
			std2.setComment("qwerbbbbbbbbb");
			std2.setHeadLine("as");
			std2.setRating(5);
			List<Review> address = reviewService.listAllReviews(); 
			assertEquals(2, address.size());
			assertEquals(68888, address.get(0).getReviewId());
			assertEquals("qwerbbbbbbbbb", address.get(0).getComment());
			assertEquals("as", address.get(0).getHeadLine());
			assertEquals(5, address.get(0).getRating());
			
			assertEquals(6, address.get(1).getReviewId());
			assertEquals("bbbbbb", address.get(1).getComment());
			assertEquals("as", address.get(1).getHeadLine());
			assertEquals(4, address.get(1).getRating());
			
		}
		
		
		@Test
		@Disabled
		void testAddReview() {
			Review rev = new Review();
			rev.setReviewId(68888);
			rev.setComment("qwerbbbbbbbbb");
			rev.setHeadLine("as");
			rev.setRating(5);		
			Review review= reviewService.addReview(rev);
			assertEquals(68888, review.getReviewId());
			assertEquals("qwerbbbbbbbbb", review.getComment());
			assertEquals("as", review.getHeadLine());
			assertEquals(5, review.getRating());
		}
		
		@Test
	//	@Disabled
		void testDeletereviewByReview() {
			Review review = reviewService.deleteReviewByReview(68888);
			assertEquals(68888, review.getReviewId());
			assertEquals("qwerbbbbbbbbb", review.getComment());
			assertEquals("as", review.getHeadLine());
			assertEquals(5, review.getRating());
		}
		
		
	
		
		@Test
		 @Disabled
		void testUpdateReview() {
			Review std1 = new Review();
			
			std1.setReviewId(68888);
			std1.setComment("qwerbbbbbbbbb");
			std1.setHeadLine("as");
			std1.setRating(5);;
			Review review = reviewService.updateReview(68888,std1);
			assertEquals(68888, review.getReviewId());
			assertEquals("qwerbbbbbbbbb", review.getComment());
			assertEquals("as", review.getHeadLine());
			assertEquals(5, review.getRating());
		}
		}
	
	
	
