package pgoc.f4e.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pgoc.f4e.constants.APIConstant;
import pgoc.f4e.constants.Constant;
import pgoc.f4e.models.CoursePlatform;
import pgoc.f4e.pojos.requests.CoursePlatformRequest;
import pgoc.f4e.pojos.requests.CourseRequest;
import pgoc.f4e.pojos.requests.PlatformDetailRequest;
import pgoc.f4e.pojos.requests.SubjectRequest;
import pgoc.f4e.pojos.responses.CourseResponse;
import pgoc.f4e.pojos.responses.GenericResponse;
import pgoc.f4e.service.CourseService;

import javax.ws.rs.QueryParam;

@Slf4j
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping(APIConstant.CREATE_COURSE)
    public ResponseEntity<GenericResponse> createCourse(@RequestBody CourseRequest courseRequest){
        return courseService.createCourse(courseRequest);
    }

    @DeleteMapping(APIConstant.DELETE_COURSE)
    public ResponseEntity<GenericResponse> deleteCourse(@QueryParam("courseId") String courseId){
        return courseService.deleteCourse(courseId);
    }

    @PostMapping(APIConstant.ADD_PLATFORM_DETAIL)
    public ResponseEntity<GenericResponse> addPlatformDetail(@RequestBody PlatformDetailRequest platformDetailRequest){
        return courseService.addPlatformDetail(platformDetailRequest);
    }


    @DeleteMapping(APIConstant.DELETE_PLATFORM_DETAIL)
    public ResponseEntity<GenericResponse> deletePlatformDetail(@QueryParam("courseId") String courseId,@QueryParam("platformName") String platformName){
        return courseService.deletePlatformDetail(courseId, platformName);
    }

    @PostMapping(APIConstant.CREATE_COURSE_PLATFORM)
    public ResponseEntity<GenericResponse> createCoursePlatform(@RequestBody CoursePlatformRequest coursePlatformRequest){
        return courseService.createCoursePlatform(coursePlatformRequest);
    }

    @DeleteMapping(APIConstant.DELETE_COURSE_PLATFORM)
    public ResponseEntity<GenericResponse> deleteCoursePlatform(@QueryParam("name") String name){
        return courseService.deleteCoursePlatform(name);
    }

    @PostMapping(APIConstant.ADD_COURSE_SUBJECT)
    public ResponseEntity<GenericResponse> createCourseSubject(@RequestBody SubjectRequest subjectRequest){
        return courseService.addCourseSubject(subjectRequest);
    }

    @DeleteMapping(APIConstant.DELETE_COURSE_SUBJECT)
    public ResponseEntity<GenericResponse> deleteCourseSubject(@QueryParam("name") String name){
        return courseService.deleteCourseSubject(name);
    }
}
