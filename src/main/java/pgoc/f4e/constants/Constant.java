package pgoc.f4e.constants;

import lombok.ToString;

public class Constant {
    public static final String UNMATCHED_FMT_TYPE= "Invalid type";
    public static final String COURSE_CREATED= "Course has been created successfully";
    public static final String SUCCESSFULLY_DELETE_COURSE = "Course deleted successfully";
    public static final String SUBJECT_CREATED = "Subject has been created successfully";



    @ToString
    public enum STATUS {
        SUCCESS("SUCCESS"),
        FAILURE("FAILURE");

        private final String name;
        STATUS(String name) {
            this.name = name;
        }
    }
}
