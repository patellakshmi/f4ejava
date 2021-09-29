package pgoc.f4e.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pgoc.f4e.constants.Constant;
import pgoc.f4e.constants.ErrorCodeConstant;
import pgoc.f4e.models.Course;
import pgoc.f4e.models.SliderImage;
import pgoc.f4e.pojos.common.ErrorResponse;
import pgoc.f4e.pojos.requests.SliderImageRequest;
import pgoc.f4e.pojos.responses.GenericResponse;
import pgoc.f4e.repositories.SliderImageRepository;

import java.util.List;

@Service
public class SliderServiceImpl implements SliderService{

    @Autowired
    SliderImageRepository sliderImageRepository;

    @Override
    public ResponseEntity<GenericResponse> getAllSliderImage() {
        List<SliderImage> sliderImages = sliderImageRepository.getAllSliders();
        return new ResponseEntity<GenericResponse>(
                new GenericResponse( Constant.STATUS.SUCCESS.name(),
                        Constant.GET_ALL_SLIDER,sliderImages ),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> createSliderImage(SliderImageRequest sliderImageRequest) {

        SliderImage sliderImage = sliderImageRepository.getByImageUrl(sliderImageRequest.getImageUrl());
        if( sliderImage == null){
            sliderImage = new SliderImage(sliderImageRequest);
            sliderImageRepository.save(sliderImage);
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse( Constant.STATUS.SUCCESS.name(),
                            Constant.SLIDER_CREATED ),
                    HttpStatus.OK);
        }

        return new ResponseEntity<GenericResponse>(
                new GenericResponse( Constant.STATUS.FAILURE.name(),
                        ErrorCodeConstant.FAILED_TO_CREATED_SLIDER, ErrorResponse.builder()
                        .errorCode(ErrorCodeConstant.ErrorCode.FAILED_TO_CREATED_SLIDER.name())
                        .desc(ErrorCodeConstant.ErrorCode.FAILED_TO_CREATED_SLIDER.desc()).build() ),
                HttpStatus.BAD_REQUEST);
    }
}
