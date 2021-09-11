package pgoc.f4e.controllers;

import com.newrelic.api.agent.Trace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pgoc.f4e.constants.APIConstant;
import pgoc.f4e.models.User;
import pgoc.f4e.pojos.responses.GenericResponse;
import pgoc.f4e.repositories.UserRepository;

import java.io.IOException;

@Slf4j
@RestController
public class LoginController {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(APIConstant.SIGNUP)
    public ResponseEntity<GenericResponse> signUp(@RequestBody User user){
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS", "DONE"), HttpStatus.OK);
    }


    @Trace
    @PostMapping(APIConstant.LOGIN)
    public ResponseEntity<GenericResponse> login(@RequestBody User user) throws IOException {
        return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS", "DONE"), HttpStatus.OK);
    }


    @PostMapping(APIConstant.TEST)
    public ResponseEntity<GenericResponse> test(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String principal = authentication.getPrincipal().toString();
        return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS", "DONE",
                "token"), HttpStatus.OK);
    }
}
