package pgoc.f4e.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pgoc.f4e.models.Subject;
import pgoc.f4e.pojos.requests.CoursePlatformRequest;
import pgoc.f4e.pojos.requests.CourseRequest;
import pgoc.f4e.pojos.requests.PlatformDetailRequest;
import pgoc.f4e.pojos.requests.SubjectRequest;
import pgoc.f4e.pojos.responses.GenericResponse;

import java.util.List;

@Service
public interface CourseService {
    ResponseEntity<GenericResponse> getCourse();
    ResponseEntity<GenericResponse> createCourse(CourseRequest courseRequest);
    ResponseEntity<GenericResponse> deleteCourse(String courseId);
    ResponseEntity<GenericResponse> addPlatformDetail(PlatformDetailRequest platformDetailRequest);
    ResponseEntity<GenericResponse> deletePlatformDetail(String courseId, String platformName);
    ResponseEntity<GenericResponse> createCoursePlatform(CoursePlatformRequest coursePlatformRequest);
    ResponseEntity<GenericResponse> deleteCoursePlatform(String name);
    ResponseEntity<GenericResponse> addCourseSubject(SubjectRequest subjectRequest);
    ResponseEntity<GenericResponse> deleteCourseSubject(String name);
}
