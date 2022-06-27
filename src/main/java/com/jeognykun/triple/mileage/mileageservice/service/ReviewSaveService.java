package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.domain.Review;
import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.exception.ReviewNotFoundException;
import com.jeognykun.triple.mileage.mileageservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewSaveService {

    private final ReviewRepository reviewRepository;

    public Review save(EventRequest dto) {
        return reviewRepository.save(Review.builder()
                .reviewId(dto.getReviewId())
                .content(dto.getContent().length())
                .photo(dto.getAttachedPhotoIds().size())
                .build());
    }

    public Review hasReview(String reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException(reviewId));
    }
}
