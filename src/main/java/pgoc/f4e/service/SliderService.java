package pgoc.f4e.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pgoc.f4e.pojos.requests.SliderImageRequest;
import pgoc.f4e.pojos.responses.GenericResponse;

@Service
public interface SliderService {
    ResponseEntity<GenericResponse> getAllSliderImage();
    ResponseEntity<GenericResponse> createSliderImage(SliderImageRequest sliderImageRequest);
}
