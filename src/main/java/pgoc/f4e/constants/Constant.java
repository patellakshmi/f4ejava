package pgoc.f4e.constants;

import lombok.ToString;

public class Constant {
    public static final String UNMATCHED_FMT_TYPE= "Invalid type";

    @ToString
    public enum STATUS {
        SUCCESSFUL("SUCCESSFUL"),
        FAILURE("FAILURE");

        private final String name;
        STATUS(String name) {
            this.name = name;
        }
    }
}
