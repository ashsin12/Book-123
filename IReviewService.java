package com.demo.book.service;

import java.util.List;

import javax.validation.Valid;

import com.demo.book.dto.ReviewDto;
import com.demo.book.entity.Book;
import com.demo.book.entity.Customer;
import com.demo.book.entity.Review;
import com.demo.book.exception.ReviewNotFoundException;

public interface IReviewService {

	List<Review> listAllReviews();

	
    Review deleteReviewByReview(int reviewId);

	Review updateReview(int reviewId, Review review);

	Review getReviewByReviewId(int reviewId) throws ReviewNotFoundException;

    Review addReview(@Valid ReviewDto reviewDto);

    Review listAllReviewsByBook(int bookId);
     
}
