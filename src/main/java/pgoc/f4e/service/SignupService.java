package pgoc.f4e.service;

import org.codehaus.jettison.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pgoc.f4e.configs.helper.AuthUser;
import pgoc.f4e.pojos.responses.GenericResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public interface SignupService {
    ResponseEntity<GenericResponse> signupPotentialUser(AuthUser authUser, HttpServletRequest request, HttpServletResponse response) throws ServletException, JSONException, IOException;
}
