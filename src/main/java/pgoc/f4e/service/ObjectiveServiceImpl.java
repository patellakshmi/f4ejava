package pgoc.f4e.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pgoc.f4e.constants.Constant;
import pgoc.f4e.constants.ErrorCodeConstant;
import pgoc.f4e.models.Course;
import pgoc.f4e.models.Objective;
import pgoc.f4e.models.SliderImage;
import pgoc.f4e.pojos.common.ErrorResponse;
import pgoc.f4e.pojos.requests.ObjectiveRequest;
import pgoc.f4e.pojos.responses.GenericResponse;
import pgoc.f4e.repositories.ObjectiveRepository;

import java.util.List;

@Service
public class ObjectiveServiceImpl implements ObjectiveService{

    @Autowired
    ObjectiveRepository objectiveRepository;

    @Override
    public ResponseEntity<GenericResponse> getObjective() {
        List<Objective> objectives = objectiveRepository.getAll();
        return new ResponseEntity<GenericResponse>(
                new GenericResponse( Constant.STATUS.SUCCESS.name(),
                        Constant.GET_ALL_COURSE,objectives ),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> createObjective(ObjectiveRequest objectiveRequest) {


        Objective objective = objectiveRepository.getByNameAndObjective(objectiveRequest.getName(), objectiveRequest.getObjective());
        if( objective == null){
            objective = new Objective(objectiveRequest);
            objectiveRepository.save(objective);
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse( Constant.STATUS.SUCCESS.name(),
                            Constant.OBJECTIVE_CREATED ),
                    HttpStatus.OK);
        }

        return new ResponseEntity<GenericResponse>(
                new GenericResponse( Constant.STATUS.FAILURE.name(),
                        ErrorCodeConstant.FAILED_TO_CREATED_OBJECTIVE, ErrorResponse.builder()
                        .errorCode(ErrorCodeConstant.ErrorCode.FAILED_TO_CREATED_OBJECTIVE.name())
                        .desc(ErrorCodeConstant.ErrorCode.FAILED_TO_CREATED_OBJECTIVE.desc()).build() ),
                HttpStatus.BAD_REQUEST);
    }
}
