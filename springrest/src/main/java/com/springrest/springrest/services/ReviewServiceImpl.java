package com.springrest.springrest.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.ReviewDao;
import com.springrest.springrest.entities.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public Review addReview(Review review) {
		// TODO Auto-generated method stub
		review.setCreated_at(LocalDate.now());
		review.setUpdate_at(LocalDate.now());
		Review rev = reviewDao.save(review);
		return rev;
	}

}
