package com.demo.book.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.demo.book.entity.Review;

public interface IReviewDao extends JpaRepository<Review, Integer> {

	//Review listAllReviewsByBook(int bookId);

	//Review findByreviewById(int reviewId);

	 @Query(value="select r from Review r where r.reviewId=?1")
     List<Review> findListReview(int customerId);
	    

	

}
