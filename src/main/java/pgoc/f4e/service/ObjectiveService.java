package pgoc.f4e.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pgoc.f4e.pojos.requests.CourseRequest;
import pgoc.f4e.pojos.requests.ObjectiveRequest;
import pgoc.f4e.pojos.responses.GenericResponse;

@Service
public interface ObjectiveService {
    ResponseEntity<GenericResponse> getObjective();
    ResponseEntity<GenericResponse> createObjective(ObjectiveRequest objectiveRequest);
}
