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
import pgoc.f4e.pojos.requests.ObjectiveRequest;
import pgoc.f4e.pojos.responses.GenericResponse;
import pgoc.f4e.service.ObjectiveService;

@Slf4j
@RestController
public class ObjectiveController {

    @Autowired
    ObjectiveService objectiveService;

    @GetMapping(APIConstant.OBJECTIVE)
    public ResponseEntity<GenericResponse> createCourse(){
        return objectiveService.getObjective();
    }

    @PostMapping(APIConstant.OBJECTIVE)
    public ResponseEntity<GenericResponse> createCourse(@RequestBody ObjectiveRequest objectiveRequest){
        return objectiveService.createObjective(objectiveRequest);
    }
}
