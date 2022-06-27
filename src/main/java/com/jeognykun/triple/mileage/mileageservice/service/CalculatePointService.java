package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.domain.Review;
import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.repository.ReviewRepository;
import com.jeognykun.triple.mileage.mileageservice.type.ActionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalculatePointService {

    private final ReviewRepository reviewRepository;
    private final Review review;

    public long contentAndPhotoPointCalculate(EventRequest req) {
        long mileage;

        Review review = reviewRepository.findById(
                req.getReviewId()).orElse(
                Review.builder()
                        .content(0)
                        .photo(0)
                        .build());

        if(req.getAction().equals(ActionType.DELETE)) {
            return deleteAction(review);
        }

        if(review.getContent() == 0 && review.getPhoto() == 0) {
            mileage = hasPhotos(req.getAttachedPhotoIds())
                    + hasContent(req.getContent());
        } else {
            mileage = getMileage(req, review);
        }

        return mileage;
    }


    private long getMileage(EventRequest dto, Review review) {

        long mileage = 0;

        if(hasContent(dto.getContent()) == 1 && !hasContent(review.getContent())) {
            mileage += 1;
        }
        if(hasContent(dto.getContent()) != 1 && hasContent(review.getContent())) {
            mileage -= 1;
        }
        if(hasPhotos(dto.getAttachedPhotoIds()) == 1 && !hasPhotos(review.getPhoto())) {
            mileage += 1;
        }
        if(hasPhotos(dto.getAttachedPhotoIds()) != 1 && hasPhotos(review.getPhoto())) {
            mileage -= 1;
        }

        return mileage;

    }

    private long deleteAction(Review review) {
        long mileage = 0;

        if(hasContent(review.getContent())) mileage += 1;
        if(hasPhotos(review.getPhoto())) mileage += 1;

        return mileage*-1;
    }

    private int hasPhotos(List<String> list) {
        return list.size() > 0 ? 1 : 0;
    }

    private boolean hasContent(int content) {
        return content > 0;
    }

    private boolean hasPhotos(int photosSize) {
        return photosSize > 0;
    }

    private int hasContent(String content) {
        return content.length() > 0 ? 1 : 0;
    }
}
