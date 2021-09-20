package pgoc.f4e.controllers;

import com.newrelic.api.agent.Trace;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pgoc.f4e.configs.helper.AuthUser;
import pgoc.f4e.constants.APIConstant;
import pgoc.f4e.models.PotentialUser;
import pgoc.f4e.pojos.responses.GenericResponse;
import pgoc.f4e.repositories.PotentialUserRepo;
import pgoc.f4e.utility.AuthUtility;
import pgoc.f4e.utility.IdGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class LoginController {

    private PotentialUserRepo potentialUserRepo;

    private PasswordEncoder passwordEncoder;

    public LoginController(PotentialUserRepo potentialUserRepo, PasswordEncoder passwordEncoder) {
        this.potentialUserRepo = potentialUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(APIConstant.SIGNUP)
    public ResponseEntity<GenericResponse> signUp(@RequestBody AuthUser authUser, HttpServletRequest request, HttpServletResponse response) throws ServletException, JSONException, IOException {
        authUser.setPassword(this.passwordEncoder.encode(authUser.getPassword()));
        PotentialUser existingUser = potentialUserRepo.findByAnyOfUniqueField(authUser.getUsername());
        if( existingUser != null){
            return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS", "DONE"), HttpStatus.FOUND);
        }
        PotentialUser potentialUser = PotentialUser.builder().userId(authUser.getUsername()).password(authUser.getPassword()).build();
        potentialUserRepo.save(potentialUser);
        AuthUtility.aadAuthHeader(request, response, authUser);
        return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS", "DONE"), HttpStatus.OK);
    }


    @Trace
    @PostMapping(APIConstant.LOGIN)
    public ResponseEntity<GenericResponse> login(@RequestBody AuthUser authUser) throws IOException {
        return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS", "DONE"), HttpStatus.OK);
    }

    @PostMapping(APIConstant.TEST)
    public ResponseEntity<GenericResponse> test(@RequestBody AuthUser authUser){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String principal = authentication.getPrincipal().toString();
        return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS", "DONE",
                IdGenerator.getUniqueId()), HttpStatus.OK);
    }
}
