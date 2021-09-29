package pgoc.f4e.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pgoc.f4e.constants.APIConstant;
import pgoc.f4e.pojos.requests.CourseRequest;
import pgoc.f4e.pojos.requests.SliderImageRequest;
import pgoc.f4e.pojos.responses.GenericResponse;
import pgoc.f4e.service.SliderService;

@Slf4j
@RestController
public class SliderController {

    @Autowired
    SliderService sliderService;

    @GetMapping(APIConstant.SLIDER_IMAGE)
    public ResponseEntity<GenericResponse> createCourse(){
        return sliderService.getAllSliderImage();
    }

    @PostMapping(APIConstant.SLIDER_IMAGE)
    public ResponseEntity<GenericResponse> createCourse(@RequestBody SliderImageRequest sliderImageRequest){
        return sliderService.createSliderImage(sliderImageRequest);
    }
}
