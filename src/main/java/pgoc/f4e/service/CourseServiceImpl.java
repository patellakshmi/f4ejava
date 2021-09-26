package pgoc.f4e.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pgoc.f4e.constants.Constant;
import pgoc.f4e.constants.ErrorCodeConstant;
import pgoc.f4e.models.Batch;
import pgoc.f4e.models.Course;
import pgoc.f4e.models.Subject;
import pgoc.f4e.models.SubjectPart;
import pgoc.f4e.pojos.common.ErrorResponse;
import pgoc.f4e.pojos.requests.*;
import pgoc.f4e.pojos.responses.CourseResponse;
import pgoc.f4e.pojos.responses.GenericResponse;
import pgoc.f4e.repositories.BatchRepository;
import pgoc.f4e.repositories.CourseRepository;
import pgoc.f4e.repositories.SubjectRepository;
import pgoc.f4e.utility.IdValidator;

import java.util.List;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BatchRepository batchRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public ResponseEntity<GenericResponse> createCourse(CourseRequest courseRequest) {

        if( !IdValidator.isValid(courseRequest.getId()) ){
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse( Constant.STATUS.FAILURE.name(),
                            ErrorCodeConstant.INVALID_ID, ErrorResponse.builder()
                                    .errorCode(ErrorCodeConstant.ErrorCode.INVALID_ID.name())
                                    .desc(ErrorCodeConstant.ErrorCode.INVALID_ID.desc()).build()),
                    HttpStatus.BAD_REQUEST );
        }
        courseRequest.setId(courseRequest.getId().toUpperCase());
        Optional<Course> courseOptional = courseRepository.findById(courseRequest.getId());
        if( courseOptional.isPresent()){
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse( Constant.STATUS.FAILURE.name(),
                            ErrorCodeConstant.ALREADY_FOUND, ErrorResponse.builder()
                            .errorCode(ErrorCodeConstant.ErrorCode.COURSE_ALREADY_EXIST.name())
                            .desc(ErrorCodeConstant.ErrorCode.COURSE_ALREADY_EXIST.desc()).build()),
                    HttpStatus.OK );
        }

        Course course = new Course(courseRequest);
        try{ courseRepository.save(course); }
        catch (Exception e){
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse( Constant.STATUS.FAILURE.name(),
                            ErrorCodeConstant.ERROR_TO_SAVE, ErrorResponse.builder()
                            .errorCode(ErrorCodeConstant.ErrorCode.FAILED_TO_SAVE.name())
                            .desc(ErrorCodeConstant.ErrorCode.FAILED_TO_SAVE.desc()).build()),
                    HttpStatus.OK );
        }

        CourseResponse courseResponse = CourseResponse.builder()
                .id(course.getId()).name(course.getName())
                .streamStd(course.getStreamStd()).mode(course.getMode()).build();

        return new ResponseEntity<GenericResponse>(
                new GenericResponse( Constant.STATUS.SUCCESS.name(),
                        Constant.COURSE_CREATED, courseResponse),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> deleteCourse(String courseId) {
        List<Batch> batches = batchRepository.findByCourseId(courseId);
        if(!batches.isEmpty()){
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse( Constant.STATUS.FAILURE.name(),
                            ErrorCodeConstant.FAILED_TO_DELETE_COURSE, ErrorResponse.builder()
                            .errorCode(ErrorCodeConstant.ErrorCode.BATCH_ALREADY_ALLOCATED.name())
                            .desc(ErrorCodeConstant.ErrorCode.BATCH_ALREADY_ALLOCATED.desc()).build()),
                    HttpStatus.BAD_REQUEST );
        }else{
            Optional<Course> courses = courseRepository.findById(courseId);
            courseRepository.delete(courses.get());
        }

        return new ResponseEntity<GenericResponse>(
                new GenericResponse( Constant.STATUS.SUCCESS.name(),
                        Constant.SUCCESSFULLY_DELETE_COURSE),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> addPlatformDetail(PlatformDetailRequest platformDetailRequest) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse> deletePlatformDetail(String courseId, String platformName) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse> createCoursePlatform(CoursePlatformRequest coursePlatformRequest) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse> deleteCoursePlatform(String name) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse> addCourseSubject(SubjectRequest subjectRequest) {
        Course course = courseRepository.getById(subjectRequest.getCourse_id());
        if(course == null){
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse( Constant.STATUS.FAILURE.name(),
                            ErrorCodeConstant.FAILED_TO_ADD_SUBJECT, ErrorResponse.builder()
                            .errorCode(ErrorCodeConstant.ErrorCode.FAILED_TO_CREATE_SUBJECT.name())
                            .desc(ErrorCodeConstant.ErrorCode.FAILED_TO_CREATE_SUBJECT.desc()).build()),
                    HttpStatus.BAD_REQUEST );
        }

        if(IdValidator.isValidSubjectId(subjectRequest.getId())){
            for(SubjectPartRequest subjectPartRequest: subjectRequest.getSubjectParts()){
                if(!IdValidator.isValidSubjectPartId(subjectPartRequest.getId())){
                    return new ResponseEntity<GenericResponse>(
                            new GenericResponse( Constant.STATUS.FAILURE.name(),
                                    ErrorCodeConstant.FAILED_TO_ADD_SUBJECT, ErrorResponse.builder()
                                    .errorCode(ErrorCodeConstant.ErrorCode.INVALID_SUB_PART_ID.name())
                                    .desc(ErrorCodeConstant.ErrorCode.INVALID_SUB_PART_ID.desc()).build()),
                            HttpStatus.BAD_REQUEST );
                }
            }
        }else{
            return new ResponseEntity<GenericResponse>(
                    new GenericResponse( Constant.STATUS.FAILURE.name(),
                            ErrorCodeConstant.FAILED_TO_ADD_SUBJECT, ErrorResponse.builder()
                            .errorCode(ErrorCodeConstant.ErrorCode.INVALID_SUB_ID.name())
                            .desc(ErrorCodeConstant.ErrorCode.INVALID_SUB_ID.desc()).build()),
                    HttpStatus.BAD_REQUEST );
        }

        Subject subject = new Subject(subjectRequest);
        subjectRepository.save(subject);
        return new ResponseEntity<GenericResponse>(
                new GenericResponse( Constant.STATUS.SUCCESS.name(),
                        Constant.SUBJECT_CREATED),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> deleteCourseSubject(String name) {
        return null;
    }

}
