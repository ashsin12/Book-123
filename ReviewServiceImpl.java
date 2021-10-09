package com.demo.book.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.demo.book.dao.IBookDao;
import com.demo.book.dao.ICustomerDao;
import com.demo.book.dao.IReviewDao;
import com.demo.book.dto.ReviewDto;
import com.demo.book.entity.Book;
import com.demo.book.entity.Customer;
import com.demo.book.entity.Review;
import com.demo.book.exception.ReviewNotFoundException;

@Service
public class ReviewServiceImpl implements IReviewService{
     
	
	@Autowired
	IReviewDao reviewDao;
	@Autowired
	ICustomerDao customerDao;
	@Autowired
	IBookDao bookDao;
	
	public static Logger logger = LogManager.getLogger();

	@Override
	public List<Review> listAllReviews() {
		return reviewDao.findAll();
	}

	@Override
	public Review getReviewByReviewId(int reviewId) throws ReviewNotFoundException {
		Optional<Review> review = reviewDao.findById(reviewId);
		if(!review.isPresent()) {
			throw new ReviewNotFoundException("Review not found with given ReviewId "+reviewId);
		}
		return review.get();
	}
	
	@Override
	public Review addReview(ReviewDto reviewDto) {
		logger.info(reviewDto.getCustomerId());
	    Customer customer=customerDao.findById(reviewDto.getCustomerId()).get();
		Book book=bookDao.findById(reviewDto.getBookId()).get();
		logger.info(book);
		Review review =new Review();
		review.setComment(reviewDto.getComment());
		review.setHeadLine(reviewDto.getHeadLine());
		review.setRating(reviewDto.getRating());
		review.setReviewOn(reviewDto.getReviewOn());
        review.setBook(book);
        review.setCustomer(customer);
        logger.info(review);
		return  reviewDao.save(review);
	}
	
   @Override
   public Review deleteReviewByReview(int reviewId) {
	   Review rev = reviewDao.findById(reviewId).get();
	   reviewDao.deleteById(reviewId);
		return rev;
	  
	}
     @Override
     	public Review updateReview(int reviewId, Review review) {
    	 Review rev = reviewDao.findById(reviewId).get();
 		rev.setComment(review.getComment());
 		rev.setHeadLine(review.getHeadLine());
 		return reviewDao.save(rev) ;
     }


	


}