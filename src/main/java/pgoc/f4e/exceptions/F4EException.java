package pgoc.f4e.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class F4EException extends RuntimeException {
    private HttpStatus errorCode;
    public F4EException(String msg) { super (msg); }
    public F4EException(String msg, HttpStatus errorCode) { super (msg); this.errorCode = errorCode;  }
    public F4EException(String msg, HttpStatus errorCode, Throwable cause) { super (msg, cause); this.errorCode = errorCode; }
    public F4EException(String msg, Throwable cause) {
        super (msg, cause);
    }
    public F4EException(Throwable cause) {
        super (cause);
    }
}